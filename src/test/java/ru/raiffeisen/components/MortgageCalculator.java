package ru.raiffeisen.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ru.raiffeisen.tests.TestData.COST;
import static ru.raiffeisen.tests.TestData.INTIAL_PAYMENT;

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
        }

}
