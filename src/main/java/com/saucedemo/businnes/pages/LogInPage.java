package com.saucedemo.businnes.pages;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.saucedemo.core.util.SynchronizationUtil;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.saucedemo.businnes.pages.StartPage.START_PAGE_URL;


@Log4j2
public class LogInPage extends AbstractPage {

    private static final String LOGIN_PAGE_URL = ENV_CONFIG.getUiBaseUrl() + "/index.html";
    SelenideElement loginButton = $(By.ById.id("login-button"));
    SelenideElement logOutButton = $(By.ById.id("logout_sidebar_link"));
    SelenideElement userNameInput = $(By.ById.id("user-name"));
    SelenideElement passwordInputUser = $(By.ById.id("password"));
    SelenideElement notFoundError = $(By.xpath("//a[contains(@href, '/error/404')]"));
    SelenideElement errorDataTest = $(By.xpath("//h3[@data-test]"));

    public void insertUserName() {
        log.info("Insert username");
        SynchronizationUtil.waitUntilElementIsDisplayed(userNameInput);
        userNameInput.sendKeys(ENV_CONFIG.getUserName());
    }

    public void insertLockedUserName() {
        log.info("Insert username");
        SynchronizationUtil.waitUntilElementIsDisplayed(userNameInput);
        userNameInput.sendKeys(ENV_CONFIG.getLockedUsername());
    }

    public void insertProblemUserName() {
        log.info("Insert username");
        SynchronizationUtil.waitUntilElementIsDisplayed(userNameInput);
        userNameInput.sendKeys(ENV_CONFIG.getProblemUsername());
    }

    public void insertUserPassword() {
        log.info("Insert User password");
        passwordInputUser.click();
        passwordInputUser.sendKeys(ENV_CONFIG.getPassword());
    }

    public void insertUInvalidPassword() {
        log.info("Insert User password");
        passwordInputUser.click();
        passwordInputUser.sendKeys("invalid");
    }

    public void clickLoginButton() {
        log.info("Click on login button");
        loginButton.click();
    }

    public void clickLogOutButton() {
        log.info("Click on log Out button");
        logOutButton.click();
    }

    public boolean isStartPageDisplayed() {
        return WebDriverRunner.url().contains(START_PAGE_URL);
    }

    public boolean isLogOutPageDisplayed() {
        return WebDriverRunner.url().contains(LOGIN_PAGE_URL);
    }

    public void checkErrorMessage(String message) {
        Assert.assertEquals(errorDataTest.getText(), message,
                "Message is NOT: " + message);
    }

    public void checkNotFoundErrorIsPresent() {
        Assert.assertTrue(notFoundError.exists(), "404 error message is NOT exist");
    }

}