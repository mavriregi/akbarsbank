package testing.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CardOrderForm;

public class RequiredFieldErrorMessage implements Question<String> {
    @Override
    @Step("Required field error message has displayed")
    public String answeredBy(Actor actor) {
        String errorText = Text.of(CardOrderForm.firstNameFieldError()).viewedBy(actor).asString();
        return errorText;
    }

    public static Question<String> is() {
        return new RequiredFieldErrorMessage();
    }

}
