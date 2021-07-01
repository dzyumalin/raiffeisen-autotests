package ru.raiffeisen.tests;

import ru.raiffeisen.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.raiffeisen.tests.TestData.*;


public class MortgageLoans extends TestBase {
    @Test
    @Description("Вкладка 'Ипотека'")
    @DisplayName("Проверка надписи на сайте")
    void checkMortgageClient() {
        step("Открыть https://www.raiffeisen.ru/", () -> {
            open("https://www.raiffeisen.ru/");
        });

        step("Проверка, что есть надпись \"Откройте счет для бизнеса без посещения банка\"", () -> {
            $(".main-menu__link", 1).click();
            $(byText("Памятки для ипотечных клиентов")).click();
            $(".e-title--h2", 0).shouldHave(text(MORTGAGE_CLIENTS));
        });
    }

    @Test
    @Description("Вкладка 'Ипотека'")
    @DisplayName("Проверка надписи на сайте")
    void checkMortgageProgram() {
        step("Открыть https://www.raiffeisen.ru/", () -> {
            open("https://www.raiffeisen.ru/");
        });

        step("Проверка, что есть надпись 'Ипотечные программы", () -> {
            $(".main-menu__link", 1).click();
            $(byText("Все программы")).click();
            $(".e-title--h2", 0).shouldHave(text(MORTGAGE_PROGRAMS));
        });
    }

    @Test
    @Description("Вкладка 'Ипотека'")
    @DisplayName("Проверка надписи на сайте")
    void checkMortgageStateProgram() {
        step("Открыть https://www.raiffeisen.ru/", () -> {
            open("https://www.raiffeisen.ru/");
        });

        step("Перейти до вкладки 'Ипотека с господдержкой 2020'", () -> {
            $(".main-menu__link", 1).click();
            $(byText("Ипотека с господдержкой 2020")).click();
        });
        step("Выбрать элемент 'Ипотечный калькулятор'", () -> {
            $$(".b-tabs__list").findBy(visible)
                    .$(byText("Ипотечный калькулятор"))
                    .scrollTo()
                    .click();
        });
        step("Расчет ипотеки", () -> {
            $(byName("cost")).pressEnter().clear();
            $(byName("cost")).pressEnter().val(COST);
            $(byName("initialPayment")).pressEnter().clear();
            $(byName("initialPayment")).pressEnter().val(INTIAL_PAYMENT);
        });
        step("Проверяем ежемесячный платеж", () -> {
            $(".evZRys").shouldHave(text(MONTHLY_PAYMENT));
            $(".iBAiwi").shouldHave(text(RATE));
            $(".iBAiwi", 1).shouldHave(text(CREDIT_AMOUNT));
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