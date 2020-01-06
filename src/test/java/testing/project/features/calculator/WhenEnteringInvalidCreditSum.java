package testing.project.features.calculator;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import testing.project.questions.CreditCalculatorPrice;
import testing.project.tasks.ChangeCreditSum;
import testing.project.tasks.StartWith;

import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenEnteringInvalidCreditSum {
    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToSeeDefaultCost() {
        Actor rm = new Actor("rm");

        givenThat(rm).can(BrowseTheWeb.with(browser));
        givenThat(rm).wasAbleTo(StartWith.creditCalculatorPage());
        when(rm).attemptsTo(ChangeCreditSum.toValue(0));
        then(rm).should(seeThat(CreditCalculatorPrice.is(), containsString("8 143"))); // credit cost has not changed
    }
}
