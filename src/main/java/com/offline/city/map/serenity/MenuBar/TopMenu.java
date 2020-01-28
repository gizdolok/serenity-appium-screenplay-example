package com.offline.city.map.serenity.MenuBar;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class TopMenu {
    public static final Target SEARCH_BUTTON = Target.the("thePrivacyPolicy search button").locatedForAndroid(By.id("Search")).locatedForIOS(By.id(""));
}
