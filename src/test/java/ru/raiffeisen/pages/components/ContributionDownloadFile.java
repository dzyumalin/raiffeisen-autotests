package ru.raiffeisen.pages.components;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.raiffeisen.tests.TestData.CONTRIBUTION_DOCUMENT;
import static ru.raiffeisen.tests.TestData.MIN_DEPOSIT_AMOUNT;

public class ContributionDownloadFile {

    public void checkContributionDocument() {
        $(".tips__content").scrollTo().shouldHave(text(CONTRIBUTION_DOCUMENT));
    }

    public void downloadContributionDocument() throws IOException {
        URL url = new URL("https://www.raiffeisen.ru/common/img/uploaded/files/retail/deposits/fixed.pdf");

        InputStream is = url.openStream();
        BufferedInputStream fileParse = new BufferedInputStream(is);
        PDDocument document = null;

        document = PDDocument.load(fileParse);
        String pdfContent = new PDFTextStripper().getText(document);
        assertThat(pdfContent, pdfContent.contains(MIN_DEPOSIT_AMOUNT));
    }

}
