package com.offline.city.map.serenity.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenitySystemProperties;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.webdriver.WebDriverFacade;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class Utils {

    static private String deviceType = SerenitySystemProperties.getProperties().getValue(ThucydidesSystemProperty.CONTEXT);

    public static boolean isIosPlatform() {
        deviceType = Serenity.sessionVariableCalled("deviceType");
        return deviceType.equalsIgnoreCase("iphone");
    }
    public static boolean isAndroidPlatform() {
        deviceType = Serenity.sessionVariableCalled("deviceType");
        return deviceType.equalsIgnoreCase("android");
    }
}
