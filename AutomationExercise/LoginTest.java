package Project.AutomationExercise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();

        String email = "naturevideo49@gmail.com";
        String password = "Test@1234";

        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isLoginSuccessful(),"Login Failed!");
    }
}
