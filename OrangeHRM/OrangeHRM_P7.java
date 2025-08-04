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

public class OrangeHRM_P7 {

    public String BaseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;

    @BeforeMethod
    public void Setup() {
        System.out.println("Application will setting uppp....");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void deleteEMP() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();


        String EMPid = "0502";

        // Click on PIM
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
        //Click on Employee List
        driver.findElement(By.xpath("//a[normalize-space()='Employee List']")).click();
        //to search employee enter id
        WebElement id = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
        id.sendKeys(EMPid);
        // click on search
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        // Scroll down to see result
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+ 500 +")");
        Thread.sleep(3000);

        // click on trash
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-trash'])[1]")).click();
        // confirm delete
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']")).click();

        // Verify , there is no element present
        String actual_result = driver.findElement(By.xpath("//span[normalize-space()='No Records Found']")).getText();

        Assert.assertEquals(actual_result,"No Records Found");
    }

    @AfterMethod
    public void TearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
