package com.peoplentech.practiceSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;



    public static void setupDriver(String browserName) {                //parameterize to select the browser we want to use

        //create condition that will determine which browser to use

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 2"); //driver created for chrome
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");     //driver created for firefox
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);                 //if a page takes too long to load, it should wait 20 seconds and quit
        driver.manage().window().maximize();                                                    // to maximize the window when browser starts
    }


    public static void navigateToURL(String url) {
        driver.get(url);
    }

    public static void sleepFor(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickOnElement(String element) {
        driver.findElement(By.xpath(element)).click();
    }


    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void closeDriver() {
        // driver.close();
        driver.quit();                      // quit browser's all instances including any tabs it may have opened during testing
    }
}
