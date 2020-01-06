package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CreditCalculator;

public class ChangeCreditTerm implements Task {
    private final int num;

    public ChangeCreditTerm(int num) {
        this.num = num;
    }

    @Override
    @Step("{0} enters a credit term")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CreditCalculator.termField()),
                Click.on(CreditCalculator.termListItem(num)));
    }

    public static Performable toValue(int num) {
        return Instrumented.instanceOf(ChangeCreditTerm.class).withProperties(num);
    }
}
