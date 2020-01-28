package com.offline.city.map.serenity.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class TapOn implements Interaction {

    Target targetToTap;

    public TapOn(Target targetToTap) {
        this.targetToTap = targetToTap;
    }

    @Override
    @Step("{0} taps on #targetToTap")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SilentTask.where(Click.on(targetToTap)));
                //net.serenitybdd.screenplay.SilentInteraction(Click.on(targetToTap));
    }

    public static Performable the(Target targetToTap) {
        return Instrumented.instanceOf(TapOn.class).withProperties(targetToTap);
    }
}
