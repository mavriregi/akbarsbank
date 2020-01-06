package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CreditCalculator;

public class ChangeCreditData implements Task {
    private final int creditSum;
    private final int creditTerm;

    public ChangeCreditData(int creditSum, int creditTerm) {
        this.creditSum = creditSum;
        this.creditTerm = creditTerm;
    }

    @Override
    @Step("{0} enters credit data")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(String.valueOf(creditSum)).into(CreditCalculator.sumField()),
                Click.on(CreditCalculator.termField()),
                Click.on(CreditCalculator.termListItem(creditTerm)),
                Click.on(CreditCalculator.monthCostResult())); // click to refresh application input values
    }

    public static Performable withValues(int creditSum, int creditTerm) {
        return Instrumented.instanceOf(ChangeCreditData.class).withProperties(creditSum, creditTerm);
    }
}
