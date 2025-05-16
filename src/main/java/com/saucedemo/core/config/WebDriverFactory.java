package com.saucedemo.core.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.saucedemo.core.enums.BrowserEnum;
import com.saucedemo.core.session.Session;
import com.saucedemo.core.session.SessionKey;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.saucedemo.core.config.manager.ConfigManager.getRunConfig;


@Log4j2
public class WebDriverFactory {
    public static final String SCREEN_RESOLUTION = "1920x1080";
    public static final String SELENIDE_BROWSER_PROPERTY = "selenide.browser";

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        List<String> chromeArgsList = new ArrayList<>();
        chromeArgsList.add("--remote-allow-origins=*");
        chromeArgsList.add("--guest");
        chromeArgsList.add("--ignore-certificate-errors");
        chromeArgsList.add("--password-store=basic");
        chromeOptions.addArguments(chromeArgsList);
        chromeOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{

            put("name", Session.getSessionValue(SessionKey.SCENARIO_NAME, String.class));
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVideo", false);
            put("enableVNC", true);
        }});
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{

            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVideo", false);
            put("enableVNC", true);
        }});
        return firefoxOptions;
    }

    public void initSession() {
        log.info("Session initialization...");
        Configuration.timeout = 10000;
        Configuration.browserSize = SCREEN_RESOLUTION;
        System.setProperty(SELENIDE_BROWSER_PROPERTY, getRunConfig().getBrowser().name().toLowerCase());
        Configuration.browser = getRunConfig().getBrowser().name().toLowerCase();

       if (getRunConfig().getBrowser() == BrowserEnum.CHROME) {
            Configuration.browserCapabilities = getChromeOptions();
            log.info("Chrome session opened");
        } else if (getRunConfig().getBrowser() == BrowserEnum.FIREFOX) {
            Configuration.browserCapabilities = getFirefoxOptions();
            log.info("Firefox session opened");
        }
    }

    public void closeSession() {
        Selenide.closeWebDriver();
        if (getRunConfig().getBrowser().equals(BrowserEnum.CHROME)) {
            log.info("Chrome session closed");
        } else if (getRunConfig().getBrowser().equals(BrowserEnum.FIREFOX)) {
            log.info("Firefox session closed");
        }
    }
}