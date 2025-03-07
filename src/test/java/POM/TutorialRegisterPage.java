package POM;

import Base.Elements;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static StepDefinitions.TutorialsLoginOnly.driver;

public class TutorialRegisterPage {
    public TutorialRegisterPage() {
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
    @FindBy(css = "input[id ='input-firstname']+div")
    public static WebElement firstNameWarning;
    @FindBy(css = "input[id ='input-lastname']+div")
    public static WebElement lastNameWarning;
    @FindBy(css = "input[id ='input-email']+div")
    public static WebElement emailWarning;
    @FindBy(css = "input[id ='input-telephone']+div")
    public static WebElement phoneWarning;
      @FindBy(css = "input[id ='input-password']+div")
    public static WebElement passwordWarning;

      @FindBy(css = ".alert")
      public static WebElement mainWarning;
      @FindBy(css = "label:nth-child(1)>[name='newsletter']")
      public static WebElement subscriptionBtn;

      public static   By registerBreadCrumb = By.linkText("Register");
    public static void enterAllDetails(DataTable dataTable,String credentialsType){
        Map<String,String> map =dataTable.asMap(String.class,String.class);
        Elements.TypeText(TutorialRegisterPage.firstName,map.get("FirstName"));
        Elements.TypeText(TutorialRegisterPage.lastName,map.get("LastName"));
        Elements.TypeText(TutorialRegisterPage.phone,map.get("Telephone"));
        Elements.TypeText(TutorialRegisterPage.passwordField,map.get("Password"));
        Elements.TypeText(TutorialRegisterPage.passwordConfirm,map.get("Password"));
        if(credentialsType.equalsIgnoreCase("duplicate")){
            Elements.TypeText(TutorialRegisterPage.emailAddress,map.get("Email"));
    }else {

            Elements.TypeText(TutorialRegisterPage.emailAddress,System.currentTimeMillis()+map.get("Email"));
        }
    }
  /*  public static void enterDuplicatedDetails(DataTable dataTable){
        Map<String,String> map =dataTable.asMap(String.class,String.class);
        Elements.TypeText(TutorialRegisterPage.firstName,map.get("FirstName"));
        Elements.TypeText(TutorialRegisterPage.lastName,map.get("LastName"));
        Elements.TypeText(TutorialRegisterPage.emailAddress,map.get("Email"));
        Elements.TypeText(TutorialRegisterPage.phone,map.get("Telephone"));
        Elements.TypeText(TutorialRegisterPage.passwordField,map.get("Password"));
        Elements.TypeText(TutorialRegisterPage.passwordConfirm,map.get("Password"));

    }*/

}
