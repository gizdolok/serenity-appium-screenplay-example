package com.offline.city.map.serenity.utils;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.offline.city.map.serenity.utils.AncillaryMethods.isAndroidPlatform;
import static com.offline.city.map.serenity.utils.AncillaryMethods.isIosPlatform;

public class SetCapabilities {

    static String actorName;
    static String scenarioName;
    static EnvironmentVariables environmentVariables;
    static Boolean forceAppToRestart;

    public static void forBrowserStack(DesiredCapabilities capabilities) {

        forceAppToRestart = Serenity.sessionVariableCalled("forceAppToRestart");

        if(forceAppToRestart != null && forceAppToRestart){
            //Uninstall and install App
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("fullReset", true);
        } else {
            //Normal Start
            //noReset needs always to be false in order for autoGrantPermissions to work
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("fullReset", false);
        }

        capabilities.setCapability("realMobile", true);

        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoDissmissAlerts", true);
        capabilities.setCapability("unicodeKeyboard", true);

        //Browserstack Dashboard Caps:
        //Serenity session variable from the method set_the_stage(Scenario scenario)
        scenarioName = Serenity.sessionVariableCalled("ScenarioName");

        capabilities.setCapability("project","City Map");
        capabilities.setCapability("name", scenarioName);

/*

        Examples of other capabilities we may use

        capabilities.setCapability("wdaStartupRetries", 6);
        capabilities.setCapability("wdaStartupRetryInterval", 7000);
        capabilities.setCapability("realMobile", true);
        capabilities.setCapability("locationContextEnabled", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoDissmissAlerts", true);
        capabilities.setCapability("locationServicesAuthorized", true);
        capabilities.setCapability("gpsEnabled", true);
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("language", "de_DE");
        capabilities.setCapability("locale", "de_DE");
        capabilities.setCapability("geoLocation", "DE");
        capabilities.setCapability("timezone", "Europe/Berlin");
        capabilities.setCapability("appium_version", "1.20.1");
        capabilities.setCapability("browserstack.appium_version", "1.17.0");
        capabilities.setCapability("newCommandTimeout", "30");
        capabilities.setCapability("acceptSslCert", true);
        capabilities.setCapability("calendarFormat", "gregorian");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability("waitForQuiescence", false);
        capabilities.setCapability("gpsEnabled", true);
        capabilities.setCapability("networkLogs", false);
        capabilities.setCapability("idleTimeout", "240");
        capabilities.setCapability("soTimeout", "600");
        capabilities.setCapability("appiumLogs", true);

        capabilities.setCapability("webStorageEnabled", true);
        capabilities.setCapability("debug", false);
        capabilities.setCapability("console", "info");//#'disable', 'errors', 'warnings', 'info' or 'verbose'
*/

    }

    public static void toStartDeviceForCurrentActor(DesiredCapabilities capabilities) {
        actorName = Serenity.sessionVariableCalled("commuterName");
        environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        capabilities.setCapability("networkConnectionEnabled", "true");

        if(isAndroidPlatform()){

            //Browserstack Dashboard Cap:
            capabilities.setCapability("build", "City Map Android");

            capabilities.setCapability("platformName", "ANDROID");
            capabilities.setCapability("platform", "android");
            capabilities.setCapability("os", "android");
            capabilities.setCapability("os_version", "9.0");
            capabilities.setCapability("device", "Samsung Galaxy S10");
            capabilities.setCapability("automationName", "Appium");    // uiautomator2 does not work on PayPal pages

            //Start the App for the corresponding Actor:
            //Berner - uses Berlin App
            //Lodovico - uses London App
            //Lisbet - uses Lisbon App
            switch (actorName){

                case "Berner":
                    capabilities.setCapability("app", environmentVariables.getProperty("browserstack.appBerlin"));
                    capabilities.setCapability("name", scenarioName + " on Berlin App");
                    break;

                case "Lodovico":
                    capabilities.setCapability("app",environmentVariables.getProperty("browserstack.appLondon"));
                    capabilities.setCapability("name", scenarioName + " on London App");
                    break;

                case "Lisbet":
                    capabilities.setCapability("app",environmentVariables.getProperty("browserstack.appLisbon"));
                    capabilities.setCapability("name", scenarioName + " on Lisbon App");
                    break;

                case "Michael":
                    Serenity.recordReportData().withTitle("Michael still doesn't have thePrivacyPolicy offline city map app").andContents("This test failed because MI is not implemented for Android");
                    break;

                default:
                    System.out.println("No App found for actor " + actorName);
                    break;
            }


        } else if(isIosPlatform()){

            capabilities.setCapability("platformName", "IOS");
            capabilities.setCapability("platform", "ios");
            capabilities.setCapability("os", "ios");
            capabilities.setCapability("os_version", "11");
            capabilities.setCapability("device", "iPhone 6");
            capabilities.setCapability("connectHardwareKeyboard", true);
            capabilities.setCapability("sendKeyStrategy", "oneByOne");

            //Start the App for the corresponding Actor:
            //Berner - uses Berlin App
            //Lodovico - uses London App
            //Lisbet - uses Lisbon App
            switch (actorName){

                case "Berner":
                    capabilities.setCapability("app","patrick785/berlin-offline-city-map-ios");
                    capabilities.setCapability("build", "City Map iOS");
                    break;

                case "Lodovico":
                    capabilities.setCapability("app","patrick785/london-offline-city-map-ios");
                    capabilities.setCapability("build", "Berlin iOS App");
                    break;

                case "Lisbet":
                    capabilities.setCapability("app","patrick785/lisbon-offline-city-map-ios");
                    capabilities.setCapability("build", "Berlin iOS App");
                    break;

                default:
                    System.out.println("No App found for actor " + actorName);
                    break;
            }

        }
    }

