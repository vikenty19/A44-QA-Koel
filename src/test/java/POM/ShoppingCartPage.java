package POM;

import Base.BasePage;
import Base.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage {

    public static By shopping = By.cssSelector("a.btn-primary");

    public static void navigateToCheckOutPage(){
        WebElement shopCart = BasePage.wait.until(
                ExpectedConditions.elementToBeClickable(shopping));
        Elements.clickOnlyIfElementPresent(shopCart);

    }
}
