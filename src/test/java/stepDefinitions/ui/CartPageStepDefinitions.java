package stepDefinitions.ui;

import com.saucedemo.businnes.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;


@Log4j2
public class CartPageStepDefinitions {

    private final CartPage cartPage = new CartPage();


    @When("Add to Cart by item name: {string}")
    public void addToCart(String name) {
        cartPage.addToCartByItemName(name);
    }

    @Then("Check that number of Cart items: {int}")
    public void checkNumberOfCartItems(int num) {
        Assert.assertEquals(cartPage.getCartNumber(), num,
                "Number of Cart items is NOT: " + num);
    }

    @When("Click on cart icon")
    public void clickOnCart() {
        cartPage.clickOnCart();
    }

    @Then("Check name of Cart item: {int}, {string}")
    public void checkNNameOfCartItem(int num, String name) {
        Assert.assertTrue(cartPage.checkItemNumAndNAme(num, name),
                "Name of cart item is NOT valid");
    }

}