package com.offline.city.map.serenity.utils;

 import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.html5.Location;

public class SetTheLocation {
    //General Var that was set on AncillaryMethods.setSerenityUsersLocationSessionVariable(usersLocation) method
    static String usersLocation = Serenity.sessionVariableCalled("usersLocation");

    static String actorName;

    public static void ofTheDevice(AppiumDriver appiumDriverToReturn){
        //Read back Serenity session variable from the method AncillaryMethods.startTheAppForActor(String commuterName)
        actorName = Serenity.sessionVariableCalled("commuterName");

        //Set the device's location for the corresponding Actor:
        //Berner - is in Berlin
        //Lodovico - is in London
        //Lisbet - is in Lisbon
        switch (actorName){

            case "Berner":
                appiumDriverToReturn.setLocation(new Location(52.5069704, 13.2846499, 100));
                break;

            case "Lodovico":
                appiumDriverToReturn.setLocation(new Location(51.5287718, -0.2416806, 100));
                break;

            case "Lisbet":
                appiumDriverToReturn.setLocation(new Location(38.7436883, -9.1952227, 100));
                break;

            default:
                System.out.println("No App found for actor " + actorName);
                break;
        }

    }
}
