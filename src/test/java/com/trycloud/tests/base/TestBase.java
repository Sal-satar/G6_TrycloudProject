package com.trycloud.tests.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://qa2.trycloud.net/index.php/login");
       // driver.findElement(By.id("user")).sendKeys("");
        //driver.findElement(By.id("password")).sendKeys("Userpass123" + Keys.ENTER);
        driver.get(ConfigurationReader.getProperty("URL"));

      login();

    }

    @AfterMethod
    public void tearDown(){
       // driver.close();
    }

    public void login(){
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='submit-form']")).click();
    }
}
