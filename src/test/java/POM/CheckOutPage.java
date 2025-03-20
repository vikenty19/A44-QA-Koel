package POM;

import Base.BasePage;
import Base.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckOutPage {

    public static By shopping = By.cssSelector("a[title='Checkout']");
    public static  By continueBtnOfBillingAddress= By.id("button-payment-address");
    public static  By continueBtnOfShippingAddress= By.id("button-shipping-address");
    public static  By continueBtnOfShippingMethod= By.id("button-shipping-method");
    public static  By continueBtnOfPaymentMethod= By.id("button-payment-method");
public static  By completeOrder = By.id("button-confirm");

    public static By policyConfirm = By.name("agree");
    public static By negativeAlert = By.cssSelector(".alert.alert-danger");

    public static void navigateToCheckOutPage(){
        WebElement shopCart = BasePage.wait.until(
                ExpectedConditions.elementToBeClickable(shopping));
        Elements.clickOnlyIfElementPresent(shopCart);

    }
    public static void placeTheOrder(){
        WebElement continueBtnOfBillingSection = BasePage.wait
                .until(ExpectedConditions.visibilityOfElementLocated(continueBtnOfBillingAddress));
        Elements.clickOnlyIfElementPresent(continueBtnOfBillingSection);
        WebElement continueBtnOfShippingSection = BasePage.wait
                .until(ExpectedConditions.visibilityOfElementLocated(continueBtnOfShippingAddress));
        Elements.clickOnlyIfElementPresent(continueBtnOfShippingSection);
        WebElement continueBtnOfShippingMethodSection = BasePage.wait
                .until(ExpectedConditions.visibilityOfElementLocated(continueBtnOfShippingMethod));
        Elements.clickOnlyIfElementPresent(continueBtnOfShippingMethodSection);
        WebElement privacyPolicyBox = BasePage.wait
                .until(ExpectedConditions.visibilityOfElementLocated(policyConfirm));
        Elements.clickOnlyIfElementPresent(privacyPolicyBox);
        WebElement continueOrderBtn = BasePage.wait
                .until(ExpectedConditions.visibilityOfElementLocated(continueBtnOfPaymentMethod));
        Elements.clickOnlyIfElementPresent(continueOrderBtn);
        WebElement orderCompleteBtn= BasePage.wait
                .until(ExpectedConditions.visibilityOfElementLocated(completeOrder));
        Elements.clickOnlyIfElementPresent(orderCompleteBtn);
    }
    public static String outOfStockWarningMessage(){
        WebElement outOfStockMessage = BasePage.wait
                .until(ExpectedConditions.visibilityOfElementLocated(negativeAlert));
        return outOfStockMessage.getText();
    }
}
