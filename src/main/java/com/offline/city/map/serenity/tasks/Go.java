package com.offline.city.map.serenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Go implements Task {

    @Override
    @Step("{0} wants to go to the map")
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                                Accept.thePrivacyPolicyDialog(),
                                Skip.theTipsAndTricksDialog()
                            );
        }

    public static Performable toMap() {
        return instrumented(Go.class);
    }
}
