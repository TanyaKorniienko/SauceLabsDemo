package org.saucelabsdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    private String user_name;
    private String user_password;

    LoginPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//form//input[@id='user-name']")
    private WebElement nameField;

    @FindBy(xpath = "//form//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//form//input[@id='login-button']")
    private WebElement loginButton;

    public void inputLoginInfo(String user_name, String user_password){
        nameField.sendKeys(user_name);
        passwordField.sendKeys(user_password);
        clickLoginButton();
    }
    public CatalogPage clickLoginButton() {
        loginButton.click();
        return new CatalogPage((ChromeDriver) driver);
    }
}
