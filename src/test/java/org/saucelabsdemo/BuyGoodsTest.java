package org.saucelabsdemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyGoodsTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void buyGoods() {
        LoginPage loginPage = new LoginPage((ChromeDriver) driver);
        loginPage.inputLoginInfo("standard_user", "secret_sauce");
        CatalogPage catalogPage = new CatalogPage((ChromeDriver) driver);
        catalogPage.addItemToCart();
        catalogPage.openCart();
        CartPage cart = new CartPage((ChromeDriver) driver);
        cart.submitOrder();
        CheckOutInfo checkoutInfo = new CheckOutInfo((ChromeDriver) driver);
        checkoutInfo.checkUserOutInfo("Elena", "Robertson", "32424");
        checkoutInfo.finishOrder();
        FinishPage finishPage = new FinishPage((ChromeDriver) driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header_secondary_container']")));
        finishPage.returnToCatalogPage();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.saucedemo.com/inventory.html");
        System.out.println("URLs are equals");
    }

    @After
    public void close() {
        driver.close();
    }
}
