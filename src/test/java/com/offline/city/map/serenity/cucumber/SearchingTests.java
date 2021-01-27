package com.offline.city.map.serenity.cucumber;

import com.offline.city.map.serenity.BrowserStackSerenityTest;
;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.core.webdriver.RemoteDriver;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features   = "src/test/resources/features/search_locations",
        glue       = "com.offline.city.map.serenity.cucumber.steps",
        //snippets   = SnippetType.CAMELCASE,
        plugin     = {"pretty"},
        strict     = true,
        monochrome = true
        //junit      = "--step-notifications"
        //,dryRun = true

)
public class SearchingTests extends BrowserStackSerenityTest {

    @Managed(driver = "appium")
    public RemoteDriver driver;

}
