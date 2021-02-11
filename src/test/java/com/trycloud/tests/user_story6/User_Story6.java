package com.trycloud.tests.user_story6;

import com.trycloud.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class User_Story6 {


    /*6. Story: As a user, I should be able to access to Deck module.
Test case #1 - verify users can access to Deck module
     */


    //1. Login as a user


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("http://qa2.trycloud.net/");
        WebElement userName = driver.findElement(By.id("user"));
        userName.sendKeys("User6");
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("Userpass123");
        WebElement logIn = driver.findElement(By.id("submit-form"));
        logIn.submit();


//2. Click “Deck” module
            driver.findElement(By.xpath("//a[@href='/index.php/apps/deck/']")).click();

//3. Verify the page tile/URL is Deck module’s tile
            String expectedTitle = "Deck";
            String actualTitle = driver.getTitle();

            if (actualTitle.contains(expectedTitle)) {
                System.out.println("Title verification Passed!");
            } else {
                System.out.println("Title verification Failed!");
            }

//Test case #2 - verify users can send notes in the page


//1. Click “Add board” button
            driver.findElement(By.xpath("//a[@class='app-navigation-toggle']")).click();
            driver.findElement(By.xpath("//div[@class='app-navigation-entry-icon icon-add']")).click();

//2. Write a message/Note
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("name" + Keys.ENTER);

//3. Verify the note is added on the note list
            Assert.assertTrue(driver.findElement(By.xpath("//span[@title='name']")).isDisplayed());

        }
    }

