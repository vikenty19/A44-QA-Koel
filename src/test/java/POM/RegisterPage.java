package POM;

import Base.Elements;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static StepDefinitions.StepsToTutorialsLogin.driver;

public class RegisterPage {
    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name =firstname]")
    public static WebElement firstName;
    // public By firstName = By.cssSelector("[name =firstname]");
    @FindBy(id = "input-lastname")
    public static WebElement lastName;
    @FindBy(id = "input-email")
    public static WebElement emailAddress;
    @FindBy(id = "input-telephone")
    public static WebElement phone;
    @FindBy(id = "input-password")
    public static WebElement passwordField;
    @FindBy(id = "input-confirm")
    public static WebElement passwordConfirm;
    @FindBy(name = "agree")
    public static WebElement agree;
    @FindBy(css = "input[type ='submit']")
    public static WebElement submitBtn;
    public static void enterAllDetails(DataTable dataTable){
        Map<String,String> map =dataTable.asMap(String.class,String.class);
        Elements.TypeText(RegisterPage.firstName,map.get("FirstName"));
        Elements.TypeText(RegisterPage.lastName,map.get("LastName"));
        Elements.TypeText(RegisterPage.emailAddress,map.get("Email"));
        Elements.TypeText(RegisterPage.phone,map.get("Telephone"));
        Elements.TypeText(RegisterPage.passwordField,map.get("Password"));
        Elements.TypeText(RegisterPage.passwordConfirm,map.get("Password"));

    }

}
