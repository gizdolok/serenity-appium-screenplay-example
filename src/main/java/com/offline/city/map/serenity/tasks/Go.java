package com.offline.city.map.serenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Go implements Task {


    public Go() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                                Accept.thePrivacyPolicy(),
                                Skip.theTipsAndTricksDialog()

                            );
        }


    public static Performable toMap() {
        return instrumented(Go.class);
    }
}
