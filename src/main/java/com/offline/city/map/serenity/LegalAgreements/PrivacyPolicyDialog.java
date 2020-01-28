package com.offline.city.map.serenity.LegalAgreements;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class PrivacyPolicyDialog {

    public static final Target ACCEPT_BUTTON = Target.the("thePrivacyPolicy Accept button from thePrivacyPolicy Data Policy Dialog")
                                                        .locatedForAndroid(By.id("button1")).locatedForIOS(By.id(""));

    public static final Target DECLINE_BUTTON = Target.the("thePrivacyPolicy Decline button from thePrivacyPolicy Data Policy Dialog")
            .locatedForAndroid(By.id("button2")).locatedForIOS(By.id(""));
}
