package ru.raiffeisen.tests.mobile;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import ru.raiffeisen.annotations.JiraIssue;
import ru.raiffeisen.annotations.JiraIssues;
import ru.raiffeisen.annotations.Layer;
import ru.raiffeisen.drivers.AppiumMobileDriver;
import ru.raiffeisen.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("mobile")
@Owner("Dmitriy")
@Feature("Wiki test")
public class WikiTest extends TestBase {

    @Test
    @Tag("mobile")
    @JiraIssues({@JiraIssue("HOMEWORK-11")})
    @Description("Menu 'Search'")
    @DisplayName("Search and verification of bank address")
    void checkContentTest() {
        step("Open app", () -> {
            open();
        step("backspace", () ->
            back());
        step("Search and click on text", () ->
            $(MobileBy.AccessibilityId("Search Wikipedia")).click());
        });

        step("Find text and check", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Raiffeisenbank (Russia)");
            $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
            $(MobileBy.className("android.view.View")).shouldHave(text("Raiffeisenbank (Russia)"));
        });

    }

}
