package ru.raiffeisen.pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.raiffeisen.tests.TestData.*;

public class MortgageCalculator {

    public void selectMortGageCalculator() {
        $$(".b-tabs__list").findBy(visible.because("Ипотечный калькулятор не выбран"))
                .scrollTo()
                .$(byText("Ипотечный калькулятор"))
                .click();
    }

    public void setMortGageCalculator() {
        sleep(3000);
        $(byName("cost")).click();
        $(byName("cost")).val(COST);
        $(byName("initialPayment")).click();
        $(byName("initialPayment")).val(INTIAL_PAYMENT);
        $(byName("term")).click();
        $(byName("term")).val(TERM);
        $("[data-marker='Inputs.Field_2']").click();
    }

}
