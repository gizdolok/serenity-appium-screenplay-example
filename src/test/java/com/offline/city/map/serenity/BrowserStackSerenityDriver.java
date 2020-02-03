package com.offline.city.map.serenity;


import net.serenitybdd.core.Serenity;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Iterator;

import io.appium.java_client.AppiumDriver;

import static com.offline.city.map.serenity.utils.Utils.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BrowserStackSerenityDriver implements DriverSource {

    String actorName;
    String scenarioName;

    public BrowserStackSerenityDriver() {
        this.actorName = Serenity.sessionVariableCalled("commuterName");
        this.scenarioName = Serenity.sessionVariableCalled("ScenarioName");
    }

    public AppiumDriver newDriver() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if (username == null) {
            username = (String) environmentVariables.getProperty("browserstack.user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if (accessKey == null) {
            accessKey = (String) environmentVariables.getProperty("browserstack.key");
        }

        String environment = System.getProperty("environment");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Iterator it = environmentVariables.getKeys().iterator();

        while (it.hasNext()) {

            String key = (String) it.next();

            if (key.equals("browserstack.user") || key.equals("browserstack.key") || key.equals("browserstack.server")) {

                continue;

            } else if (key.startsWith("bstack_")) {

                capabilities.setCapability(key.replace("bstack_", ""), environmentVariables.getProperty(key));

                if (key.equals("bstack_browserstack.local")
                        && environmentVariables.getProperty(key).equalsIgnoreCase("true")) {

                    System.setProperty("browserstack.local", "true");
                }

            } else if (environment != null && key.startsWith("environment." + environment)) {

                capabilities.setCapability(key.replace("environment." + environment + ".", ""),
                        environmentVariables.getProperty(key));

                if (key.equals("environment." + environment + ".browserstack.local")
                        && environmentVariables.getProperty(key).equalsIgnoreCase("true")) {

                    System.setProperty("browserstack.local", "true");
                }
            }
        }
        //RemoteWebDriver
        try {

            if(environment!=null && environment.contains("-local")){
                return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {};
            } else {

/*                actorName = Serenity.sessionVariableCalled("commuterName");
                scenarioName = Serenity.sessionVariableCalled("ScenarioName");*/

                //capabilities.setCapability("name", scenarioName);
                capabilities.setCapability("realMobile", true);

                capabilities.setCapability("autoGrantPermissions", true);
                capabilities.setCapability("autoAcceptAlerts", true);
                capabilities.setCapability("autoDissmissAlerts", true);
                capabilities.setCapability("unicodeKeyboard", true);

                capabilities.setCapability("project","City Map");

                if(isAndroidPlatform()){

                    capabilities.setCapability("platformName", "ANDROID");
                    capabilities.setCapability("platform", "android");
                    capabilities.setCapability("os", "android");
                    capabilities.setCapability("os_version", "9.0");
                    capabilities.setCapability("device", "Samsung Galaxy S10");
                    capabilities.setCapability("automationName", "Appium");    // uiautomator2 does not work on PayPal pages

                    //Broswserstack Caps:
                    capabilities.setCapability("build", "City Map Android");

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

                        case "Michael":
                            Serenity.recordReportData().withTitle("Michael still doesn't have thePrivacyPolicy offline city map app").andContents("This test failed because MI is not implemented for Android");
                            //driver.closeApp();
                            //driver.close();
                            //driver.quit();
                            break;

                        default:
                            System.out.println("No App found for actor " + actorName);
                            break;
                    }
                }

                return new AppiumDriver(new URL("https://" + username + ":" + accessKey + "@"
                        + environmentVariables.getProperty("browserstack.server") + "/wd/hub"), capabilities) {};
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean takesScreenshots() {
        return true;
    }
}
