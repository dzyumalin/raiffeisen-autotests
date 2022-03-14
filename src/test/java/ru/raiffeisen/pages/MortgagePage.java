package ru.raiffeisen.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ru.raiffeisen.pages.components.MortgageCalculator;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;
import static ru.raiffeisen.tests.TestData.*;

public class MortgagePage {

    private SelenideElement mortGageMenu = $$(".Headerstyles__HeaderBox-sc-1148tul-2").findBy(visible).$(byText("Ипотека")),
            mortGageMemo = $$("[data-marker='Columns.ColumnsWrapper']").findBy(visible).$(byText("Памятки для ипотечных клиентов")),
            mortGagePrograms = $(".e-title--h2"),
            mortGageClients = $(".e-title--h2"),
            mortGageAllPrograms = $$("[data-marker='Submenu.SubmenuWrapper']").findBy(visible).$(byText("Все ипотечные программы")),
            mortGageNewBuilding = $$("[data-marker='Columns.ColumnsWrapper']").findBy(visible).$(byText("Новостройка")),
            monthlyPayment = $(".fYZyZu");

    public void setMortGageMenu() {
        mortGageMenu.click();
    }

    public void setMortGageMemo() {
        mortGageMemo.click();
    }

    public void setMortGageAllPrograms() {
        mortGageAllPrograms.click();
    }

    public void setMortGagemortGageNewBuilding() {
        mortGageNewBuilding.click();
    }

    public void selectMortGageCalculator() {
        new MortgageCalculator().selectMortGageCalculator();
    }

    public void setMortGageCalculator() {
        new MortgageCalculator().setMortGageCalculator();
    }

    public void checkMortGagePrograms() {
        mortGagePrograms.shouldHave(text(MORTGAGE_PROGRAMS));
    }

    public void checkMortGageClients() {
        mortGagePrograms.shouldHave(text(MORTGAGE_CLIENTS));
    }

    public void checkMonthlyPayment() {
        monthlyPayment.shouldHave(text(MONTHLY_PAYMENT), text(RATE), text(CREDIT_AMOUNT));
    }

    public void checkAndOpenUrl() {
        String url = OPEN_URL;
        open(url);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        if (!Objects.equals(currentUrl, url)) {
            open(url);
        }
    }

}
