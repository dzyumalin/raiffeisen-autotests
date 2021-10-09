package ru.raiffeisen.pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.raiffeisen.tests.TestData.*;

public class MortgageCalculator {

    public void selectMortGageCalculator() {
        $$(".b-tabs__list").findBy(visible)
                .$(byText("Ипотечный калькулятор"))
                .scrollTo()
                .click();
    }

    public void setMortGageCalculator() {
        $(byName("cost")).click();
        $(byName("cost")).val(COST);
        $(byName("initialPayment")).click();
        $(byName("initialPayment")).val(INTIAL_PAYMENT);
        $(byName("term")).click();
        $(byName("term")).val(TERM);
        $("[data-marker='Inputs.Field_2']").click();
        $("[data-marker='Inputs.Field_3']").click();
    }

}
