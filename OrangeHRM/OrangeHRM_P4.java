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

public class OrangeHRM_P4 {
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
    public void SearchEMP() throws InterruptedException {
        String empId = "0772" ;
        String msg_Actual = "";

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        // Search
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();  // click PIM
        // select emp list
        driver.findElement(By.xpath("//a[normalize-space()='Employee List']")).click();

        // search by id
        WebElement id = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
        id.sendKeys(empId);
        // click on search
        //driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        Thread.sleep(5000);

        //Scroll Down
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("window.scrollBy(0,"+ 500 +")");
        Thread.sleep(5000);


        // validate
//        List<WebElement>  element = driver.findElements(By.xpath("((//div[@role='row'])[2]/div[@role='cell'])[2] "));
//        String Actual_result = element.get(0).getText();
//            msg_Actual = driver.findElement(By.xpath("((//div[@role='row'])[2]/div[@role='cell'])[2] ")).getText();
//               Assert.assertEquals(empId,msg_Actual);
        List<WebElement> element = driver.findElements(By.xpath("//div[@role='row']"));
        if (element.size()>1){
            msg_Actual = driver.findElement(By.xpath("((//div[@role='row'])[2]/div[@role='cell'])[2] ")).getText();
        }
        Assert.assertEquals(empId,msg_Actual);
    }

    public void LogOut(){
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
    }

    @AfterMethod
    public void TearDown() throws InterruptedException {
        LogOut();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
