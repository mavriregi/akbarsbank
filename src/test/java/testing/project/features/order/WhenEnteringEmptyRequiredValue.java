package testing.project.features.order;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testing.project.questions.RequiredFieldErrorMessage;
import testing.project.tasks.EnterIntoRequiredField;
import testing.project.tasks.StartWith;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenEnteringEmptyRequiredValue {
    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToSeeFieldErrorStatus() {
        Actor rm = new Actor("rm");

        givenThat(rm).can(BrowseTheWeb.with(browser));
        givenThat(rm).wasAbleTo(StartWith.cardOrderPage());
        when(rm).attemptsTo(EnterIntoRequiredField.anEmptyValue());
        then(rm).should(seeThat(RequiredFieldErrorMessage.is(), containsString("Заполните поле")));
    }
}
