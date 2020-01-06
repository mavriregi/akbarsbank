package testing.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class OnlineBankingUrl implements Question<String> {
    @Override
    @Step("Page contains the right URL")
    public String answeredBy(Actor actor) {
        WebDriver driver = getDriver();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(tabs.get(0));

        return currentUrl;
    }

    public static Question<String> is() {
        return new OnlineBankingUrl();
    }

}
