package ru.raiffeisen.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.annotations.Layer;
import ru.raiffeisen.pages.MortgagePage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.raiffeisen.tests.TestData.*;

@Owner("Dmitriy")
@Layer("Web")
public class MortgageContent extends TestBase {

    MortgagePage mortgagePage = new MortgagePage();

    @Test
    @Description("Меню 'Ипотека'")
    @DisplayName("Проверка надписи на сайте")
    void checkForMortgageClients() {
        step("Открыть " + OPEN_URL, () -> {
            open(OPEN_URL);
        });

        step("Проверить надпись " + MORTGAGE_CLIENTS, () -> {
            mortgagePage.setMortGageMenu();
            mortgagePage.setMortGageMemo();
            mortgagePage.checkMortGageClients();
        });
    }

    @Test
    @Description("Автогенерированный тест")
    @DisplayName("Проверка наличия заголовка страницы")
    void titleTest() {
        step("Открыть " + OPEN_URL, () ->
            open(OPEN_URL));

        step("Заголовок страницы должен содержать текст 'Райффайзенбанк – банк для жизни и бизнеса. Ипотека, кредиты, банковские карты и другие услуги'", () -> {
            String expectedTitle = "Райффайзенбанк – банк для жизни и бизнеса. Ипотека, кредиты, банковские карты и другие услуги";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
}
