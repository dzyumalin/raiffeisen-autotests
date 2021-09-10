package ru.raiffeisen.drivers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.raiffeisen.config.Project;

public class SelenoidDriver {

    public static void configure() {
        Configuration.browserVersion = Project.deviceConfig.browserVersion();
        Configuration.browser = Project.deviceConfig.browser();
        Configuration.browserSize = Project.deviceConfig.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.remote = Project.deviceConfig.hubUrl();

        Configuration.browserCapabilities = capabilities;
    }

}
