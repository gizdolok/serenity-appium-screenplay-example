package com.offline.city.map.serenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class Launch implements Task {

    @Override
    @Step("{0} launches thePrivacyPolicy Mobility App")
    public <T extends Actor> void performAs(T actor) {

        //code just in case there is some pre-action needed, before starting thePrivacyPolicy test

    }

    public static Performable theApp() {
        return new Launch();
                //instrumented(Launch.class); (toMap make it show on thePrivacyPolicy reports)
    }
}
