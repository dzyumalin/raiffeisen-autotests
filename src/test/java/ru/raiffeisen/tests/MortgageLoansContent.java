package ru.raiffeisen.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.annotations.Layer;
import ru.raiffeisen.pages.MortgagePage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.raiffeisen.tests.TestData.*;

@Owner("Dmitriy")
@Layer("Web")
public class MortgageLoansContent extends TestBase {

    MortgagePage mortgagePage = new MortgagePage();

    @Test
    @Description("Меню 'Ипотека'")
    @DisplayName("Проверка надписи на сайте")
    void checkMortgageProgram() {
        step("Открыть " + OPEN_URL, () -> {
            open(OPEN_URL);
        });

        step("Нажать на 'Вклады'", () -> {
            mortgagePage.setMortGageMenu();
        });

        mortgagePage.setMortGageAllPrograms();

        step("Проверить надпись 'Ипотечные программы'", () -> {
            mortgagePage.checkMortGagePrograms();
        });
    }

    @Test
    @Description("Меню 'Ипотека'")
    @DisplayName("Проверка расчета ипотеки")
    void checkMortgageStateProgram() {
        step("Открыть " + OPEN_URL, () -> {
            open(OPEN_URL);
        });

        step("Нажать на 'Вклады'", () -> {
            mortgagePage.setMortGageMenu();
        });

        step("Нажать на 'Ипотека с господдержкой'", () -> {
            mortgagePage.setMortGageGovernmentSupport();
        });

        step("Выбрать элемент 'Ипотечный калькулятор'", () -> {
            mortgagePage.selectMortGageCalculator();
        });

        step("Расчет ипотеки", () -> {
            mortgagePage.setMortGageCalculator();
        });

        step("Проверить ежемесячный платеж", () -> {
            mortgagePage.checkMonthlyPayment();
        });
    }
}