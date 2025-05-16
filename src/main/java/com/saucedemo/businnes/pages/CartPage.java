package com.saucedemo.businnes.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CartPage extends AbstractPage {

    String addToCart = "//div[text()='%s']/ancestor::*[position()=2]/following-sibling::div//button";
    String cartItemNum = "//div[@class='cart_item'][%s]";
    SelenideElement cartBadge = $(By.xpath("//span[contains(@class, 'shopping_cart_badge')]"));
    SelenideElement cartIcon = $(By.xpath("//a[@href='./cart.html']"));


    public int getCartNumber(){
        log.info("Get cart number");
        return Integer.parseInt(cartBadge.getText());
    }

    public void addToCartByItemName(String name){
        log.info("Add to Cart by item name: " + name);
        SelenideElement addToCartButton = $(byXpath(String.format(addToCart, name)));
        addToCartButton.click();
    }

    public void clickOnCart(){
        log.info("Click on Cart icon");
        cartIcon.click();
    }

    public boolean checkItemNumAndNAme(int num, String name){
        log.info("Check item number and name in the Cart");
        SelenideElement number = $(byXpath(String.format(cartItemNum, num)));
        String itemName = number.$(By.xpath("div//div")).getText();

        return itemName.equals(name);
    }

}