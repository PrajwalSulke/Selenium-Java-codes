package Project.AutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    //Locators
    By loginLink = By.xpath("//a[normalize-space()='Signup / Login']");
    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@placeholder='Password']");
    By loginBtn = By.xpath("//button[normalize-space()='Login']");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");

    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Navigate to Login page
    public void goToLoginPage(){
        driver.findElement(loginLink).click();
    }

    // Perform login action
    public void login(String email, String password){
        driver.findElement(emailField).sendKeys("naturevideo49@gmail.com");
        driver.findElement(passwordField).sendKeys("Test@1234");
        driver.findElement(loginBtn).click();
    }

    // Verify if login was successful
    public boolean isLoginSuccessful(){
        return driver.findElement(loggedInText).isDisplayed();
    }
}
