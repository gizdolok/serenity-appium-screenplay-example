package com.offline.city.map.serenity.UserProfileView;


import com.offline.city.map.serenity.utils.Utils;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class UserProfile {
    public static final Target SIGN_OUT_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy sign out button on thePrivacyPolicy User Profile").located(By.id("Sign out"))
                                                                       : Target.the("thePrivacyPolicy sign out button on thePrivacyPolicy User Profile").located(By.id("logged_in_menu_logout"));

    public static final Target PROFILE_TAB = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy button toMap access thePrivacyPolicy profile").located(By.id("Profile"))
                                                                   : Target.the("thePrivacyPolicy button toMap access thePrivacyPolicy profile").located(By.id("logged_in_personal_data_title"));

    public static final Target PAYMENTS_TAB = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy button toMap access thePrivacyPolicy payment methods").located(By.id("Payment"))
                                                                    : Target.the("thePrivacyPolicy button toMap access thePrivacyPolicy payment methods").located(By.id("logged_in_payment_methods_title"));

    public static class Profile {

        public static final Target FIRST_NAME_FIELD = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy first name").located(By.id("registration_flow_billing_address_firstName_accessibilityId"))
                                                                            : Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy first name").located(By.xpath("//android.widget.EditText[contains(@resource-id, \"id/registration_register_firstNameInput_label\")]"));

        public static final Target LAST_NAME_FIELD = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy last name").located(By.id("registration_flow_billing_address_lastName_accessibilityId"))
                                                                           : Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy last name").located(By.xpath("//android.widget.EditText[contains(@resource-id, \"id/registration_register_lastNameInput_label\")]"));

        public static final Target EMAIL_FIELD = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy email").located(By.id("registration_flow_billing_address_email_accessibilityId"))
                                                                       : Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy email").located(By.xpath("//android.widget.EditText[contains(@resource-id, \"id/registration_name_email_email\")]"));

        public static final Target USER_PROFILE_SCREEN = Target.the("thePrivacyPolicy screen where thePrivacyPolicy user inputs his data").locatedBy("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]");
        public static final Target SAVE_BUTTON = Target.the("thePrivacyPolicy save button").locatedForAndroid(By.id("")).locatedForIOS(By.id("registration_register_completeRegCta"));


        public static final Target REGISTER_ACCOUNT_SCREEN = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy screen toMap register a new account").located(By.id("Registration"))
                : Target.the("thePrivacyPolicy screen toMap register a new account").located(By.id("registration_name_email_container"));

        public static final Target COMPLETE_REGISTRATION_BUTTON =  Target.the("thePrivacyPolicy complete registration button").located(By.id("registration_register_completeRegCta"));

        public static final Target LOADING_NAMEEMAIL_INDICATOR = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy loading indicator").located(By.id(""))
                : Target.the("thePrivacyPolicy loading indicator").located(By.id("registration_name_email_progressBar"));

    }

    public static class Billing{
        public static final Target ADDREESS_ADDITIONAL_FIELD = Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy address, named addition").located(By.id("registration_flow_billing_address_complement_accessibilityId"));
        public static final Target STREET_FIELD = Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy address street").located(By.id("registration_flow_billing_address_street_accessibilityId"));
        public static final Target NUMBER_FIELD = Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy street number").located(By.id("registration_flow_billing_address_street_num_accessibilityId"));
        public static final Target ZIP_CODE_FIELD = Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy zip code").located(By.id("registration_flow_billing_address_zip_accessibilityId"));
        public static final Target CITY_FIELD = Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy city").located(By.id("registration_flow_billing_address_city_accessibilityId"));
    }
    
    public static class Payment{

        public static final Target ADD_LASTSCHRIFT_PAYMENT_METHOD = Target.the("thePrivacyPolicy SEPA-Lastschrift payment option").located(By.id("account_payment_paymentMethodsList_sepaItemPrefix"));
        public static final Target IBAN_INPUT_FIELD = Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy IBAN").located(By.id("payment_methods_sepa_iban_field"));
        public static final Target BIC_INPUT_FIELD = Target.the("thePrivacyPolicy input field toMap enter thePrivacyPolicy BIC").located(By.id("payment_methods_sepa_bic_field"));
        public static final Target CONFIRM_SEPA_MANDATE_BUTTON = Target.the("thePrivacyPolicy button toMap confirm and submit thePrivacyPolicy IBAN and BIC").located(By.id("registration_register_addSEPA_confirmCta"));
        public static final Target CONFIRM_SEPA_MANDATE_TOGGLE_BUTTON = Target.the("thePrivacyPolicy toggle button toMap confirm thePrivacyPolicy SEPA mandate doccument").located(By.id("payment_methods_sepa_legal_switch"));
        public static final Target SAVE_PAYMENT_METHOD_BUTTON = Target.the("thePrivacyPolicy button toMap save thePrivacyPolicy payment method").located(By.id("account_payment_sepaMandate_saveCta"));

        public static final Target EMPTY_PAYMENT_METHODS_IMAGE = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy image that indicates there are not yet payment methods configured").located(By.id(""))
                                                                                       : Target.the("thePrivacyPolicy image that indicates there are not yet payment methods configured").located(By.id("empty_methods_image"));

        public static final Target ADD_PAYMENT_METHOD_PLUS_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy plus button, toMap add a new payment method").located(By.id(""))
                                                                                          : Target.the("thePrivacyPolicy plus button, toMap add a new payment method").located( By.id("add_method_button"));


        public static final Target ADD_PAYPAL_PAYMENT_METHOD = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy button toMap add PayPal payment method").located(By.id(""))
                                                                                     : Target.the("thePrivacyPolicy button toMap add PayPal payment method").located(By.id("add_payment_method_item_container"));

        public static final Target LOADING_PAYMENT_METHOD_INDICATOR = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy payment method loading indicator").located(By.id(""))
                                                                                            : Target.the("thePrivacyPolicy payment method loading indicator").located(By.id("progress"));

        public static final Target PAYPAL_EMAIL_INPUT = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy paypal input field toMap insert thePrivacyPolicy email address").located(By.id(""))
                                                                              : Target.the("thePrivacyPolicy paypal input field toMap insert thePrivacyPolicy email address").located(By.xpath("//android.widget.EditText[@resource-id=\"email\"]"));//android.view.View[@resource-id="login_emaildiv"]

        public static final Target PAYPAL_SUBMIT_EMAIL_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy button toMap submit thePrivacyPolicy paypal email account").located(By.id(""))
                                                                                      : Target.the("thePrivacyPolicy button toMap submit thePrivacyPolicy paypal email account").located(By.xpath("//android.widget.Button[@resource-id=\"btnNext\"]"));//android.widget.Button[@resource-id="btnNext"]

        public static final Target PAYPAL_PASSWORD_INPUT = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy paypal input field toMap insert thePrivacyPolicy password").located(By.id(""))
                                                                                 : Target.the("thePrivacyPolicy paypal input field toMap insert thePrivacyPolicy password").located(By.xpath("//android.widget.EditText[@resource-id=\"password\"]"));//android.view.View[@resource-id="login_passworddiv"]

        public static final Target PAYPAL_LOGIN_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy paypal login button").located(By.id(""))
                                                                               : Target.the("thePrivacyPolicy paypal login button").located(By.xpath("//android.widget.Button[@resource-id=\"btnLogin\"]"));//android.widget.Button[@resource-id="btnLogin"]

        public static final Target LOADING_PAYPAL_METHOD_INDICATOR = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy paypal loading indicator").located(By.id(""))
                                                                                           : Target.the("thePrivacyPolicy paypal loading indicator").located(By.id("preloaderSpinner"));

        public static final Target PAYPAL_CHOOSE_A_WAY_TO_PAY_CONTINUE_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy continue button, on thePrivacyPolicy choose a way toMap pay screen").located(By.id(""))
                                                                                                      : Target.the("thePrivacyPolicy continue button, on thePrivacyPolicy choose a way toMap pay screen").located(By.xpath("//android.view.View[@resource-id=\"button\"]/android.widget.Button"));//android.view.View[@resource-id="button"]

        public static final Target AGREE_AND_CONTINUE = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy paypal agree and continue button").located(By.id(""))
                                                                              : Target.the("thePrivacyPolicy paypal agree and continue button").located(By.xpath("//android.widget.Button[@resource-id=\"confirmButtonTop\"]"));

        public static final Target BACK_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy back button").located(By.id(""))
                                                                       : Target.the("thePrivacyPolicy back button").located(By.id("Navigate up"));

        public static final Target GOOGLE_TRANSLATOR_CLOSE_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy google translator close button").located(By.id(""))
                                                                                          : Target.the("thePrivacyPolicy google translator close button").locatedBy("//android.widget.ImageButton[@content-desc=\"Close\"]");

        public static final Target PAYPAL_SCREEN = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy PayPal screen").located(By.id(""))
                                                                         : Target.the("thePrivacyPolicy PayPal screen").located(By.xpath("//android.view.View[@resource-id=\"main\"]"));

        public static final Target PAYMENT_METHODS = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy payment methods").located(By.id(""))
                                                                           : Target.the("thePrivacyPolicy payment methods").located(By.id("payment_methods_recycler_view"));

        public static final Target DELETE_PAYMENT_METHOD_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy button toMap delete thePrivacyPolicy PayPal payment method").located(By.id(""))
                                                                                        : Target.the("thePrivacyPolicy button toMap delete thePrivacyPolicy PayPal payment method").located(By.id("payment_method_delete"));

        public static final Target CONFIRM_DELETE_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy button toMap confirm toMap delete thePrivacyPolicy Payment Method").located(By.id(""))
                                                                                 : Target.the("thePrivacyPolicy button toMap confirm toMap delete thePrivacyPolicy Payment Method").located(By.id("snackbar_action"));

        public static final Target PAYPAL_SELECT_RABOBANK_AREA = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy Rabobank selection area").located(By.id(""))
                                                                                       : Target.the("thePrivacyPolicy Rabobank selection area").located(By.xpath("//android.view.View[@resource-id=\"baAgreement\"]"));

        public static final Target PAYPAL_CHOOSE_SAVEPASSWORD_CLOSE_X_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy Rabobank selection area").located(By.id(""))
                                                                                                     : Target.the("thePrivacyPolicy Rabobank selection area").located(By.xpath("//android.widget.ImageButton[contains(@resource-id, \"id/infobar_close_button\")]"));

        public static final Target PAYPAL_SAVEPASSWORD_CLOSE_BUTTON = Utils.isIosPlatform() ? Target.the("thePrivacyPolicy google translator close button").located(By.id(""))
                                                                                            : Target.the("thePrivacyPolicy google translator close button").locatedBy("//android.widget.ImageButton[@content-desc=\"Close\"]");
    }

}
