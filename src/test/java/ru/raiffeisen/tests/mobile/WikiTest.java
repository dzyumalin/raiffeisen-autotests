package ru.raiffeisen.tests.mobile;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.raiffeisen.annotations.JiraIssue;
import ru.raiffeisen.annotations.JiraIssues;
import ru.raiffeisen.annotations.Layer;
import ru.raiffeisen.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.raiffeisen.tests.TestData.WIKI_PASSWORD;
import static ru.raiffeisen.tests.TestData.WIKI_USERNAME;

@Layer("mobile")
@Owner("Dmitriy")
@Feature("Wiki test")
public class WikiTest extends TestBase {

    @Test
    @Tag("mobile")
    @JiraIssues({@JiraIssue("HOMEWORK-11")})
    @Description("Menu 'Getting started'")
    @DisplayName("Getting started page test")
    void checkContentTest() {
        step("Open app", () ->
            open()
        );
        step("Main content verification", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages")));
        step("Click continue", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("New ways to explore", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore")));
        step("Click continue", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Reading lists with sync", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Join Wikipedia")));
        step("Click continue", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Send anonymous data. Checkbox check", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/switchView")).shouldHave(text("ON")).click());
            $(MobileBy.id("org.wikipedia.alpha:id/switchView")).shouldHave(text("OFF")
        );
    }

    @Test
    @Tag("mobile")
    @JiraIssues({@JiraIssue("HOMEWORK-11")})
    @Description("Menu 'Search'")
    @DisplayName("Search and verification of bank address")
    void SearchTest() {
        step("Open app", () ->
            open()
        );
        step("Backspace", () ->
            back()
        );
        step("Click on 'Search Wikipedia'", () ->
            $(MobileBy.AccessibilityId("Search Wikipedia")).click()
        );
        step("Content verification", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Raiffeisenbank (Russia)"));
            $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
            $(MobileBy.className("android.view.View")).shouldHave(text("Raiffeisenbank (Russia)")
        );

    }

    @Test
    @Tag("mobile")
    @JiraIssues({@JiraIssue("HOMEWORK-11")})
    @Description("Menu 'Accounts'")
    @DisplayName("Enter input data and check presence")
    void unsucessfullLoginTest() {
        step("Open app", () ->
            open()
        );
        step("Backspace", () ->
            back()
        );
        step("Click in nav tab on 'More'", () ->
            $(MobileBy.AccessibilityId("More")).click());
        step("Click on 'LOG IN / JOIN WIKIPEDIA'", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/main_drawer_login_button")).click());
        step("Click on 'LOG IN'", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/create_account_login_button")).click());
        step("Set value in 'Username'" + WIKI_USERNAME, () ->
            $(By.xpath("//android.widget.EditText[@text='Username']")).sendKeys(WIKI_USERNAME));
        step("Set value in 'Password'" + WIKI_PASSWORD, () ->
            $(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys(WIKI_PASSWORD));
        step("Click on 'LOG IN'", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/login_button")).click());
        step("Check the warning of incorrect input", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/snackbar_text")).shouldBe(visible)
        );
    }

}
