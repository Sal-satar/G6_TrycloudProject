package com.trycloud.tests.user_story6;

import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class User_Story6 {


    /*6. Story: As a user, I should be able to access to Deck module.
Test case #1 - verify users can access to Deck module
     */


    //1. Login as a user
    @Test
    public void login_as_a_user() {

        WebDriver driver = WebDriverFactory.getDriver(" http://qa.trycloud.net/index.php/login?clear=1");
        driver.manage().window().maximize();
        driver.findElement(By.id("user")).sendKeys("user6");
        driver.findElement(By.id("password")).sendKeys("Userpass123" + Keys.ENTER);

//2. Click “Deck” module
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='/index.php/apps/deck/']")).click();

//3. Verify the page tile/URL is Deck module’s tile
        String expectedTitle = "Deck";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title verification Passed!");
        }else{
            System.out.println("Title verification Failed!");
        }

//Test case #2 - verify users can send notes in the page


//1. Click “Add board” button
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='app-navigation-toggle']")).click();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@class='app-navigation-entry-icon icon-add']")).click();

//2. Write a message/Note
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("name"+Keys.ENTER);

//3. Verify the note is added on the note list
        Assert.assertTrue(driver.findElement(By.xpath("//span[@title='name']")).isDisplayed());

    }
}

