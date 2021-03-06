package ru.raiffeisen.tests;

import com.codeborne.selenide.Configuration;
import ru.raiffeisen.config.Project;
import ru.raiffeisen.drivers.WebDriver;
import ru.raiffeisen.helpers.AllureAttachments;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        if (Objects.equals(Project.deviceConfig.driver(), "WebDriver")) {
            WebDriver.configure();
            System.out.println(Project.deviceConfig.hubUrl());
        } else {
            Configuration.browser = "ru.raiffeisen.drivers." + Project.deviceConfig.driver();
            Configuration.startMaximized = false;
            Configuration.browserSize = null;
            Configuration.timeout = 10000;
        }

    }

    @AfterEach
    public void allureAttachments() {
        AllureAttachments.addAttachments(Project.deviceConfig.driver());
        closeWebDriver();
    }
}
