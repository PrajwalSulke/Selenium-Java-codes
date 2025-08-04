package Project.OrangeHRM;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRM_P2 {
    public String BaseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;

    @BeforeMethod
    public void Setup(){
        System.out.println("Application will setting up......");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(BaseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void AddEmp() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Add Employee']")).click();

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("pppp");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("asdf");
        //driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("0536");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

        //driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")).click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        WebElement saveBTN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")));
        //saveBTN.click();
        // Scroll and click using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", saveBTN);
        js.executeScript("arguments[0].click();", saveBTN);




        //validation
        String msg = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).getText();

        Assert.assertEquals("Personal Details",msg);
        Thread.sleep(2000);

//        String confirmMsg = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).getText();
//        if()

//        driver.findElement(By.xpath("//a[@class='oxd-brand']")).click();
//        driver.findElement(By.xpath("//a[@class='oxd-brand']"));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        driver.close();
        driver.quit();

    }


}
