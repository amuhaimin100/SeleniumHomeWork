package com.peoplentech.practiceSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Practice3 extends TestBase {

    @Test
    public static void validateUsersCanTypeOnSearchBar() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com/");
        sleepFor(3);
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("PlayStation 5");
        sleepFor(4);
        closeDriver();
    }


    @Test
    public static void validateUsersCanTypeOnSearchBarAndClickSearchButton() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com/");
        sleepFor(3);
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("PlayStation 5");
        sleepFor(4);
        driver.findElement(By.id("gh-btn")).click();
        sleepFor(5);
        navigateBack();
        sleepFor(3);

        closeDriver();
    }

    @Test
    public static void validateProductDropDown(){
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com/");
        sleepFor(3);

        //import all the categories from the search options
        String data=driver.findElement(By.xpath("//select[@id='gh-cat']")).getText();

        //print the data
        System.out.println(data);

        //store all the elements in a list
        List <WebElement> categories=driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        System.out.println(categories.size());

        //select specific item from the list
        categories.get(11).click();

        sleepFor(3);

        closeDriver();


    }

    @Test
    public static void validateUserCanTypeOnSearchBarAndChooseFromDropDown(){
        setupDriver("firefox");

        navigateToURL("https://www.ebay.com/");

        sleepFor(3);

        //type in the searchbox
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("PlayStation 5");
        sleepFor(4);

        //create a list to store all the categories
        List <WebElement> categories=driver.findElements(By.xpath("//select[@id='gh-cat']/option"));

        //select video games
        categories.get(34).click();

        sleepFor(3);

        //hit search button
        driver.findElement(By.id("gh-btn")).click();
        sleepFor(5);

        navigateBack();
        closeDriver();

    }

    @Test
    public static void seleniumMethods(){
        setupDriver("firefox");
        navigateToURL("https://www.ebay.com/");

        //create a variable to store one element value to click on using .click()
        WebElement clickElement= driver.findElement(By.id("gh-btn"));
        clickElement.click();
        sleepFor(2);


        //after clicking search click on ebay motors
        driver.findElement(By.xpath("//h2[text()='eBay Motors']")).click();
        sleepFor(3);

        //.getCurrentURL() returns current url, store into currentUrl
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);

        Assert.assertTrue(currentUrl.contains("Auto-Parts-and-Vehicles"));

        sleepFor(3);

        //we are validating if the actual and expected match
        Assert.assertEquals("https://www.ebay.com/", currentUrl);

        closeDriver();
    }

    @Test
    public static void seleniumMethod2(){
        //use the search bar to search and validate the data shown on top of the result match the expected

        setupDriver("firefox");
        navigateToURL("https://www.ebay.com/");

        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("PlayStation 5");
        sleepFor(4);
        driver.findElement(By.id("gh-btn")).click();
        sleepFor(5);

        //creating element to hold the value we get from the xpath
        WebElement element= driver.findElement(By.xpath("//span[text()='PlayStation 5']"));
        String actualText= element.getText();
        //System.out.println(actualText);

        Assert.assertEquals(actualText, "PlayStation 5");

        closeDriver();
    }
}
