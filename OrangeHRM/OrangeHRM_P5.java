package Project.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

public class OrangeHRM_P5 {
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
    public void addFile() throws AWTException {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        // Click on PIM
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
        // Click on configuration
        driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']")).click();
        //click on Data Import
        driver.findElement(By.xpath("//a[normalize-space()='Data Import']")).click();
        //click on Browse
        //driver.findElement(By.xpath("//div[@class='oxd-file-button']")).sendKeys("D:\\IntelliJ IDEA\\importData.csv");
        WebElement upload = driver.findElement(By.xpath("//div[@class='oxd-file-button']"));

        Actions act = new Actions(driver);
        act.moveToElement(upload).click().perform();

        Robot rb = new Robot();
        rb.delay(2000);

        //Copy file to Clipboard
        StringSelection ss = new StringSelection("\"D:\\IntelliJ IDEA\\importData.csv\"");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);


    }

}
