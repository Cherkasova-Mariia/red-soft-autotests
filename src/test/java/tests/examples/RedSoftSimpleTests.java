package tests.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RedSoftPage;

import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testdata.TestDataRedSoft.*;

public class RedSoftSimpleTests extends TestBase {

    RedSoftPage redSoftPage = new RedSoftPage();

    @Test
    @DisplayName("Главная страница открывается, заголовок содержит 'РЕД СОФТ'")
    void testMainPageTitle() {
        step("Открываем главную страницу и проверяем заголовок", () -> {
            redSoftPage.openMainPage();
            assertTrue(title().contains(EXPECTED_TITLE), "Заголовок страницы не содержит 'РЕД СОФТ'");
        });
    }

    @Test
    @DisplayName("На главной странице упоминается флагманский продукт 'РЕД ОС'")
    void testRedOsMention() {
        step("Открываем главную страницу и ищем 'РЕД ОС'", () -> {
            redSoftPage.openMainPage()
                    .checkPageContainsText(PRODUCT_RED_OS);
        });
    }

    @Test
    @DisplayName("На главной странице указано '20 лет разработки'")
    void testYearsMention() {
        step("Открываем главную страницу и ищем '20'", () -> {
            redSoftPage.openMainPage()
                    .checkPageContainsText(YEARS_OF_DEVELOPMENT);
        });
    }

    @Test
    @DisplayName("На главной странице присутствует ссылка на раздел 'О компании'")
    void testAboutLink() {
        step("Открываем главную страницу и проверяем наличие ссылки 'О компании'", () -> {
            redSoftPage.openMainPage()
                    .checkAboutLinkExists();
        });
    }

    @Test
    @DisplayName("На главной странице есть упоминание 'Российское программное обеспечение'")
    void testSoftwareMention() {
        step("Открываем главную страницу и ищем 'Российское программное обеспечение'", () -> {
            redSoftPage.openMainPage()
                    .checkPageContainsText(SOFTWARE_TEXT);
        });
    }

    @Test
    @DisplayName("На странице контактов указан телефон компании")
    void testPhoneOnContactPage() {
        step("Открываем страницу контактов и проверяем телефон", () -> {
            redSoftPage.openContactPage()
                    .checkPhoneNumber();
        });
    }
}