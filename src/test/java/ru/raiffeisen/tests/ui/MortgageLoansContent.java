package ru.raiffeisen.tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.annotations.JiraIssue;
import ru.raiffeisen.annotations.JiraIssues;
import ru.raiffeisen.annotations.Layer;
import ru.raiffeisen.pages.MortgagePage;
import ru.raiffeisen.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.raiffeisen.tests.TestData.MORTGAGE_PROGRAMS;
import static ru.raiffeisen.tests.TestData.OPEN_URL;

@Owner("Dmitriy")
@Layer("web")
@Feature("Mortgage")
public class MortgageLoansContent extends TestBase {

    MortgagePage mortgagePage = new MortgagePage();

    @Test
    @Tag("web")
    @JiraIssues({@JiraIssue("HOMEWORK-8")})
    @Description("Menu 'Mortgage'")
    @DisplayName("Checking mortage description on the site")
    void checkMortgageProgram() {
        step("Open url " + OPEN_URL, () ->
                mortgagePage.checkAndOpenUrl());

        step("Click on 'Ипотека'", () ->
                mortgagePage.setMortGageMenu());
        step("Click on 'Все программы'", () ->
                mortgagePage.setMortGageAllPrograms());
        step("Check description " + MORTGAGE_PROGRAMS, () -> {
            mortgagePage.checkMortGagePrograms();
        });
    }

    @Test
    @Tag("Web")
    @JiraIssues({@JiraIssue("HOMEWORK-8")})
    @Description("Menu 'Mortgage'")
    @DisplayName("Checking the calculation of the mortgage")
    void checkMortgageStateProgram() {
        step("Open url " + OPEN_URL, () ->
                mortgagePage.checkAndOpenUrl());

        step("Click on 'Ипотека'", () ->
                mortgagePage.setMortGageMenu());
        step("Click on 'Новостройка'", () ->
                mortgagePage.setMortGagemortGageNewBuilding());
        step("Click on 'Ипотечный калькулятор'", () ->
                mortgagePage.selectMortGageCalculator());
        step("Mortgage calculation", () ->
                mortgagePage.setMortGageCalculator());
        step("Check monthly payment", () -> {
            mortgagePage.checkMonthlyPayment();
        });
    }
}