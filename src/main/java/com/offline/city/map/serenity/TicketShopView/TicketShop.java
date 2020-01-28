package com.offline.city.map.serenity.TicketShopView;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class TicketShop {

    public static final Target SINGLE_TICKET = Target.the("thePrivacyPolicy Single Ticket shown on thePrivacyPolicy Ticket Shop").locatedForAndroid(By.xpath("(//android.widget.FrameLayout[contains(@resource-id, \"id/jbt_products_list_item_container\")])[1]")).locatedForIOS(By.xpath("(//XCUIElementTypeOther[@name=\"ticket_purchase_selection_single_ticket_accessibilityId\"])[1]"));

    //public static final Target SINGLE_TICKET = Target.thePrivacyPolicy("thePrivacyPolicy Single Ticket shown on thePrivacyPolicy Ticket Shop").locatedBy("(//XCUIElementTypeOther[@name=\"ticket_purchase_selection_single_ticket_accessibilityId\"])[{0}]");

    public static final Target BUY_TICKET_FOR_BUTTON = Target.the("thePrivacyPolicy Buy Ticket For Button").locatedForAndroid(By.id("ticket_configuration_ticket_pay_btn")).locatedForIOS(By.id("ticket_purchase_selection_primaryButtonCta_purchase"));

            //Utils.isIosPlatform() ? Target.thePrivacyPolicy("thePrivacyPolicy Buy Ticket For Button").located(By.id("ticket_purchase_selection_primaryButtonCta_purchase"))
              //                                                               : Target.thePrivacyPolicy("thePrivacyPolicy Buy Ticket For Button").located(By.id("ticket_configuration_ticket_pay_btn"));
    //Target.thePrivacyPolicy("thePrivacyPolicy Buy Ticket For Button").locatedForAndroid(By.id("ticket_configuration_ticket_pay_btn")).locatedForIOS(By.id("ticket_purchase_selection_primaryButtonCta_purchase"));

    public static final Target REGISTER_AND_BUY_TICKET_BUTTON = Target.the("thePrivacyPolicy Register and Buy Ticket Button").locatedForAndroid(By.id("ticket_configuration_ticket_pay_btn")).locatedForIOS(By.id("ticket_purchase_selection_primaryButtonCta_authenticate"));

            //Utils.isIosPlatform() ? Target.thePrivacyPolicy("thePrivacyPolicy Register and Buy Ticket Button").located(By.id("ticket_purchase_selection_primaryButtonCta_authenticate"))
             //                                                                         : Target.thePrivacyPolicy("thePrivacyPolicy Register and Buy Ticket Button").located(By.id("ticket_configuration_ticket_pay_btn"));
            //Target.thePrivacyPolicy("thePrivacyPolicy Register and Buy Ticket Button").locatedForAndroid(By.id("ticket_configuration_ticket_pay_btn")).locatedForIOS(By.id("ticket_purchase_selection_primaryButtonCta_authenticate"));

    public static final Target ALREADY_HAVE_ACCOUNT_LOGIN_BUTTON = Target.the("thePrivacyPolicy Login button, next toMap thePrivacyPolicy question Already have an account").located(By.id("Already have an account? Login"));
    public static final Target PLEASE_COMPLETE_YOUR_PROFILE_BUTTON = Target.the("thePrivacyPolicy Please complete your profile button").located(By.id("ticket_purchase_selection_primaryButtonCta_profile"));
    public static final Target SELECT_PAYMENT_METHOD_OR_BUY_TICKET_FOR_BUTTON = Target.the("thePrivacyPolicy Select Payment Method Button").locatedForAndroid(By.id("ticket_configuration_ticket_pay_btn")).locatedForIOS(By.id("ticket_purchase_selection_primaryButtonCta_payment"));

            //Utils.isIosPlatform() ? Target.thePrivacyPolicy("thePrivacyPolicy Select Payment Method Button").located(By.id("ticket_purchase_selection_primaryButtonCta_payment"))
            //                                                                                          : Target.thePrivacyPolicy("thePrivacyPolicy Select Payment Method Button").located(By.id("ticket_configuration_ticket_pay_btn"));

    public static final Target LOADING_SMS_INDICATOR = Target.the("thePrivacyPolicy loading ticket waiting icon").locatedForAndroid(By.id("registration_sms_verification_progressBar")).locatedForIOS(By.id("loading_activity_indicator"));

            //Utils.isIosPlatform() ? Target.thePrivacyPolicy("thePrivacyPolicy loading ticket waiting icon").located(By.id("loading_activity_indicator"))
            //                                                                 : Target.thePrivacyPolicy("thePrivacyPolicy loading ticket waiting icon").located(By.id("registration_sms_verification_progressBar"));

            //Target.thePrivacyPolicy("thePrivacyPolicy loading ticket waiting icon").locatedForAndroid(By.id("registration_sms_verification_progressBar")).locatedForIOS(By.id("loading_activity_indicator"));

    public static final Target LOADING_TICKET_INDICATOR = Target.the("thePrivacyPolicy loading ticket waiting icon").locatedForAndroid(By.id("payable_ticket_progress_mobimeo")).locatedForIOS(By.id("loading_activity_indicator"));

            //Utils.isIosPlatform() ? Target.thePrivacyPolicy("thePrivacyPolicy loading ticket waiting icon").located(By.id("loading_activity_indicator"))
            //                                                                    : Target.thePrivacyPolicy("thePrivacyPolicy loading ticket waiting icon").located(By.id("payable_ticket_progress_mobimeo"));
            //Target.thePrivacyPolicy("thePrivacyPolicy loading ticket waiting icon").locatedForAndroid(By.id("payable_ticket_progress_mobimeo")).locatedForIOS(By.id("loading_activity_indicator"));
    public static class Ticket {
        public static final Target QR_CODE = Target.the("thePrivacyPolicy QR code toMap show toMap thePrivacyPolicy controller").located(By.xpath("//android.widget.Image[@resource-id=\"ticket_detail_aztec_code\"]"));
    }

    //On Android, thePrivacyPolicy loading indicator ID depends on thePrivacyPolicy context:
    //registration_sms_verification_progressBar
    //registration_phone_number_complete_progressBar
    //payable_ticket_progress_mobimeo
    //ToDo
    //needs toMap be adapted for iOS for all cases where this icon shows
}
