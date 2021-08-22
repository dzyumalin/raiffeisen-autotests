package ru.raiffeisen.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Lead;
import io.qameta.allure.Owner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.annotations.Layer;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.raiffeisen.tests.TestData.*;

@Layer("Web")
@Owner("Dmitriy")
@Feature("Contributions")
public class DepositContent extends TestBase {

    @Test
    @Tag("Web")
    @Description("Menu 'Contributions'")
    @DisplayName("Test on download and check PDF file")
    void checkPdfContent() {

        step("Open url" + OPEN_URL, () -> {
            open(OPEN_URL);
        });

        step("Click in menu on 'Contributions'", () -> {
            $(".main-menu__link", 3).click();
        });

        step("Click on 'Contributions'", () -> {
            $$(".menu-body").findBy(visible).$(byText(DEPOSIT)).click();
        });

        step("Find block 'Documents'", () -> {
            $(".tips__content").scrollTo().shouldHave(text("Документы"));
        });

        step("Download document 'Условия и процентные ставки по срочному вкладу «Фиксированный»' и проверить", () -> {
            URL url = new URL("https://www.raiffeisen.ru/common/img/uploaded/files/retail/deposits/fixed.pdf");

            InputStream is = url.openStream();
            BufferedInputStream fileParse = new BufferedInputStream(is);
            PDDocument document = null;

            document = PDDocument.load(fileParse);
            String pdfContent = new PDFTextStripper().getText(document);
            assertThat(pdfContent, pdfContent.contains(MIN_DEPOSIT_AMOUNT));
        });

    }

}