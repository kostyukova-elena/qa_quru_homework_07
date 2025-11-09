package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class WildberriesPage {

    private final SelenideElement popupWrapper = $("._close_1b9nk_55 popup__close close closeWhite--MwvwP");
    private final SelenideElement searchInput = $("#searchInput");
    private final ElementsCollection productCards = $$("article.product-card");
    private final ElementsCollection productCardNames = $$("span.product-card__name");


    public WildberriesPage openPage() {
        open("https://www.wildberries.ru/");
        return this;
    }

    public WildberriesPage popupWrapper() {
        popupWrapper.find(String.valueOf(Condition.exist));
        if (popupWrapper.exists()) {
            popupWrapper.click();
        }
        return this;
    }

    public WildberriesPage setValue(String value) {
        searchInput.setValue(value);
        return this;
    }

    public WildberriesPage pressEnter() {
        searchInput.pressEnter();
        return this;
    }

    public WildberriesPage shouldBe() {
        productCards.shouldBe(sizeGreaterThan(0));
        return this;
    }

    public WildberriesPage findInCards(String value) {
        productCardNames.first().shouldHave(text(value));
        return this;
    }
}
