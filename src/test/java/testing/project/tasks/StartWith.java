package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import testing.project.Configuration;

public class StartWith implements Task {
    private final String relativeUrl;

    public StartWith(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }

    @Override
    @Step("{0} starts from some page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(Configuration.baseUrl + relativeUrl));
    }

    public static Performable creditCalculatorPage() {
        return Instrumented.instanceOf(StartWith.class).withProperties("/individuals/credits/potrebitelskiy");
    }
    public static Performable cardOrderPage() {
        return Instrumented.instanceOf(StartWith.class).withProperties("/individuals/cards/generation");
    }
}
