package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class User_Register
{
  protected static WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        //setting up chromedriver path from your system
        System.setProperty("webdriver.chrome.driver",
                "src\\test\\Resource\\Browser\\chromedriver.exe");
        //creating object for driver
        driver = new ChromeDriver();
        //maximize the browser window
        driver.manage().window().maximize();
        //Apply implicitlyWait to driver object

        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        //open URL
        driver.get("https://demo.nopcommerce.com/");
        // WebDriverWait wait=new WebDriverWait(driver,120);

    }

    @Test
    public void user_Register_Successfully_Test() throws InterruptedException {

        //timestamp for current time- to create unique email value each time we run the program
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Click on register button
        driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
        Thread.sleep(1000);

        //click on gender
        driver.findElement(By.xpath("//input[@id=\"gender-female\"]")).click();

        //type first name
        driver.findElement(By.id("FirstName")).sendKeys("Mittal");

        //type last name
        driver.findElement(By.id("LastName")).sendKeys("Kadia");

        //Type birthday
        Select selectDay = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
        selectDay.selectByValue("2");

        //Type birthMonth
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
        selectMonth.selectByIndex(2);

        //Type BirthYear
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
        selectYear.selectByVisibleText("1984");

        //Type email with timestamp
        driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("mittal" + timestamp.getTime() +
                "@gmail.com");
        //print email
        System.out.println("mittal" + timestamp.getTime() + "@gmail.com");

        //Enter Company name
        driver.findElement(By.xpath("//input[@id=\"Company\"]")).sendKeys("Primark");

        // Click on option
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();

        //Type password
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("mitu14");

        //Type confirm password
        driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("mitu14");
        //Click on register submit button
        driver.findElement(By.xpath("//button[@id=\"register-button\"]")).click();

        //expected result
        String expected_Registration_Message = "Your registration completed";

        //actual result
        String actual_Registration_Message = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();

        //actual result and expected result check
        Assert.assertEquals(actual_Registration_Message, expected_Registration_Message, "Your registartion is fail");

        //print message
        System.out.println("Your registration Assertion is pass");


    }

    @Test
    public void user_Verify_Apple_Mac_price_$2000_On_Homepage_Test() {
        //expected price $2000
        String expectedPrice = "$2000";
        //actual price $1800
        String actualPrice = driver.findElement(By.xpath("(//span[@class=\"price actual-price\"])[2]")).getText();
        //actual price and expected price check
        Assert.assertEquals(actualPrice, expectedPrice, "Your price is not match");





    }

    @Test
    public void user_Should_Be_Able_To_Click_On_Build_Your_Own_Computer_Test() {
        //click on Build your on computer
        driver.findElement(By.xpath("(//a[@href=\"/build-your-own-computer\"])[2]")).click();

        //Apply implicitlyWait to driver object
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

        //select processor 2.2 GHz intel pentium Dual-Core E2200
        Select selectProcessor=new Select(driver.findElement(By.xpath("//select[@id=\"product_attribute_1\"]")));
        selectProcessor.selectByValue("1");

        //select RAM from drop down menu 2 GB
        Select selectRAM =new Select(driver.findElement(By.xpath("//select[@name=\"product_attribute_2\"]")));
        selectRAM.selectByVisibleText("2 GB");

        //click on HDD
        driver.findElement(By.xpath("(//input[@name=\"product_attribute_3\"])[2]")).click();

        //click on OS
        driver.findElement(By.xpath("//input[@id=\"product_attribute_4_9\"]")).click();

        //click on software
        driver.findElement(By.xpath("(//input[@name=\"product_attribute_5\"])[3]")).click();
        driver.findElement(By.xpath("(//input[@name=\"product_attribute_5\"])[2]")).click();

        //click on add to cart
        driver.findElement(By.xpath("//button[@class=\"button-1 add-to-cart-button\"]")).click();

        //click on The product has been added to your "shopping cart"
        driver.findElement(By.xpath("(//a[@href=\"/cart\"])[1]")).click();

        //expected result
        String expectedShoppingCart ="Shopping cart";

        //actual result
        String actualShoppingCart=driver.findElement(By.xpath("//div[@class=\"page-title\"]")).getText();


        //actual result and expected result check
        Assert.assertEquals(actualShoppingCart,expectedShoppingCart,"Your add to cart item is match");

        //print message
        System.out.println("Your add to cart item is match");

    }
    @Test
    public void add_two_Product_In_Compare_List_Test() throws InterruptedException {


        //click HTC one M8 Android L 5.0 Lollipop compare list
        driver.findElement(By.xpath("(//button[@type=\"button\"])[8]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //click $25 Virtual gift card compare list
        driver.findElement(By.xpath("(//button[@type=\"button\"])[11]")).click();



        //click the product has been added to your product comparison
        driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]//a[@href=\"/compareproducts\"]")).click();

        //expected result
        String expectedCompare_Product = "Compare products";

        //actual result
       String actualCompare_product = driver.findElement(By.xpath("//div[@class=\"page-title\"]/h1")).getText();


        //actual result and expected result match
       Assert.assertEquals(actualCompare_product, expectedCompare_Product, "Your product Added in compare product");

        //print message
        System.out.println("\"Your product Added in compare product\"");

      Thread.sleep(1000);
        //click on clear list
       driver.findElement(By.xpath("//a[@class=\"clear-list\"]")).click();

        //expected result
       String expectedNo_Item_To_Compare="You have no items to compare.";

        //actual result
       String actualNo_Item_To_compare=driver.findElement(By.xpath("//div[@class=\"page-body\"]")).getText();

        //actual result and expected result  match
       Assert.assertEquals(actualNo_Item_To_compare,expectedNo_Item_To_Compare,"Not any item in compare list");

        //print message
        System.out.println("You have no items to compare");



    }

    @AfterMethod
    public void close_Browser(){

        //it will be close all opened browser window
         driver.quit();
    }
}
