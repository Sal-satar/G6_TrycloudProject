package com.trycloud.tests.user_story3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_story3 extends TestBase {

/*
1.Login as a user
2.Click action-icon from any file on the page
3.Choose “Add to Favorites” option
4.Click “Favorites” sub-module on the lest side
5.Verify the chosen file is listed on the table

 */

    @Test
    public void testCase3(){

        BrowserUtils.sleep(5);
        WebElement filesIcon = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));

        filesIcon.click();
        BrowserUtils.sleep(5);


        WebElement fileOption = driver.findElement(By.xpath("//*[@id=\"fileList\"]/tr[1]/td[2]/a/span[3]/a[2]"));
        fileOption.click();

        BrowserUtils.sleep(5);
        WebElement addToFavorites = driver.findElement(By.xpath("//*[@id=\"fileList\"]/tr[1]/td[2]/div/ul/li[3]/a/span[2]"));
        addToFavorites.click();

        WebElement favorite = driver.findElement(By.xpath("//*[@id=\"app-navigation\"]/ul/li[3]/a"));
        favorite.click();

        ;WebElement talkFile = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[4]/table/tbody/tr/td[1]/a"));
        Assert.assertTrue(talkFile.isDisplayed());








    }
}
