package org.saucelabsdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogPage {
    private WebDriver driver;

    public CatalogPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//div[@class= 'inventory_list']//div")
    List<WebElement> goods;
    @FindBy(xpath = "//button[text()='Add to cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//div[@id='shopping_cart_container']//a[@class='shopping_cart_link']")
    WebElement goodsCart;

    public void addItemToCart() {
        goods.get(0);
        addToCartButton.click();
    }
    public CartPage openCart() {
        goodsCart.click();
        return new CartPage((ChromeDriver) driver);
    }
}
