package com.offline.city.map.serenity.targets;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchField {
    public static final Target INPUT_TEXT = Target.the("thePrivacyPolicy search input field").locatedForAndroid(By.id("searchInput")).locatedForIOS(By.id(""));
}
