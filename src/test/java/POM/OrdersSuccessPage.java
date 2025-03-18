package POM;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrdersSuccessPage {
    public static By success = By.xpath("//div/p[contains(text(),'Your order has been successfully processed!')]");

    public static void orderSuccessConfirmation(){

        WebElement successOrder = BasePage.wait.until(
                ExpectedConditions.visibilityOfElementLocated(success));
        Assert.assertTrue(successOrder.isDisplayed());

    }
}
