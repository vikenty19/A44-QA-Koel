package StepDefinitions;

import CucumberPOM.ForgotPassword_RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static CucumberPOM.ForgotPassword_RegisterPage.*;
import static StepDefinitions.LoginStepDefinitions.driver;
import static StepDefinitions.LoginStepDefinitions.registerUrl;

public class RegisterStepDefinitions {

    @And("I open registration page")
    public void iOpenRegistrationPage() {
        driver.get(registerUrl);
    }


    @Then("I should see a message that new password was sent to my email")
    public void iShouldSeeAMessageThatNewPasswordWasSentToMyEmail() {
        Assert.assertEquals(InfoMessage.getText(),"You will receive an email with your new credentials");
    }
    @And("I enter my valid email {string} and submit it:")
    public void iEnterMyValidEmailAndSubmitIt(String email) {
        WebElement emailToForgottenPass = LoginStepDefinitions.wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));
        emailToForgottenPass.sendKeys(email);
        WebElement submitBtn = LoginStepDefinitions.wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#button")));
        submitBtn.click();

    }
    @And("I click Submit button")
    public void iClickSubmitButton() {
       WebElement submitBtn = LoginStepDefinitions.wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#button")));
        submitBtn.click();
    }

    @Then("I should see a message that entered data is not valid")
    public void iShouldSeeAMessageThatEnteredDataIsNotValid() {
        WebElement warningMessage=LoginStepDefinitions.wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.errors")));
        Assert.assertEquals(warningMessage.getText(),"The given data was invalid.");


    }

    @And("I enter email without special symbols {string}")
    public void iEnterEmailWithoutSpecialSymbols(String email) {
        WebElement emailToForgottenPass = LoginStepDefinitions.wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));
        emailToForgottenPass.sendKeys(email);
    }

    @Then("I should see a message that email must contain special symbols")
    public void iShouldSeeAMessageThatEmailMustContainSpecialSymbols() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement warningMessage=LoginStepDefinitions.wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.errors")));
        String message = (String)js.executeScript("return.arguments[0].validationMessage",warningMessage);
        System.out.println(message);
    }






    /*     JavascriptExecutor js = (JavascriptExecutor)driver;
        String message = (String)js.executeScript("return.arguments[0].validationMessage",warningMessage);
        System.out.println(message);*/
}
