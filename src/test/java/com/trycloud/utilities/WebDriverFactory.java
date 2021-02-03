package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browsertype) {
        if (browsertype.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            return new ChromeDriver();
        } else {
            System.out.println("Browser dosen't exist");
            return null;
        }

    }

}
