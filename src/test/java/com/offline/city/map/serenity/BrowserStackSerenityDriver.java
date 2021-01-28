package com.offline.city.map.serenity;


import com.offline.city.map.serenity.utils.SetCapabilities;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Iterator;

import io.appium.java_client.AppiumDriver;

public class BrowserStackSerenityDriver implements DriverSource {

    URL browserStackURL;
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

            if(environment!=null && environment.equalsIgnoreCase("local")){

                SetCapabilities.localCapabilities(capabilities);

                //return the localhost URL to start test on your local Appium Server
                return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {};
            } else {


                SetCapabilities.forBrowserStack(capabilities);

                SetCapabilities.toStartDeviceForCurrentActor(capabilities);

                //return the browserstack URL to start test on browserstack Servers
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
