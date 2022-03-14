package ru.raiffeisen.pages;

import com.codeborne.selenide.SelenideElement;
import ru.raiffeisen.pages.components.ContributionDownloadFile;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;
import static ru.raiffeisen.tests.TestData.DEPOSIT;

public class ContributionPage {

    private SelenideElement contributionMenu = $$(".Headerstyles__HeaderBox-sc-1148tul-2").findBy(visible).$(byText("Вклады")),
            contribution = $$("[data-marker='Submenu.SubmenuWrapper']").findBy(visible).$(byText(DEPOSIT));

    public void clickOnContributionMenu() {
        contributionMenu.click();
    }

    public void clickOnContribution() {
        contribution.click();
    }

    public void checkContributionDocument() {
        new ContributionDownloadFile().checkContributionDocument();
    }

    public void selectContributionDownloadFile() throws IOException {
        new ContributionDownloadFile().downloadContributionDocument();
    }

    public void checkAndOpenUrl() {
        new MortgagePage().checkAndOpenUrl();
    }

}
