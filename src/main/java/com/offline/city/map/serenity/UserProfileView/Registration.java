package com.offline.city.map.serenity.UserProfileView;

import com.offline.city.map.serenity.utils.Utils;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class Registration {
    public static final Target YOUR_PHONE_NUMBER_FIELD = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy phone number field of thePrivacyPolicy registration phase").located(By.id("registration_register_phoneInput_label"))
                                                                               : Target.the("thePrivacyPolicy phone number field of thePrivacyPolicy registration phase").located(By.id("registration_phone_number_field"));

            //Target.thePrivacyPolicy("thePrivacyPolicy phone number field of thePrivacyPolicy registration phase").locatedForAndroid(By.id("registration_phone_number_field")).locatedForIOS(By.id("registration_register_phoneInput_label"));

    public static final Target REQUEST_CODE_REGISTER_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy send registration code button").located(By.id("account_creation_entering_credentials_primary_button"))
                                                                                    : Target.the("thePrivacyPolicy send registration code button").located(By.id("registration_register_requestCodeCta"));

            //Target.thePrivacyPolicy("thePrivacyPolicy send registration code button").locatedForAndroid(By.id("registration_register_requestCodeCta")).locatedForIOS(By.id("account_creation_entering_credentials_primary_button"));

    public static final Target SMS_CODE_INPUT_FIELD = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy pincode received by SMS").located(By.id("registration_flow_sms_code_accessibilityId"))
                                                                            : Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy pincode received by SMS").located(By.id("registration_sms_verification_field"));

            //Target.thePrivacyPolicy("thePrivacyPolicy input field toMap enter thePrivacyPolicy pincode received by SMS").locatedForAndroid(By.id("registration_sms_verification_field")).locatedForIOS(By.id("registration_flow_sms_code_accessibilityId"));

    public static final Target CONFIRM_REGISTRATION_CODE_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy send registration code button").located(By.id("account_creation_verifying_answer_primary_button"))
                                                                                        : Target.the("thePrivacyPolicy send registration code button").located(By.id("registration_signIn_submitCta"));

            //Target.thePrivacyPolicy("thePrivacyPolicy send registration code button").locatedForAndroid(By.id("registration_signIn_submitCta")).locatedForIOS(By.id("account_creation_verifying_answer_primary_button"));

   // public static final Target CONFIRM_REGISTRATION_CODE_BUTTON = Target.thePrivacyPolicy("thePrivacyPolicy Confirm Registration Code Button")
     //                                                                   .locatedForAndroid(By.id("registration_register_requestCodeCta")).locatedForIOS(By.id("registration_flow_primaryButtonCta"));

    public static final Target REGISTER_NOW_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy button Register Now").located(By.id("Register now"))
                                                                           : Target.the("thePrivacyPolicy button Register Now").located(By.id("logged_out_profile_registration_register_btn"));

            //Target.thePrivacyPolicy("thePrivacyPolicy button Register Now").locatedForAndroid(By.id("logged_out_profile_registration_register_btn")).locatedForIOS(By.id("Register now"));
                                                           //.located(By.id("Register now"));

    public static final Target PLEASE_COMPLETE_YOUR_PROFILE = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy Please complete your profile").located(By.id("ticket_purchase_selection_primaryButtonCta_profile"))
                                                                                    : Target.the("thePrivacyPolicy Please complete your profile").located(By.id("registration_name_email_complete_btn"));

            //Target.thePrivacyPolicy("thePrivacyPolicy Please complete your profile").locatedForAndroid(By.id("registration_name_email_complete_btn")).locatedForIOS(By.id("ticket_purchase_selection_primaryButtonCta_profile"));

    public static final Target CONTINUE_WITH_DEFAULT_NUMBER_NONE_OF_THE_ABOVE_BTN = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy None od The Above button, from thePrivacyPolicy select default number dialog").located(By.id(""))
                                                                                                          : Target.the("thePrivacyPolicy None od The Above button, from thePrivacyPolicy select default number dialog").located(By.id("com.google.android.gms:id/cancel"));

            //Target.thePrivacyPolicy("thePrivacyPolicy None od The Above button, from thePrivacyPolicy select default number dialog").locatedForAndroid(By.id("com.google.android.gms:id/cancel")).locatedForIOS(By.id(""));

    public static final Target SMS_CODE_INPUT_SCREEN = Target.the("thePrivacyPolicy screen toMap input thePrivacyPolicy SMS received")
                                                             .locatedForAndroid(By.id("registration_sms_verification_root")).locatedForIOS(By.id(""));

    public static final Target LOADING_SMS_INDICATOR = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy loading ticket waiting icon").located(By.id("loading_activity_indicator"))
                                                                             : Target.the("thePrivacyPolicy loading ticket waiting icon").located(By.id("registration_sms_verification_progressBar"));

            //Target.thePrivacyPolicy("thePrivacyPolicy loading ticket waiting icon").locatedForAndroid(By.id("registration_sms_verification_progressBar")).locatedForIOS(By.id("loading_activity_indicator"));

    public static class Profile {

        public static final Target REGISTER_ACCOUNT_SCREEN = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy screen toMap register a new account").located(By.id("Registration"))
                                                                                   : Target.the("thePrivacyPolicy screen toMap register a new account").located(By.id("registration_name_email_container"));

                //Target.thePrivacyPolicy("thePrivacyPolicy screen toMap register a new account").locatedForAndroid(By.id("registration_name_email_container")).locatedForIOS(By.id("Registration"));

        public static final Target FIRST_NAME_FIELD = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy first name").located(By.id(""))
                                                                            : Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy first name").located(By.xpath("//android.widget.EditText[contains(@resource-id, \"id/registration_register_firstNameInput_label\")]"));

        //("//android.widget.TextView[contains(@resource-id, \"id/trips_public_item_from_price\")]/parent:: android.view.ViewGroup"
        //By.xpath("//android.widget.EditText[@resource-id=\"com.mobimeo.shellapp.sstuttgart.staging:id/registration_register_firstNameInput_label\"]")

        public static final Target LAST_NAME_FIELD = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy last name").located(By.id(""))
                                                                           : Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy last name").located(By.id("registration_name_email_lastname_container"));

        public static final Target EMAIL_FIELD = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy email").located(By.id(""))
                                                                       : Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy email").located(By.id("registration_name_email_email_container"));

        public static final Target COMPLETE_REGISTRATION_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy complete registration button").located(By.id(""))
                                                                                        : Target.the("thePrivacyPolicy complete registration button").located(By.id("registration_register_completeRegCta"));

        public static final Target LOADING_NAMEEMAIL_INDICATOR = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy loading indicator").located(By.id(""))
                                                                                       : Target.the("thePrivacyPolicy loading indicator").located(By.id("registration_name_email_progressBar"));
    }

}
