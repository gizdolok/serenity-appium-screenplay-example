package com.offline.city.map.serenity.tasks;

import com.offline.city.map.serenity.MenuBar.TopMenu;
import com.offline.city.map.serenity.interactions.TapOn;
import com.offline.city.map.serenity.targets.LocationsResultsList;
import com.offline.city.map.serenity.targets.SearchField;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;


public class Search implements Task {

    String location;

    public Search(String location) {
        this.location = location;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                            TapOn.the(TopMenu.SEARCH_BUTTON),
                            Enter.theValue(location).into(SearchField.INPUT_TEXT),
                            TapOn.the(LocationsResultsList.FIRST_ELEMENT)
                        );
    }

        public static Performable theLocation(String location) {
            return Instrumented.instanceOf(Accept.class).withProperties(location);
        }
}
