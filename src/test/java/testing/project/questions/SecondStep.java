package testing.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CardOrderForm;

public class SecondStep implements Question<String> {
    private enum QuestionType {
        IS_DISPLAYED,
        IS_NOT_DISPLAYED
    };
    QuestionType questionType;
    public SecondStep(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    @Step("The next step status")
    public String answeredBy(Actor actor) {
        switch (questionType) {
            case IS_DISPLAYED:
                return Text.of(CardOrderForm.confirmationCode()).viewedBy(actor).asString();
            case IS_NOT_DISPLAYED:
                return Text.of(CardOrderForm.firstNameFieldError()).viewedBy(actor).asString();
            default:
                return null;
        }
    }

    public static Question<String> isDisplayed() {
        return new SecondStep(QuestionType.IS_DISPLAYED);
    }
    public static Question<String> isNotDisplayed() {
        return new SecondStep(QuestionType.IS_NOT_DISPLAYED);
    }
}
