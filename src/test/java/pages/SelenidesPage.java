package pages;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class SelenidesPage {
    private final ElementsCollection selectLanguage = $$("#languages a");
    private final ElementsCollection expectedButtons = $$(".main-menu-pages a");


    public SelenidesPage openPage() {
        open("https://ru.selenide.org/");
        sleep(4000);
        return this;
    }

    public SelenidesPage expectedShouldButtons(List<String> expectedButtons) {
        this.expectedButtons.filter(visible).shouldHave(texts(expectedButtons));
        return this;
    }

    public SelenidesPage selectLanguage(Language language) {
        selectLanguage.find(text(language.name())).click();
        return this;
    }
}
