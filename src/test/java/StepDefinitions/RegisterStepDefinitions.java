package StepDefinitions;

import io.cucumber.java.en.And;

import static CucumberPOM.ForgotPassword_RegisterPage.emailToForgottenPass;
import static StepDefinitions.LoginStepDefinitions.driver;
import static StepDefinitions.LoginStepDefinitions.registerUrl;

public class RegisterStepDefinitions {
    @And("I open registration page")
    public void iOpenRegistrationPage() {
        driver.get(registerUrl);
    }

    @And("I enter my valid email {string} and submit it:")
    public void iEnterMyValidEmailAndSubmitIt(String email) {
        emailToForgottenPass.sendKeys(email);

    }
}
