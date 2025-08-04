package Project.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OrangeHRM_P3 {
    public String BaseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;

    @BeforeMethod
    public void Setup(){
        System.out.println("Application will setting uppp....");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void SearchEMP() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        // Search
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();  // click PIM
        // select emp list
        driver.findElement(By.xpath("//a[normalize-space()='Employee List']")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("manda");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        //Scroll down to see result
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollby(0,500)");
//        String expectedmsg = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).getText();
//
//        Assert.assertEquals("Records Found",expectedmsg);

        List<WebElement> element = driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span']"));

        String Expected_result = "Records Found";
        String Actual_result = element.get(0).getText();

        Assert.assertTrue(Actual_result.contains(Expected_result));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(3));
        driver.close();
        driver.quit();
    }
}
