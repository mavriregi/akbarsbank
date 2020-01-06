package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import testing.project.Configuration;
import testing.project.models.SiteCategory;
import testing.project.pageobjects.AkbarsTopNavigationMenu;


public class NavigateTo implements Task {
    private final SiteCategory category;
    private enum TaskName {
        INDEX,
        CATEGORY,
        ONLINE_BANKING
    };
    private TaskName taskName;
    private AkbarsTopNavigationMenu akbarsTopNavigationMenu;

    public NavigateTo(TaskName taskName, SiteCategory category) {
        this.taskName = taskName;
        this.category = category;
    }

    @Override
    @Step("{0} navigates to some page")
    public <T extends Actor> void performAs(T actor) {
        switch (taskName) {
            case INDEX:
                actor.attemptsTo(
                        Open.url(Configuration.baseUrl + category.getRelativeUrl()),
                        Click.on(AkbarsTopNavigationMenu.siteLogo()));
                break;
            case CATEGORY:
                actor.attemptsTo(
                        Open.browserOn(akbarsTopNavigationMenu),
                        Click.on(AkbarsTopNavigationMenu.siteCategoryMenuSection(category)));
                break;
            case ONLINE_BANKING:
                actor.attemptsTo(
                        Open.browserOn(akbarsTopNavigationMenu),
                        Click.on(AkbarsTopNavigationMenu.onlineBankingButton()));
                break;
            default:
                break;
        }
    }

    public static Performable category(SiteCategory category) {
        return Instrumented.instanceOf(NavigateTo.class).withProperties(TaskName.CATEGORY, category);
    }
    public static Performable indexFromCategory(SiteCategory category) {
        return Instrumented.instanceOf(NavigateTo.class).withProperties(TaskName.INDEX, category);
    }
    public static Performable onlineBanking() {
        return Instrumented.instanceOf(NavigateTo.class).withProperties(TaskName.ONLINE_BANKING, SiteCategory.Individuals); // category is not involved
    }
}


