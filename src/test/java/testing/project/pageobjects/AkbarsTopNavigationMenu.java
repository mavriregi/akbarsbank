package testing.project.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import testing.project.Configuration;
import testing.project.models.SiteCategory;

@DefaultUrl(Configuration.baseUrl)
public class AkbarsTopNavigationMenu extends PageObject {
    public static Target siteCategoryMenuSection(SiteCategory category) {
        return Target
                .the(category + " category")
                .locatedBy("//a[contains(text(), '{0}')]")
                .of(category.getName());
    }

    public static Target siteLogo() {
        return Target
                .the( "Index page logo")
                .locatedBy("//div[@class='logo']");
    }

    public static Target onlineBankingButton() {
        return Target
                .the( "Online Banking Button")
                .locatedBy("//div[@aria-controls='head-menu-online-banks-list']");
    }
}
