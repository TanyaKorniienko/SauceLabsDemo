package org.saucelabsdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;


    CartPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkOutButton;

    public CheckOutInfo submitOrder() {
        checkOutButton.click();
        return new CheckOutInfo((ChromeDriver) driver);
    }
}
