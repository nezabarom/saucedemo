package stepDefinitions.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.saucedemo.core.config.EnvironmentConfig;
import com.saucedemo.core.config.WebDriverFactory;
import com.saucedemo.core.config.manager.ConfigManager;
import com.saucedemo.core.session.Session;
import com.saucedemo.core.session.SessionKey;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.Objects;


@Log4j2
public class BaseUiTest {

    private final EnvironmentConfig ENV_CONFIG = ConfigManager.getEnvironmentConfig();
    public static WebDriverFactory webDriverFactory = new WebDriverFactory();
    private Scenario scenario;


    @Before(value = "@Ui-Tests", order = 0)
    public void setupUI(Scenario scenario) throws MalformedURLException {
        this.scenario = scenario;
        Session.init();
        Session.putSessionValue(SessionKey.SCENARIO_NAME, scenario.getName());
        webDriverFactory.initSession();
        Selenide.open(ENV_CONFIG.getUiBaseUrl());
        log.info("Start page opened: {}", ENV_CONFIG.getUiBaseUrl());
    }


    @After(value = "not @API-Tests", order = 0)
    public void tearDown(Scenario scenario) {
        takeScreenshot(scenario);
        Session.destroy();
        if (Objects.nonNull(webDriverFactory)) {
            webDriverFactory.closeSession();
        }
    }

    private void takeScreenshot(Scenario scenario) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        if (scenario.isFailed()) {
            if (driver instanceof TakesScreenshot) {
                scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Screenshot");
            }
        }
    }
}