package Project.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OrangeHRM_P8 {

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
    public void EmpList() throws InterruptedException {

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        // Click on PIM
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
        //Click on Employee List
        driver.findElement(By.xpath("//a[normalize-space()='Employee List']")).click();
        // Add wait to load all the Employee list
        Thread.sleep(3000);
        //Scroll till bottom
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //Get all the Rows in Employee table
        List<WebElement>  emp = driver.findElements(By.xpath("//div[@class='orangehrm-container']//div[@role='row']//div[3]"));

        System.out.println("Employee Names: ");

        for(WebElement nameElement : emp ) {
            System.out.println(" - "+ nameElement.getText());
        }

    }

    @AfterMethod
    public void TearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

}



