package ru.raiffeisen.pages;

import com.codeborne.selenide.SelenideElement;
import ru.raiffeisen.components.ContributionDownloadFile;
import ru.raiffeisen.components.MortgageCalculator;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ru.raiffeisen.tests.TestData.CONTRIBUTION_DOCUMENT;
import static ru.raiffeisen.tests.TestData.DEPOSIT;

public class ContributionPage {

    private SelenideElement contributionMenu = $(".main-menu__link", 3),
                            contribution = $$(".menu-body").findBy(visible).$(byText(DEPOSIT)),
                            contributionDocument = $(".tips__content").scrollTo();

    public void clickOnContributionMenu() {
        contributionMenu.click();
    }

    public void clickOnContribution() {
        contribution.click();
    }

    public void checkContributionDocument() {
        contributionDocument.shouldHave(text(CONTRIBUTION_DOCUMENT));
    }

    public void selectContributionDownloadFile() throws IOException {
        new ContributionDownloadFile().downloadContributionDocument();
    }

}
