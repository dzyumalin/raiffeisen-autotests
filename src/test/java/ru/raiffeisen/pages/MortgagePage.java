package ru.raiffeisen.pages;

import com.codeborne.selenide.SelenideElement;
import ru.raiffeisen.components.MortgageCalculator;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static ru.raiffeisen.tests.TestData.*;

public class MortgagePage {

    private SelenideElement mortGageMenu = $(".main-menu__link", 1),
                            mortGageMemo = $(byText("Памятки для ипотечных клиентов")),
                            mortGagePrograms = $(".e-title--h2", 0),
                            mortGageClients = $(".e-title--h2", 0),
                            mortGageAllPrograms = $(byText("Все программы")),
                            mortGageGovernmentSupport = $(byText("Ипотека с господдержкой")),
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

    public void setMortGageGovernmentSupport() {
        mortGageGovernmentSupport.click();
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


}
