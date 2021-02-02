package com.offline.city.map.serenity.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenitySystemProperties;
import net.thucydides.core.ThucydidesSystemProperty;

public class AncillaryMethods {

    //if on the runtime, we don't pass the variable -Dcontext=[android|iphone] then, the tests will run on ANDROID by DEFAULT, because of this ternary operator:
    static private String deviceType = SerenitySystemProperties.getProperties().getValue(ThucydidesSystemProperty.CONTEXT) == null ? "android" : SerenitySystemProperties.getProperties().getValue(ThucydidesSystemProperty.CONTEXT) ;

    public static boolean isIosPlatform() {
        return deviceType.equalsIgnoreCase("iphone");
    }
    public static boolean isAndroidPlatform() {
        return deviceType.equalsIgnoreCase("android");
    }

    public static void startTheAppForActor(String commuterName){
        //This method just stores the actor's name in a Serenity Session Variable, so that we can read back on the method SetCapabilities.toStartDeviceForCurrentActor(DesiredCapabilities capabilities)
        Serenity.setSessionVariable("commuterName").to(commuterName);
    }
}
