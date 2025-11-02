package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.sql.SQLOutput;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class WildberriesPage {

    private final SelenideElement searchInput = $("#searchInput");
    private final ElementsCollection productCards = $$("article.product-card");
    private final ElementsCollection productCardNames = $$("span.product-card__name");



    public WildberriesPage openPage() {
        open("https://www.wildberries.ru/");
        sleep(4000);
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

    /**
     * Хочу в массиве найденных карточек проверить, что хоть одна карточка содержит фразу "для детей"
     *
     */
    public WildberriesPage priceWrap(String value) {



//        $$("asd").shouldHave(containExactTextsCaseSensitive("детей"));
        productCardNames.shouldHave(containExactTextsCaseSensitive("для детей"));

        return this;
    }
}
