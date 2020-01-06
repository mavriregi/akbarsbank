package testing.project.models;

public enum SiteCategory {

    Individuals(new Category("Частным лицам", "Ак Барс Банк — Карты, кредиты, вклады, инвестиции и многое другое", "/")),
    SmallBusiness(new Category("Малому бизнесу", "Ак Барс Банк — Малому бизнесу и ИП", "/small-business")),
    Corporate(new Category("Среднему и крупному бизнесу", "Ак Барс Банк — Среднему и крупному бизнесу", "/corporate"));

    private SiteCategory(Category intr) { this.obj = intr; }
    private Category obj;

    public String getName() { return obj.name; }
    public String getPageTitle() { return obj.pageTitle; }
    public String getRelativeUrl() { return obj.relativeUrl; }
}

class Category { // to store multiple values
    public String name;
    public String pageTitle;
    public String relativeUrl;
    Category(String name, String pageTitle, String relativeUrl) {
        this.name = name;
        this.pageTitle = pageTitle;
        this.relativeUrl = relativeUrl;
    }
}
