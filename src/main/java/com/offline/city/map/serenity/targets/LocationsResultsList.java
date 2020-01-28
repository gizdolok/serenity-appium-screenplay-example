package com.offline.city.map.serenity.targets;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LocationsResultsList {
    public static final Target FIRST_ELEMENT = Target.the("thePrivacyPolicy first location that shows on top").locatedForAndroid(By.id("icon")).locatedForIOS(By.id(""));
}
