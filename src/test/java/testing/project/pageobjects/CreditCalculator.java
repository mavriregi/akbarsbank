package testing.project.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import testing.project.Configuration;

@DefaultUrl(Configuration.baseUrl + "/individuals/credits/potrebitelskiy")
public class CreditCalculator extends PageObject {
    public static Target sumField() {
        return Target
                .the("Sum Field")
                .locatedBy("//form[contains(@class, 'input-form')]/input");
    }
    public static Target termField() {
        return Target
                .the("Term Field")
                .locatedBy("//div[contains(@class, 'select')]//input[@aria-controls='select-items']");
    }
    public static Target termListItem(int item) {
        return Target
                .the("Term list item " + String.valueOf(item))
                .locatedBy("//ul[@id='select-items']/li[{0}]").of(String.valueOf(item + 1)); // +1 because XPath starts counting from 1, not 0
    }
    public static Target monthCostResult() {
        return Target
                .the("Month Credit Cost")
                .locatedBy("//div[contains(@class, 'results__sum')]//h3");
    }
}
