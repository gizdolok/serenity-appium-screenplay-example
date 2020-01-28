package com.offline.city.map.serenity.tasks;

import com.offline.city.map.serenity.interactions.TapOn;

import com.offline.city.map.serenity.targets.TipsAndTricksDialog;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class Skip implements Task {

    @Override
    @Step("{0} wants to skip thePrivacyPolicy on boarding screens")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(TapOn.the(TipsAndTricksDialog.OK_BUTTON));
    }

    public static Performable theTipsAndTricksDialog() {
        return Instrumented.instanceOf(Skip.class).newInstance();
    }
}
