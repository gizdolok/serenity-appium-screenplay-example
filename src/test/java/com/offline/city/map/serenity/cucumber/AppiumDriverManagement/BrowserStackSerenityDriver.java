package com.offline.city.map.serenity.cucumber.AppiumDriverManagement;


import com.offline.city.map.serenity.utils.SetCapabilities;

import com.offline.city.map.serenity.utils.SetTheLocation;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Iterator;

import io.appium.java_client.AppiumDriver;

/**
 * This class is responsible for starting the Appium Server, either on Browserstack remote devices by default
 * or, on your local Appium Server running on IP 127.0.0.1, in case you pass the parameter -Denvironment=local on runtime
 *
 * This class was initially downloaded from https://github.com/browserstack/serenity-browserstack/tree/master/src/test/java/com/browserstack
 * It has just been adapted, to make our mechanism of the Actors-Apps association, to work
 */
public class BrowserStackSerenityDriver implements DriverSource {

    URL browserStackURL;
    URL localURL;
    AppiumDriver appiumDriverToReturn;


    public BrowserStackSerenityDriver() {
        super();
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

        try {

            //if we send on runtime, the variable -Denvironment=local then the tests will start against your local Appium Server
            //make sure your local Appium Server is running on IP and port 127.0.0.1:4723
            if(environment!=null && environment.equalsIgnoreCase("local")){

                SetCapabilities.localCapabilities(capabilities);

                //return the localhost URL to start test on local Appium server
                localURL = new URL("http://127.0.0.1:4723/wd/hub");

                //associate URL with AppiumDriver class
                appiumDriverToReturn = new AppiumDriver(localURL, capabilities){};

                //Set the device's location for the corresponding Actor:
                SetTheLocation.ofTheDevice(appiumDriverToReturn);

                //this will start the remote device on local computer, with all the capabilities set:
                //the variable send on runtime -Dcontext=[android|iphone] (default is android) will control on which Device Type (Android or iOS) the test will run
                //the Actor's Name will control which App is Under Test
                return appiumDriverToReturn;

                //by default the test will try to start on Browserstack
            } else {

                //set whatever extra capabilities necessary for our test needs
                SetCapabilities.forBrowserStack(capabilities);

                //method responsible to start android or ios, and which app depending on the actor's name
                SetCapabilities.toStartDeviceForCurrentActor(capabilities);

                //return the browserstack URL to start test on browserstack Servers
                browserStackURL = new URL("https://" + username + ":" + accessKey + "@"
                        + environmentVariables.getProperty("browserstack.server") + "/wd/hub");

                //associate URL with AppiumDriver class
                appiumDriverToReturn = new AppiumDriver(browserStackURL, capabilities){};

                //Set the device's location for the corresponding Actor:
                SetTheLocation.ofTheDevice(appiumDriverToReturn);

                //this will start the remote device on Browserstack, with all the capabilities set:
                //the variable send on runtime -Dcontext=[android|iphone] (default is android) will control on which Device Type (Android or iOS) the test will run
                //the Actor's Name will control which App is Under Test
                return appiumDriverToReturn;
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
