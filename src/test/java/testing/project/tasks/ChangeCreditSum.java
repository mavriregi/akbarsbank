package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CreditCalculator;

public class ChangeCreditSum implements Task {
    private final int value;

    public ChangeCreditSum(int value) {
        this.value = value;
    }

    @Override
    @Step("{0} enters a credit sum")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(String.valueOf(value)).into(CreditCalculator.sumField()),
                Click.on(CreditCalculator.monthCostResult())); // click to refresh application input values
    }

    public static Performable toValue(int value) {
        return Instrumented.instanceOf(ChangeCreditSum.class).withProperties(value);
    }
}
