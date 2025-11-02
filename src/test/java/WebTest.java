import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.WildberriesPage;

import static com.codeborne.selenide.Selenide.open;


public class WebTest extends TestBase {
    WildberriesPage registrationPage = new WildberriesPage();

    @ValueSource(strings = {
            "Растущий стул", "Куртка зимняя женская"})
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список карточек")
    @Tag("SMOCK")
    void searchResultsShouldNotBeEmpty(String searchQuery) {
        registrationPage
                .openPage()
                .setValue(searchQuery)
                .pressEnter()
                .shouldBe();
    }

    @CsvSource(value = {
            "Растущий стул, детей",
            "Куртка зимняя женская, 130"})
    @ParameterizedTest(name = "Для поискового запроса {0} в первой каточке должна быть ссылка {1}")
    @Tag("SMOCK")
    void searchResultsShouldContainExpectedUrl(String searchQuery, String expectedLink) {
        registrationPage
                .openPage()
                .setValue(searchQuery)
                .pressEnter()
                .shouldBe()
                .priceWrap(expectedLink);
    }
}
