package Project.DefineLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Bhaane_AddToBagAndCheckout {
    public WebDriver driver ;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();  // to maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bhaane.com/");
        // add wait to close pop manually
        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        driver.findElement(By.xpath("//li[@class='col hidden-xs']")).click();  // click on account
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("naturevideo49@gmail.com");
        driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys("bhaane@123");
        driver.findElement(By.xpath("//button[@class='btn btn-primary'][normalize-space()='submit']")).click();

    }
    @Test
    public void add() throws InterruptedException {
        driver.navigate().to("https://www.bhaane.com/products/fall-autumn-sweat");
        //Select product size
        driver.findElement(By.xpath("//span[normalize-space()='xs']")).click();
        // Select Colour
        driver.findElement(By.xpath("//span[@title='fall']")).click();
        // Click on Add to bag
        driver.findElement(By.xpath("//span[@class='bold add-to-bag'][normalize-space()='add to bag']")).click();
        Thread.sleep(2000);
        // Click on go to cart
        driver.findElement(By.xpath("//a[normalize-space()='go to cart']")).click();
        // Click on Checkout
        driver.findElement(By.xpath("//button[normalize-space()='checkout']")).click();

        System.out.println("Checkout the Product Successfully");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
