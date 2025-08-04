package Project.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRM_P9 {

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
    public void leave() throws InterruptedException {

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        //Click on Leave 
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Leave']")).click();
        //Click on Apply
        driver.findElement(By.xpath("//a[normalize-space()='Apply']")).click();
        //Click on Leave type
        driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'CAN')]")).click();

        Thread.sleep(2000);

        //Enter To Date
        //driver.findElement(By.xpath("//label[text()='From Date']/following::input[1]")).click();
        // //div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]

        // Enter From Date
        //driver.findElement(By.xpath("//div[@class='oxd-date-input']/input")).sendKeys("2025-03-07");
        driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]")).sendKeys("2025-03-07");

        // Comment
        driver.findElement(By.xpath("//textarea")).sendKeys("I'm leaving this...............");
        Thread.sleep(3000);

        // click onn Apply
        driver.findElement(By.xpath("//button[normalize-space()='Apply']")).submit();
        Thread.sleep(2000);


    }
    @AfterMethod
    public void TearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
