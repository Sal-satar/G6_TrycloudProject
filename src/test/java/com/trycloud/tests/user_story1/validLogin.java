package com.trycloud.tests.user_story1;


import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

public class validLogin{
    public WebDriver driver;

    @Test
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.trycloud.net/index.php/login");
        //  driver.findElement(By.id("user")).sendKeys("");
        // driver.findElement(By.id("password")).sendKeys("Userpass123" + Keys.ENTER);
        driver.get(ConfigurationReader.getProperty("URL"));

        LinkedHashMap<String ,String > validLogin = new LinkedHashMap();
        validLogin.put("user6","Userpass123");
        validLogin.put("user36","Userpass123");
        validLogin.put("user66","Userpass123");
        validLogin.put("user96","Userpass123");


        for ( String eachKey :validLogin.keySet()){
            validLogin.get(Keys.ENTER);
            System.out.println(eachKey+ " : " + validLogin.get(eachKey));
        }




    }

}



// User6, User36, User66, User96



// 3.Enter valid password
// 4.Click login button
// 5.Verify the URL is chawed to homepage’s url
// (Put this test case in testBase class with an annotation so it runs for all the test case)

