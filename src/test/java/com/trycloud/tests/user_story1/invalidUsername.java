package com.trycloud.tests.user_story1;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class invalidUsername {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.trycloud.net/index.php/login");
        driver.get(ConfigurationReader.getProperty("URL"));
    }
    @Test
    public void InvalidUsername() throws InterruptedException, IOException {
        String invalidusername = "User1";
        String invalidpassword = "123";

        WebElement invalid = driver.findElement(By.xpath("//input[@id='user']"));
        invalid.sendKeys(invalidusername);

        WebElement validpassword = driver.findElement(By.xpath("//input[@id='password']"));
        validpassword.sendKeys(invalidpassword);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='submit-form']"));
        loginButton.click();
    }

    public void wrongMassage() throws InterruptedException, IOException {

        String expectedTitle = "Wrong username or password";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Message is displayed!!!");


    }

}
