package Project.DefineLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class bhaane_signInTest {
    public WebDriver driver ;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();  // to maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Add implicitly wait for all elements
        driver.get("https://www.bhaane.com/");
        // add wait to close pop manually
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
    }

    @Test
    public void validLogin(){
        driver.findElement(By.xpath("//li[@class='col hidden-xs']")).click();  // click on account
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("naturevideo49@gmail.com");
        driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys("bhaane@123");
        driver.findElement(By.xpath("//button[@class='btn btn-primary'][normalize-space()='submit']")).click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals("Elevated separates for Men & Women: Midi skirts & T-shirts | Bhaane",pageTitle);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
