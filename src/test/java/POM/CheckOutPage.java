package POM;


import Base.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage {
    private WebDriver driver;
    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    public  By shopping = By.cssSelector("a[title='Checkout']");
    public   By continueBtnOfBillingAddress= By.id("button-payment-address");
    public   By continueBtnOfShippingAddress= By.id("button-shipping-address");
    public   By continueBtnOfShippingMethod= By.id("button-shipping-method");
    public  By continueBtnOfPaymentMethod= By.id("button-payment-method");
public   By completeOrder = By.id("button-confirm");

    public By policyConfirm = By.name("agree");
    public By negativeAlert = By.cssSelector(".alert.alert-danger");

    public void navigateToCheckOutPage(){
        WebElement shopCart = hooks.MyHooks.wait.until(
                ExpectedConditions.elementToBeClickable(shopping));
        Elements.clickOnlyIfElementPresent(shopCart);

    }
    public  void placeTheOrder(){
        WebElement continueBtnOfBillingSection = hooks.MyHooks.wait
                .until(ExpectedConditions.visibilityOfElementLocated(continueBtnOfBillingAddress));
        Elements.clickOnlyIfElementPresent(continueBtnOfBillingSection);
        WebElement continueBtnOfShippingSection = hooks.MyHooks.wait
                .until(ExpectedConditions.visibilityOfElementLocated(continueBtnOfShippingAddress));
        Elements.clickOnlyIfElementPresent(continueBtnOfShippingSection);
        WebElement continueBtnOfShippingMethodSection = hooks.MyHooks.wait
                .until(ExpectedConditions.visibilityOfElementLocated(continueBtnOfShippingMethod));
        Elements.clickOnlyIfElementPresent(continueBtnOfShippingMethodSection);
        WebElement privacyPolicyBox = hooks.MyHooks.wait
                .until(ExpectedConditions.visibilityOfElementLocated(policyConfirm));
        Elements.clickOnlyIfElementPresent(privacyPolicyBox);
        WebElement continueOrderBtn = hooks.MyHooks.wait
                .until(ExpectedConditions.visibilityOfElementLocated(continueBtnOfPaymentMethod));
        Elements.clickOnlyIfElementPresent(continueOrderBtn);
        WebElement orderCompleteBtn= hooks.MyHooks.wait
                .until(ExpectedConditions.visibilityOfElementLocated(completeOrder));
        Elements.clickOnlyIfElementPresent(orderCompleteBtn);
    }
    public  String outOfStockWarningMessage(){
        WebElement outOfStockMessage = hooks.MyHooks.wait
                .until(ExpectedConditions.visibilityOfElementLocated(negativeAlert));
        return outOfStockMessage.getText();
    }
}
