package testing.project.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import testing.project.Configuration;

@DefaultUrl(Configuration.baseUrl + "/individuals/cards/generation")
public class CardOrderForm extends PageObject {
    public static Target firstNameField() {
        return Target
                .the("First Name Field")
                .locatedBy("//input[@name='given-name']");
    }

    public static Target formHeader() {
        return Target
                .the("Form Header")
                .locatedBy("//div[@class='order__form']");
    }

    public static Target lastNameField() {
        return Target
                .the("Last Name Field")
                .locatedBy("//input[@name='family-name']");
    }

    public static Target middleNameField() {
        return Target
                .the("Middle Name Field")
                .locatedBy("//input[@name='additional-name']");
    }

    public static Target birthDateField() {
        return Target
                .the("Birth Date Field")
                .locatedBy("//input[@name='bday']");
    }

    public static Target phoneNumberField() {
        return Target
                .the("Phone Number Field")
                .locatedBy("//input[@name='tel']");
    }

    public static Target emailField() {
        return Target
                .the("Email Field")
                .locatedBy("//input[@name='email']");
    }

    public static Target sendFirstStepButton() {
        return Target
                .the("Form First Step Send Button")
                .locatedBy("//button[@id='card_step_one_button']");
    }

    public static Target confirmationCode() {
        return Target
                .the("Confirmation Code Text")
                .locatedBy("//div[contains(@class, 'window__popup animation_open')]//div[contains(@class, 'title')]/h4");
    }

    public static Target firstNameFieldError() {
        return Target
                .the("First Name Field Error Text")
                .locatedBy("//div[@id='card_user_name']//div[@class='input-block__error-text']");
    }
}
