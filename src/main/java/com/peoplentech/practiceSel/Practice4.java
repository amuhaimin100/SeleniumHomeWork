package com.peoplentech.practiceSel;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Practice4 extends TestBase {


    private static Logger LOGGER= Logger.getLogger(Practice4.class);
    @Test
    public static void validateDragAndDrop() {
        setupDriver("chrome");
        navigateToURL("http://demo.guru99.com/test/drag_drop.html");
        sleepFor(2);
        // drag and drop means we have to pick up an object from a source and drop it in the destination
        //so we need a source xpath and a destination xpath

        //source
        WebElement source = driver.findElement(By.xpath("(//li[@data-id=\"2\"])[1]"));  //no action is performed, holding the xpath value into variable named source

        //destination
        WebElement destination = driver.findElement(By.xpath("//ol[@id=\"amt8\"]")); //holding xpath value in destination

        //create object of the class Actions from selenium Actions() is a parameterized constructor so we send driver object in the parameter

        Actions actions = new Actions(driver);

        //now we perform the action to use the source and destination values

        actions.dragAndDrop(source, destination).build().perform();

        sleepFor(3);

        closeDriver();

    }

    @Test(enabled = false)
    public static void validateiFrame() {
        setupDriver("firefox");
        navigateToURL("https://eangusbenefits.godaddysites.com/");
        sleepFor(2);

        //first we switch the driver to the child frame
        driver.switchTo().frame("frame1");             //frame() can take one of three values, 1.id 2.name or 3.index

        //once switched, we can find the xpaths from inside the child page

        driver.findElement(By.xpath("an xpath from child page")).click();

        //now if we want to perform action inside the main page, we need to switch back our driver using defaultContent()

        driver.switchTo().defaultContent();

        //now you can perform main page testing

        driver.findElement(By.xpath("xpath from main page")).click();

        sleepFor(3);
        closeDriver();

    }

    @Test
    public static void validateDropDown() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com/");
        sleepFor(3);

        //capture the options from categories next to the search bar and store them into categories
        WebElement categories = driver.findElement(By.id("gh-cat"));

        //we use class named Select and inside the Select() constructor we give what we are trying to select
        Select select = new Select(categories);

        //we tell selenium to find a specific element from the categories by the way the text is shown in the webpage
        select.selectByVisibleText("Video Games & Consoles");

        //type in the search box
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("PlayStation 5");

        sleepFor(3);

        //click on the search button
        driver.findElement(By.id("gh-btn")).click();

        sleepFor(3);
        closeDriver();


    }

    @Test
    public static void validateMouseHover() {

        setupDriver("chrome");
        navigateToURL("https://www.ebay.com/");
        sleepFor(3);

        //we can only use linkText if the value is href followed by a link
        //create a container to hold the value we get from linkText
        WebElement category = driver.findElement(By.linkText("Electronics"));

        //use Actions class and give driver parameter inside Actions constructor
        Actions actions = new Actions(driver);

        //we are telling our action class to perform a move to element action (only move over it, do not click)
        actions.moveToElement(category).build().perform();
        sleepFor(5);

        //select the element we want to click. Since this too has a href value, we can use linkText
        driver.findElement(By.linkText("Video & PC Gaming")).click();

        sleepFor(3);

        navigateBack();

        //select a new category
        WebElement category2= driver.findElement(By.linkText("Home & Garden"));

        //perform the hover actions
        actions.moveToElement(category2).build().perform();
        sleepFor(3);

        //click on an item from the menu
        driver.findElement(By.linkText("Tools")).click();

        sleepFor(3);

        navigateBack();
        sleepFor(2);
        closeDriver();

    }


    @Test
    public static void validateHoverOnMacys(){
        setupDriver("chrome");
        navigateToURL("https://www.macys.com/");
        sleepFor(3);

        driver.findElement(By.xpath("//span[@id=\"shopByDepartmentLabelText\"]")).click();
        sleepFor(3);
        WebElement department= driver.findElement(By.linkText("Men"));

        Actions actions= new Actions(driver);

        actions.moveToElement(department).build().perform();

        sleepFor(3);

        driver.findElement(By.linkText("Boots")).click();

        sleepFor(3);

        navigateBack();

        closeDriver();
    }

    @Test
    public static void validateScroll(){
        setupDriver("chrome");

        navigateToURL("https://www.ebay.com/");
        sleepFor(3);

        //call JavascriptExecutor interface and enable to driver to run JavaScriptExecutor
        JavascriptExecutor je= (JavascriptExecutor)driver;

        //JavascriptExecutor has a method named executeScript where we can send window.scrollBy
        je.executeScript("window.scrollBy(0,1000)");

        sleepFor(3);

        //scroll back halfway and wait
        je.executeScript("window.scrollBy(0,-500)");

        sleepFor(3);

        //scroll back up rest of the way
        je.executeScript("window.scrollBy(0,-500)");

        sleepFor(3);

        closeDriver();

    }

    @Test
    public static void validateScrollToElement(){
        setupDriver("chrome");

        navigateToURL("https://www.ebay.com/");
        sleepFor(3);

        //find the option we want to scroll down to
        WebElement element= driver.findElement(By.linkText("Start selling"));

        //call JavascriptExecutor and enable driver
        JavascriptExecutor je= (JavascriptExecutor)driver;

        //
        je.executeScript("arguments[0].scrollIntoView(true);",element);

        sleepFor(3);

        driver.findElement(By.linkText("Start selling")).click();

        sleepFor(4);

        navigateBack();

        closeDriver();
    }

    @Test
    public static void validatePopup(){
        setupDriver("chrome");
        navigateToURL("http://demo.guru99.com/test/delete_customer.php");
        sleepFor(3);

        //send key to type inside the box
        driver.findElement(By.xpath("//input[@name=\"cusid\"]")).sendKeys("1");
        //click submit
        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();

        //a browser popup asks if you'd like to submit the form...we want to store the data and click ok

        //hold the value of the first popup by using getText() method
        String popup1= driver.switchTo().alert().getText();

        //print the data
        LOGGER.info(popup1);

        //we switch driver to alert and then accept or dismiss
        driver.switchTo().alert().accept();

        //if you dismiss we won't get a second popup and won't need to hold the second popup
        //store the second popup into popup2 using getText();
        String popup2= driver.switchTo().alert().getText();

        //print the data
        LOGGER.info(popup2);

        sleepFor(3);
        closeDriver();

    }
}
