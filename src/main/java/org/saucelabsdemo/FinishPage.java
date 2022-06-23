package org.saucelabsdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='checkout_complete_container']//button[@id='back-to-products']")
    WebElement backHomeButton;

    public FinishPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CatalogPage returnToCatalogPage() {
        backHomeButton.click();
        return new CatalogPage((ChromeDriver) driver);
    }
}
