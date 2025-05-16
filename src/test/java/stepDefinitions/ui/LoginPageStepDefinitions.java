package stepDefinitions.ui;

import com.saucedemo.businnes.pages.LogInPage;
import com.saucedemo.businnes.pages.component.BurgerMenu;
import com.saucedemo.core.config.EnvironmentConfig;
import com.saucedemo.core.config.manager.ConfigManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;


@Log4j2
public class LoginPageStepDefinitions {
    private final EnvironmentConfig ENV_CONFIG = ConfigManager.getEnvironmentConfig();
    private final LogInPage logInPage = new LogInPage();
    private final BurgerMenu burgerMenu = new BurgerMenu();


    @Given("Login as user")
    public void login() {
        log.info("Login page is opened: {}", ENV_CONFIG.getUiBaseUrl());
        logInPage.insertUserName();
        logInPage.insertUserPassword();
        logInPage.clickLoginButton();
    }

    @Then("Start Page is displayed")
    public void isStartPageDisplayed() {
        Assert.assertTrue(logInPage.isStartPageDisplayed(),
                "Current page is NOT Start page");
    }

    @Then("Log Out page is displayed")
    public void isLogOutPageDisplayed() {
        Assert.assertTrue(logInPage.isLogOutPageDisplayed(),
                "Current page is NOT LogOut page");
    }


    @When("Logout user")
    public void logOut() {
        log.info("Click on Burger menu button");
        burgerMenu.clickBurgerMenuButton();

        log.info("Click on LogOut button");
        logInPage.clickLogOutButton();
    }

    @Given("Login as locked user")
    public void loginAsLockedUser() {
        log.info("Login page is opened: {}", ENV_CONFIG.getUiBaseUrl());
        logInPage.insertLockedUserName();
        logInPage.insertUserPassword();
        logInPage.clickLoginButton();
    }

    @Given("Login as problem user")
    public void loginAsProblemUser() {
        log.info("Login page is opened: {}", ENV_CONFIG.getUiBaseUrl());
        logInPage.insertProblemUserName();
        logInPage.insertUserPassword();
        logInPage.clickLoginButton();
    }

    @Then("Check error message {string}")
    public void checkErrorMessage(String message) {
        log.info("Check error message for locked User: " + message);
        logInPage.checkErrorMessage(message);
    }

    @Then("Check that error 404 is present")
    public void checkNotFoundErrorIsPresent() {
        log.info("Check that error 404 is present on page");
        logInPage.checkNotFoundErrorIsPresent();
    }

    @Given("Login with invalid password")
    public void loginWithInvalidPassword() {
        log.info("Login with invalid password");
        logInPage.insertUserName();
        logInPage.insertUInvalidPassword();
        logInPage.clickLoginButton();

    }
}