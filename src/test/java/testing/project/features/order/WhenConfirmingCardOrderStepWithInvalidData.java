package testing.project.features.order;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testing.project.questions.SecondStep;
import testing.project.tasks.ConfirmCardFirstStep;
import testing.project.tasks.StartWith;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class WhenConfirmingCardOrderStepWithInvalidData {
    @Managed
    WebDriver browser;

    @Test
    public void shouldNotBeAbleToSeeTheSecondStep() {
        Actor rm = new Actor("rm");

        givenThat(rm).can(BrowseTheWeb.with(browser));
        givenThat(rm).wasAbleTo(StartWith.cardOrderPage());
        when(rm).attemptsTo(ConfirmCardFirstStep.withNotFilledFields());
        then(rm).should(seeThat(SecondStep.isNotDisplayed()));
    }
}
