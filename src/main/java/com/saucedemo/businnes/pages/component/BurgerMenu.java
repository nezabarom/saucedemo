package com.saucedemo.businnes.pages.component;

import com.codeborne.selenide.SelenideElement;
import com.saucedemo.businnes.pages.AbstractPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class BurgerMenu extends AbstractPage {
SelenideElement burgerMenuButton = $(By.xpath("//*[text()[contains(.,'Open Menu')]]"));

    public void clickBurgerMenuButton() {
        log.info("Click on log Out button");
        burgerMenuButton.click();
    }

}