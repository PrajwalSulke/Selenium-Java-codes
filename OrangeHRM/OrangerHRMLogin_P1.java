package Project.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class OrangerHRMLogin_P1 {

    public String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Before Test executed");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseURL);     // to navigate to URL / open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test(priority = 2)
    public void ValidCredentials() {

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();

        // Verify the page
        String pageTitle = driver.getTitle();
//        if(pageTitle.equals("OrangeHRM")){
//            System.out.println("Login Sccessful!...");
//        }else {
//            System.out.println("Login Failed!........");
//        }
        Assert.assertEquals("OrangeHRM", pageTitle);
    }

    @Test(priority = 1)
    public void invalidCredentials() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();

        // verify
        String msg_expected = "Invalid credentials";
        String msg = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();

        Assert.assertTrue(msg.contains(msg_expected));
        Thread.sleep(2000);

    }

//    @Test(priority = 3)
//    public void admin(){
//        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
//        driver.findElement(By.xpath("//a[normalize-space()='Add Employee']")).click();
//
//        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("abc");
//        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("zxc");
//
//        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
//
//        // validate
//        WebElement element = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']"));
//        Assert.assertEquals("Personal Details",element);
//
//    }


    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

}
