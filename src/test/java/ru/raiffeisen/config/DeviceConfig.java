package ru.raiffeisen.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${deviceHost}.properties"
})
public interface DeviceConfig extends Config {

    @Key("hub.url")
    String hubUrl();

    @Key("hub.username")
    String hubUsername();

    @Key("hub.password")
    String hubPassword();

    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();

    @Key("app.url")
    String appUrl();

    @Key("app.bs")
    String appBs();

    String device();

    @Key("platform.name")
    String platformName();

    @Key("platform.version")
    String platformVersion();

    @Key("platform.locale")
    String platformLocale();

    @Key("platform.language")
    String platformLanguage();

    @Key("bs.api.url")
    String bsApiUrl();

    @Key("bs.project")
    String bsProject();

    @Key("bs.build")
    String bsBuild();

    @Key("bs.name")
    String bsName();

    @Key("selenoid.video.storage")
    String selenoidVideoStorage();

    @Key("driver")
    String driver();

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();
}

