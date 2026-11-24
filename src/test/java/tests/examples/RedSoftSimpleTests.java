package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RedSoftPage;

import static com.codeborne.selenide.Selenide.title;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testdata.TestDataRedSoft.*;

public class RedSoftSimpleTests {

    // Создаем объект нашей страницы
    RedSoftPage redSoftPage = new RedSoftPage();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @Test
    @DisplayName("Главная страница открывается, заголовок содержит 'РЕД СОФТ'")
    void testMainPageTitle() {
        // Так как title() возвращает строку, мы оставляем проверку в тесте
        redSoftPage.openMainPage();
        assertTrue(title().contains(EXPECTED_TITLE), "Заголовок страницы не содержит 'РЕД СОФТ'");
    }

    @Test
    @DisplayName("На главной странице упоминается флагманский продукт 'РЕД ОС'")
    void testRedOsMention() {
        // Выглядит как цепочка: открыли -> проверили
        redSoftPage.openMainPage()
                .checkPageContainsText(PRODUCT_RED_OS);
    }

    @Test
    @DisplayName("На главной странице указано '20 лет разработки'")
    void testYearsMention() {
        redSoftPage.openMainPage()
                .checkPageContainsText(YEARS_OF_DEVELOPMENT);
    }

    @Test
    @DisplayName("На главной странице присутствует ссылка на раздел 'О компании'")
    void testAboutLink() {
        redSoftPage.openMainPage()
                .checkAboutLinkExists(); // <-- Новое название метода
    }

    @Test
    @DisplayName("На главной странице есть упоминание 'Российское программное обеспечение'")
    void testSoftwareMention() {
        redSoftPage.openMainPage()
                .checkPageContainsText(SOFTWARE_TEXT);
    }

    @Test
    @DisplayName("На странице контактов указан телефон компании")
    void testPhoneOnContactPage() {
        redSoftPage.openContactPage()
                .checkPhoneNumber();
    }
}