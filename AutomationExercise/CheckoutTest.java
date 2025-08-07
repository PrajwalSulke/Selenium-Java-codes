package Project.AutomationExercise;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void testCheckOut () throws InterruptedException {

        // Click Add to cart on 1st product
        driver.findElement(By.xpath("(//a[@data-product-id])[1]")).click();

        Thread.sleep(2000);

        // Click view cart
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

        // verify product is displayed in cart
        boolean isProductInCart = driver.findElement(By.xpath("//td[@class='cart_description']")).isDisplayed();
        Assert.assertTrue(isProductInCart,"Product was not added to the cart");

        // click
        //driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        Thread.sleep(2000);
        // verify
        boolean isCheckoutVisible = driver.getPageSource().contains("Checkout");
        Assert.assertTrue(isCheckoutVisible, "Checkout page not displayed");

    }
}
