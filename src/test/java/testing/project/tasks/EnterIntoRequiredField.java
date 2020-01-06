package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CardOrderForm;

public class EnterIntoRequiredField implements Task {
    @Override
    @Step("{0} enters empty value in a required field")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CardOrderForm.firstNameField()),
                Click.on(CardOrderForm.formHeader())); // click to refresh application input values
    }

    public static Performable anEmptyValue() {
        return Instrumented.instanceOf(EnterIntoRequiredField.class).withProperties();
    }
}
