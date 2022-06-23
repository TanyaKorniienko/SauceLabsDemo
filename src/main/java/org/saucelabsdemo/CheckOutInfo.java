package org.saucelabsdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutInfo {
    WebDriver driver;
    private String first_Name;
    private String last_Name;
    private String zip_Code;

    public CheckOutInfo(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//form//div[@class='checkout_info']//input[@id='first-name']")
    WebElement firstNameField;

    @FindBy(xpath = "//form//div[@class='checkout_info']//input[@id='last-name']")
    WebElement lastNameField;

    @FindBy(xpath = "//form//div[@class='checkout_info']//input[@id='postal-code']")
    WebElement zipCodeField;

    @FindBy(xpath = "//div[@class='checkout_buttons']/input[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//div[@class='cart_footer']//button[@id='finish']")
    WebElement finishButton;

    public void checkUserOutInfo(String first_Name, String last_Name, String  zip_Code) {
        firstNameField.sendKeys(first_Name);
        lastNameField.sendKeys(last_Name);
        zipCodeField.sendKeys(zip_Code);
        continueButton.click();
    }
    public FinishPage finishOrder() {
        finishButton.click();
        return new FinishPage((ChromeDriver) driver);
    }
}
