import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.Language;
import pages.SelenidesPage;
import pages.WildberriesPage;

import java.util.List;
import java.util.stream.Stream;


public class WebTest extends TestBase {
    WildberriesPage wildberriesPage = new WildberriesPage();
    SelenidesPage selenidesPage = new SelenidesPage();

    @ValueSource(strings = {
            "Растущий стул",
            "Куртка зимняя женская"})
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список карточек")
    @Tag("SMOCK")
    void searchResultsShouldNotBeEmpty(String searchQuery) {
        wildberriesPage
                .openPage()
                .popupWrapper()
                .setValue(searchQuery)
                .pressEnter()
                .shouldBe();
    }

    @CsvSource(value = {
            "Растущий стул, стул",
            "Куртка зимняя женская, куртка"})
    @ParameterizedTest(name = "Для поискового запроса {0} в первой каточке должно быть слово {1}")
    @Tag("SMOCK")
    void searchResultsShouldContainExpectedUrl(String searchQuery, String expectedWord) {
        wildberriesPage
                .openPage()
                .popupWrapper()
                .setValue(searchQuery)
                .pressEnter()
                .shouldBe()
                .findInCards(expectedWord);
    }

    static Stream<Arguments> selenideSiteShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(Language.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы")),
                Arguments.of(Language.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"))
        );
    }

    @MethodSource
    @ParameterizedTest()
    @Tag("SMOCK")
    void selenideSiteShouldDisplayCorrectButtons(Language language, List<String> expectedButtons) {
        selenidesPage
                .openPage()
                .selectLanguage(language)
                .expectedShouldButtons(expectedButtons);
    }
}