    public static void localCapabilities(DesiredCapabilities capabilities) {

/*
        //we can use this code, if we need to run a set of tests, without re-installing the app for every test

        forceAppToRestart = Serenity.sessionVariableCalled("forceAppToRestart");

        if(forceAppToRestart != null && forceAppToRestart){
            //Uninstall and install App
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("fullReset", true);
        } else {
            //Normal Start
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("fullReset", false);
        }*/

        capabilities.setCapability("webStorageEnabled", true);
        capabilities.setCapability("autoDissmissAlerts", true);

        //Read back Serenity session variable from the method Utils.startTheAppForActor(String commuterName)
        actorName = Serenity.sessionVariableCalled("commuterName");
        environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        if(isAndroidPlatform()){
            capabilities.setCapability("platformName", "ANDROID");

            capabilities.setCapability("platformVersion", "local.android.version");
            capabilities.setCapability("deviceName", "local.android.device.name");

            capabilities.setCapability("automationName", "appium");
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("autoAcceptAlerts", true);

            //Start the App for the corresponding Actor:
            //Berner - uses Berlin App
            //Lodovico - uses London App
            //Lisbet - uses Lisbon App
            switch (actorName){

                case "Berner":
                    capabilities.setCapability("app", environmentVariables.getProperty("localDevice.appBerlin.android"));
                    break;

                case "Lodovico":
                    capabilities.setCapability("app", environmentVariables.getProperty("localDevice.appLondon.android"));
                    break;

                case "Lisbet":
                    capabilities.setCapability("app", environmentVariables.getProperty("localDevice.appLisbon.android"));
                    break;
            }

        } else if(isIosPlatform()){
            capabilities.setCapability("platformName", "IOS");

            capabilities.setCapability("udid", "local.ios.udid");
            capabilities.setCapability("platformVersion", "local.ios.version");
            capabilities.setCapability("deviceName", "local.ios.device.name");
            capabilities.setCapability("xcodeOrgId", "local.ios.xcodeOrg.id");

            capabilities.setCapability("connectHardwareKeyboard", true);
            capabilities.setCapability("realMobile", true);
            capabilities.setCapability("sendKeyStrategy", "oneByOne");
            capabilities.setCapability("xcodeSigningId", "iPhone Developer");

            capabilities.setCapability("waitForQuiescence", false);
            capabilities.setCapability("acceptSslCert", true);
            capabilities.setCapability("automationName", "XCUITest");//XCUITest UIAutomation

            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("autoAcceptAlerts", true);

            //Start the App for the corresponding Actor:
            //Berner - uses Berlin App
            //Lodovico - uses London App
            //Lisbet - uses Lisbon App
            switch (actorName){

                case "Berner":
                    capabilities.setCapability("app", environmentVariables.getProperty("localDevice.appBerlin.ios"));
                    break;

                case "Lodovico":
                    capabilities.setCapability("app", environmentVariables.getProperty("localDevice.appLondon.ios"));
                    break;

                case "Lisbet":
                    capabilities.setCapability("app", environmentVariables.getProperty("localDevice.appLisbon.ios"));
                    break;

                default:
                    System.out.println("No App found for actor " + actorName);
                    break;
            }
        }
    }
}
