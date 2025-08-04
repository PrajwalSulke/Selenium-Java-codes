package Project.DefineLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Bhaane_SearchTest {
    public WebDriver driver;

    @BeforeMethod
    public void Setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();  // to maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bhaane.com/");

        try { Thread.sleep(3000); } catch (InterruptedException e) {}
    }

    @Test
    public void search() throws InterruptedException {
        driver.findElement(By.xpath("//img[@class='ico trigger-search']")).click();
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='search']"));
        searchInput.sendKeys("shirt");
        searchInput.sendKeys(Keys.ENTER);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
