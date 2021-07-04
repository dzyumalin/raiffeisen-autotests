package ru.raiffeisen.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.pages.MortgagePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.raiffeisen.tests.TestData.*;


public class MortgageLoansContent extends TestBase {

    MortgagePage mortgagePage = new MortgagePage();

    @Test
    @Description("Список 'Ипотека'")
    @DisplayName("Проверка надписи на сайте")
    void checkMortgageProgram() {
        step("Открыть https://www.raiffeisen.ru/", () -> {
            open("https://www.raiffeisen.ru/");
        });

        step("Проверка, что есть надпись 'Ипотечные программы", () -> {
            mortgagePage.setMortGageMenu();
            mortgagePage.setMortGageAllPrograms();
            mortgagePage.checkMortGagePrograms();
        });
    }

    @Test
    @Description("Список 'Ипотека'")
    @DisplayName("Проверка расчета ипотеки")
    void checkMortgageStateProgram() {
        step("Открыть https://www.raiffeisen.ru/", () -> {
            open(OPEN_URL);
        });

        step("Перейти до списка 'Ипотека с господдержкой'", () -> {
            mortgagePage.setMortGageMenu();
            mortgagePage.setMortGageGovernmentSupport();
        });
        step("Выбрать элемент 'Ипотечный калькулятор'", () -> {
            mortgagePage.selectMortGageCalculator();
        });
        step("Расчет ипотеки", () -> {
            mortgagePage.setMortGageCalculator();
        });
        step("Проверяем ежемесячный платеж", () -> {
            mortgagePage.checkMonthlyPayment();
        });
    }
}