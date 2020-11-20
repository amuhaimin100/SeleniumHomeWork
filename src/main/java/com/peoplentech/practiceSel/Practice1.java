package com.peoplentech.practiceSel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(3500);

        driver.close();

    }



}
