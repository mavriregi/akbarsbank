package testing.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CreditCalculator;

public class CreditCalculatorPrice implements Question<String> {
    @Override
    @Step("Credit calculator sum is")
    public String answeredBy(Actor actor) {
        String resultPrice = Text.of(CreditCalculator.monthCostResult()).viewedBy(actor).asString();
        return resultPrice;
    }

    public static Question<String> is() {
        return new CreditCalculatorPrice();
    }
}
