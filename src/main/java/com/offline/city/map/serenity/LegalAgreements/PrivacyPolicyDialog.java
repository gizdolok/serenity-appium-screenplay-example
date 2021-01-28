package com.offline.city.map.serenity.LegalAgreements;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class PrivacyPolicyDialog {

    public static final Target ACCEPT_BUTTON = Target.the("the button to accept the Privacy Policy Dialog")
                                                        .locatedForAndroid(By.id("android:id/button1")).locatedForIOS(By.id(""));

    public static final Target DECLINE_BUTTON = Target.the("the button to decline the Privacy Policy Dialog")
            .locatedForAndroid(By.id("android:id/button2")).locatedForIOS(By.id(""));
}
