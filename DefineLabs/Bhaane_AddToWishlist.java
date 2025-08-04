package Project.DefineLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Bhaane_AddToWishlist {
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
    public void wishlist() throws InterruptedException {
        // CLick on top
        driver.findElement(By.xpath("//li[@class='col bold']//a")).click();
        //Add wait to load a Page
        Thread.sleep(3000);
        // Locate Webelement
        driver.findElement(By.xpath("//img[@alt='Bhaane fall autumn sweat']")).click();
        // To wishlist a product
        driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-wishlist-button btn-lg button-xs mt-lg ']//img[@class='ico mr-5 wishlist-align']")).click();
        System.out.println("Product added to wishlist successfully");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
