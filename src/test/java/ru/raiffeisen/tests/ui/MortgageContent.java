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
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.raiffeisen.tests.TestData.MORTGAGE_CLIENTS;
import static ru.raiffeisen.tests.TestData.OPEN_URL;

@Layer("Web")
@Owner("Dmitriy")
@Feature("Mortgage")
public class MortgageContent extends TestBase {

    MortgagePage mortgagePage = new MortgagePage();

    @Test
    @Tag("web")
    @JiraIssues({@JiraIssue("HOMEWORK-8")})
    @Description("Menu 'Ипотека'")
    @DisplayName("Checking mortage description on the site")
    void checkForMortgageClients() {
        step("Open url " + OPEN_URL, () -> {
            open(OPEN_URL);
        });

        step("Click on 'Ипотека'", () ->
            mortgagePage.setMortGageMenu());
        step("Click on " + MORTGAGE_CLIENTS, () ->
            mortgagePage.setMortGageMemo());
        step("Check description " + MORTGAGE_CLIENTS, () -> {
            mortgagePage.checkMortGageClients();
        });
    }

    @Test
    @Tag("web")
    @JiraIssues({@JiraIssue("HOMEWORK-8")})
    @Description("Autogenerated test")
    @DisplayName("Checking for the presence of a page title\n")
    void titleTest() {
        step("Open url " + OPEN_URL, () ->
                open(OPEN_URL));
        step("The page title should have 'Райффайзенбанк – банк для жизни и бизнеса. Ипотека, кредиты, банковские карты и другие услуги'", () -> {
            String expectedTitle = "Райффайзенбанк – банк для жизни и бизнеса. Ипотека, кредиты, банковские карты и другие услуги";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
}