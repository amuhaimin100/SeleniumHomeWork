package com.peoplentech.practiceSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {

    private static WebDriver driver;

    public static void main(String[] args) {

        userShouldBeAbleToClickOnSignIn();

    }

    public static void userShouldBeAbleToClickOnSignIn(){

        setupDriver();

        navigateToURL("https://www.ebay.com/");

        sleepFor(4);

        clickOnElement("(//a[text()='Sign in'])[1]");

        sleepFor(4);

        navigateBack();

        clickOnElement("//a[text()='register']");

        sleepFor(3);

        navigateBack();

        sleepFor(3);

        closeDriver();
    }

    public static void clickOnElement(String element){
        driver.findElement(By.xpath(element)).click();
    }


    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 2");
        driver = new ChromeDriver();

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
    public static void navigateBack(){
        driver.navigate().back();
    }

    public static void closeDriver() {
        driver.close();
    }

}
