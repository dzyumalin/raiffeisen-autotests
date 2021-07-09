package ru.raiffeisen.tests;

import io.qameta.allure.Description;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

public class DepositContent extends TestBase {

    @Test
    @Description("Меню 'Вклады'")
    @DisplayName("Тест на скачивание и проверку PDF файла")
    void checkPdfContent() {

        step("Открыть " + OPEN_URL, () -> {
            open(OPEN_URL);
        });

        step("Нажать в меню на 'Вклады'", () -> {
            $(".main-menu__link", 3).click();
        });

        step("Нажать на 'Вклад'", () -> {
            $$(".menu-body").findBy(visible).$(byText(DEPOSIT)).click();
        });

        step("Найти блок 'Документы'", () -> {
            $(".tips__content").scrollTo().shouldHave(text("Документы"));
        });

        step("Скачать документ 'Условия и процентные ставки по срочному вкладу «Фиксированный»' и проверить", () -> {
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