package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Automate_Contact_Form_Submission_P3 {
        WebDriver driver ;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            driver.get("https://www.globalsqa.com/contact-us/");

        }

        @Test
        public  void  testing(){

            WebElement name = driver.findElement(By.xpath("//input[@id='comment_name']"));
            name.sendKeys("Prajwal");

            WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
            email.sendKeys("prajwal@gmail.com");

            WebElement subject = driver.findElement(By.xpath("//input[@id='subject']"));
            subject.sendKeys("ABC");

            WebElement msg = driver.findElement(By.xpath("//textarea[@id='comment']"));
            msg.sendKeys("Heyy finally i submit this form...");

            driver.findElement(By.xpath("//input[@id='submit']")).click();

            WebElement robot = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
            Assert.assertTrue(robot.isDisplayed(),"Error msg not Displayed..");
            Assert.assertTrue(robot.getText().contains("Please make sure all fields are correctly filled in!"),"Unexpected error message text!");

            System.out.println("Error message validated successfully when CAPTCHA is not checked.");

        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
}
