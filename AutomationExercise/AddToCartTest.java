package Project.AutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddProductToCart() throws InterruptedException {
        //Scroll to see some products
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // Click Add to cart on 1st product
        driver.findElement(By.xpath("(//a[@data-product-id])[1]")).click();

        Thread.sleep(2000);

        // Click view cart
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

        // verify product is displayed in cart
        boolean isProductInCart = driver.findElement(By.xpath("//td[@class='cart_description']")).isDisplayed();
        Assert.assertTrue(isProductInCart,"Product was not added to the cart");
    }

}
