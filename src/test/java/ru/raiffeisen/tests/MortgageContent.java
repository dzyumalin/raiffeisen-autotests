package ru.raiffeisen.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.pages.MortgagePage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.raiffeisen.tests.TestData.OPEN_URL;


public class MortgageContent extends TestBase {

    MortgagePage mortgagePage = new MortgagePage();

    @Test
    @Description("Список 'Ипотека'")
    @DisplayName("Проверка надписи на сайте")
    void checkForMortgageClients() {
        step("Открыть https://www.raiffeisen.ru/", () -> {
            open(OPEN_URL);
        });

        step("Проверка, что есть надпись \"Для ипотечных клиентов\"", () -> {
            mortgagePage.setMortGageMenu();
            mortgagePage.setMortGageMemo();
            mortgagePage.checkMortGagePrograms();
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.raiffeisen.ru/'", () ->
            open(OPEN_URL));

        step("Page title should have text 'Райффайзенбанк – банк для жизни и бизнеса. Ипотека, кредиты, банковские карты и другие услуги'", () -> {
            String expectedTitle = "Райффайзенбанк – банк для жизни и бизнеса. Ипотека, кредиты, банковские карты и другие услуги";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
}
