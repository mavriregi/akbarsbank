package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CardOrderForm;

public class ConfirmCardFirstStep implements Task {
    public enum TaskName {
        FILLED_FIELDS,
        NOT_FILLED_FIELDS
    };
    private TaskName taskName;

    public ConfirmCardFirstStep(TaskName taskName) {
        this.taskName = taskName;
    }

    @Override
    @Step("{0} enters empty value in a required field")
    public <T extends Actor> void performAs(T actor) {
        switch (taskName) {
            case FILLED_FIELDS:
                actor.attemptsTo(
                        Enter.theValue("Тестов").into(CardOrderForm.lastNameField()),
                        Enter.theValue("Тест").into(CardOrderForm.firstNameField()),
                        Enter.theValue("Тестович").into(CardOrderForm.middleNameField()),
                        Enter.theValue("01012000").into(CardOrderForm.birthDateField()),
                        Enter.theValue("9872640002").into(CardOrderForm.phoneNumberField()),
                        Enter.theValue("test@test.test").into(CardOrderForm.emailField()),
                        Click.on(CardOrderForm.sendFirstStepButton())
                );
                break;
            case NOT_FILLED_FIELDS:
                actor.attemptsTo(
                        Enter.theValue("Тестов").into(CardOrderForm.lastNameField()),
                        Enter.theValue("").into(CardOrderForm.firstNameField()), // this field is required but empty
                        Enter.theValue("Тестович").into(CardOrderForm.middleNameField()),
                        Enter.theValue("01012000").into(CardOrderForm.birthDateField()),
                        Enter.theValue("9872640002").into(CardOrderForm.phoneNumberField()),
                        Enter.theValue("test@test.test").into(CardOrderForm.emailField()),
                        Click.on(CardOrderForm.sendFirstStepButton())
                );
                break;
            default:
                break;
        }
    }

    public static Performable withFilledFields() {
        return Instrumented.instanceOf(ConfirmCardFirstStep.class).withProperties(TaskName.FILLED_FIELDS);
    }
    public static Performable withNotFilledFields() {
        return Instrumented.instanceOf(ConfirmCardFirstStep.class).withProperties(TaskName.NOT_FILLED_FIELDS);
    }
}
