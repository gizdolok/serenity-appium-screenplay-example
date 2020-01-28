package com.offline.city.map.serenity.tasks;

import com.offline.city.map.serenity.LegalAgreements.PrivacyPolicyDialog;
import com.offline.city.map.serenity.interactions.TapOn;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Accept implements Task {

    @Override
    @Step("{0} wants toMap accept the Privacy Policy")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(TapOn.the(PrivacyPolicyDialog.ACCEPT_BUTTON));

    }

    public static Performable thePrivacyPolicy() {
        return instrumented(Accept.class);
    }
}
