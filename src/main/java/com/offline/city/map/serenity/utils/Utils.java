package com.offline.city.map.serenity.utils;

import net.serenitybdd.core.Serenity;
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

    //static String deviceName;
    static private String deviceType;// = Serenity.sessionVariableCalled("deviceType");

    public static String getPlatform() {

        deviceType = Serenity.sessionVariableCalled("deviceType");
        //String.valueOf(driver.getCapabilities().getCapability("platformName"));
        if (deviceType.equalsIgnoreCase("iphone"))
                return "ios";
        else return "android";
    }
    public static boolean isIosPlatform() {
        deviceType = Serenity.sessionVariableCalled("deviceType");
        return deviceType.equalsIgnoreCase("iphone");
    }
    public static boolean isAndroidPlatform() {
        deviceType = Serenity.sessionVariableCalled("deviceType");
        return deviceType.equalsIgnoreCase("android");
    }

    public static boolean isBrowserstackIos() {

        return deviceType.contains("iPhone");
    }

    public static boolean isBrowserstackAndroid() {

        return deviceType.contains("android");
    }

    public static Map<String, List<String>> convertListOfListsToMapOfLists(List<List<String>> listOflist){

        Map<String, List<String>> mapOfLists = new HashMap<String, List<String>>();

        mapOfLists.put(listOflist.get(0).get(0), listOflist.get(0).subList(1, listOflist.get(0).size()));
        mapOfLists.put(listOflist.get(1).get(0), listOflist.get(1).subList(1, listOflist.get(0).size()));
        mapOfLists.put(listOflist.get(2).get(0), listOflist.get(2).subList(1, listOflist.get(0).size()));
        mapOfLists.put(listOflist.get(3).get(0), listOflist.get(3).subList(1, listOflist.get(0).size()));
        return mapOfLists;
    }

    public static void scrollUpFromElementToPixel(WebElement webElementFacade, int verticalScrollingPixelAmount, int waitingTime) {

        //Serenity.getWebdriverManager().getWebdriver()

        MobileDriver mobileDriver = (MobileDriver)((WebDriverFacade) Serenity.getWebdriverManager().getWebdriver()).getProxiedDriver();

        int startX = webElementFacade.getLocation().getX() + (webElementFacade.getSize().getWidth() / 2);
        int startY = webElementFacade.getLocation().getY() + (webElementFacade.getSize().getHeight() / 2);

        //since its a vertical scroll, thePrivacyPolicy endX position is thePrivacyPolicy same as startX, only endY controls thePrivacyPolicy swiping distance:
        int endX = startX;
        int endY = startY - verticalScrollingPixelAmount;

        TouchAction scrollUpToSelectAnotherDay = new TouchAction(mobileDriver)
                .press(point(startX,startY))
                .waitAction(waitOptions(ofMillis(waitingTime)))
                .moveTo(point(endX, endY))
                .release();
        scrollUpToSelectAnotherDay.perform();
    }
}
