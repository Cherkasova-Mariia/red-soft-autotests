package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestDataRedSoft.*;

public class RedSoftPage {

    private SelenideElement body = $("body");
    private SelenideElement aboutLink = $(byText(ABOUT_LINK_TEXT));
    private SelenideElement contactPhone = $(byText(PHONE_NUMBER));

    @Step("Открываем главную страницу")
    public RedSoftPage openMainPage() {
        open(BASE_URL);
        return this;
    }

    @Step("Открываем страницу контактов")
    public RedSoftPage openContactPage() {
        open(CONTACT_URL);
        return this;
    }

    @Step("Проверяем, что на странице есть текст: {expectedText}")
    public RedSoftPage checkPageContainsText(String expectedText) {
        body.shouldHave(text(expectedText));
        return this;
    }

    @Step("Проверяем, что ссылка 'О компании' присутствует в коде страницы")
    public RedSoftPage checkAboutLinkExists() {
        aboutLink.shouldBe(Condition.exist);
        return this;
    }

    @Step("Проверяем, что на странице контактов отображается телефон")
    public RedSoftPage checkPhoneNumber() {
        contactPhone.shouldBe(visible);
        return this;
    }
}