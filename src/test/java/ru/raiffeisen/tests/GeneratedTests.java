package ru.raiffeisen.tests;

import ru.raiffeisen.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {
    @Test
    @Description("Soon to be implemented by you (or QA.GURU engineers)")
    @DisplayName("Проверка надписи на сайте")
    void generatedTest() {
        step("Открыть https://www.raiffeisen.ru/", () -> {
            open("https://www.raiffeisen.ru/");
        });

        step("Проверка, что есть надпись \"Откройте счет для бизнеса без посещения банка\"", () -> {
            $(".main-menu__link", 1).click();
            $(byText("Памятки для ипотечных клиентов")).click();
            $(".e-title--h2", 0).shouldHave(text("Для ипотечных клиентов"));
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.raiffeisen.ru/'", () ->
            open("https://www.raiffeisen.ru/"));

        step("Page title should have text 'Райффайзенбанк – банк для жизни и бизнеса. Ипотека, кредиты, банковские карты и другие услуги'", () -> {
            String expectedTitle = "Райффайзенбанк – банк для жизни и бизнеса. Ипотека, кредиты, банковские карты и другие услуги";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.raiffeisen.ru/'", () ->
            open("https://www.raiffeisen.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}