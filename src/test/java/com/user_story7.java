package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class user_story7 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://app.trycloud.net/index.php/login");
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
         driver.findElement(By.cssSelector("#user")).sendKeys("User6");
        driver.findElement(By.cssSelector("#password")).sendKeys("Userpass123");
        driver.findElement(By.cssSelector("#submit-wrapper")).click();
        driver.findElement(By.cssSelector("#searchbox")).click();
        driver.findElement(By.cssSelector("#app-navigation")).click();
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
        driver.close();
        driver.quit();
    }
}
