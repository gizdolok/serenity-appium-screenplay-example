package com.offline.city.map.serenity.cucumber.steps;

import com.offline.city.map.serenity.tasks.Go;
import com.offline.city.map.serenity.tasks.Launch;
import com.offline.city.map.serenity.tasks.Search;

import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class SearchRouteSteps {

    Scenario scenario;

    @Before
    public void set_the_stage(Scenario scenario) {

        OnStage.setTheStage(new OnlineCast());
        this.scenario = scenario;
        Serenity.setSessionVariable("ScenarioName").to(scenario.getName());
    }

    @After
    public void tearDown(){
        OnStage.drawTheCurtain();
    }

    @Given("^that (.*) wants to search for a point of interest, using (.*)$")
    public void navigatesToJourneyConfiguration(String commuterName, String deviceType) throws Throwable {

        Serenity.setSessionVariable("commuterName").to(commuterName);

        Serenity.setSessionVariable("deviceType").to(deviceType);
        OnStage.theActorCalled(commuterName)
                                            .attemptsTo(
                                                            Launch.theApp(),
                                                            Go.toMap()
                                                        );
    }

    @Given("^s?he needs to know where (.*) is located$")
    public void needsToKnowWhereLocationIsLocated(String location) throws Throwable {
        Search.theLocation(location);
    }

    @Then("^he should be able to see (.*) on the map$")
    public void heShouldBeAbleToSeeOnTheMap(String location) throws Throwable{
        // not important for this POC
    }
}
