package com.trycloud.tests.user_story3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class User_story3_3 extends TestBase {
    @Test
    public void testCase3_3(){
        BrowserUtils.sleep(5);
        WebElement filesIcon = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));

        filesIcon.click();
        BrowserUtils.sleep(5);

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://qa2.trycloud.net/index.php/apps/files/?dir=/&fileid=1118");

        WebElement clickAllFiles = driver.findElement(By.xpath("//label[@for='select_all_files']"));
        clickAllFiles.click();

        WebElement fileOption = driver.findElement(By.xpath("//*[@id=\"fileList\"]/tr[1]/td[2]/a/span[3]/a[2]"));
        fileOption.click();

        WebElement addToFavorites = driver.findElement(By.xpath("//*[@id=\"fileList\"]/tr[1]/td[2]/div/ul/li[3]/a/span[2]"));
        addToFavorites.click();

        WebElement favorite = driver.findElement(By.xpath("//*[@id=\"app-navigation\"]/ul/li[3]/a"));
        favorite.click();
        BrowserUtils.sleep(3);

        /*WebElement fileOptionOnFavorites = driver.findElement(By.xpath("//a[@class='action action-menu permanent']"));
        fileOptionOnFavorites.click();

        WebElement removeFromFavorite = driver.findElement(By.xpath("//a[@class='menu-option option-favorite']"));
        removeFromFavorite.click();

         */
        WebElement icon = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));

        icon.click();

        WebElement talkFile = driver.findElement(By.xpath("//*[@id=\"fileList\"]/tr[1]/td[2]/a"));
        talkFile.click();

        WebElement talkFileReadMe = driver.findElement(By.xpath("//a[@href='/index.php/apps/files?dir=/Talk&openfile=4211']"));
        talkFileReadMe.click();

        WebElement comment = driver.findElement(By.xpath("//div[@class='ProseMirror']"));
        comment.sendKeys("Hello");

        WebElement closeComment = driver.findElement(By.xpath("//button[@class='action-item action-item--single header-close icon-close undefined undefined has-tooltip']"));
        closeComment.click();

        WebElement setting = driver.findElement(By.xpath("//button[@class='settings-button']"));
        setting.click();


        WebElement checkbox = driver.findElement(By.xpath("//label[@for='showhiddenfilesToggle']"));
        checkbox.click();

        WebElement storage = driver.findElement(By.xpath("//a[@class='icon-quota svg']"));
        Assert.assertTrue(storage.isDisplayed());





    }
    /*
    /*As a user, I should be able to access to Files module.
1-AC: verify users can access to Files module.
2-AC: verify users can select all the uploaded files from the page.
3-AC:verify users can add a file to favorites.
4-AC:verify users can remove a file from favorites.

     */
    /*
5-AC:verify users can upload a file directly to the homepage (File-Uploading)
6-AC:verify users can create a folder
7-AC:verify users can upload a file inside a folder.
8-AC:verify users can delete a file/folder.
9-AC:verify users can write comments to files/folders.
10-AC:verify users can change the app Settings.
11-AC:verify users see the app storage usage


     */
}
