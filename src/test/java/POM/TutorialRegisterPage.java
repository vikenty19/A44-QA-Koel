package POM;

import Base.Elements;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class TutorialRegisterPage {
    public TutorialRegisterPage() {
        PageFactory.initElements(driver, this);
    }

//   @FindBy(css = "[name =firstname]")
//    public static WebElement firstName;
     public static By name = By.id("input-firstname");
    public static WebElement firstNameField = wait
            .until(ExpectedConditions.elementToBeClickable(name));
   public static By lastName= By.id("input-lastname");
    public static WebElement lastNameField =wait
            .until(ExpectedConditions.visibilityOfElementLocated(lastName));
  public static By email =By.id ("input-email");
    public static WebElement emailAddress=wait.
            until(ExpectedConditions.visibilityOfElementLocated(email))   ;
    public static By phoneNumb =By.id("input-telephone");
    public static WebElement phone = wait
            .until(ExpectedConditions.visibilityOfElementLocated(phoneNumb));
    public static By passwordPlace =By.id  ("input-password");
    public static WebElement passwordField=wait
            .until(ExpectedConditions.visibilityOfElementLocated(passwordPlace));
   public static By passConfirm = By.id("input-confirm");
    public static WebElement passwordConfirm =wait.until(ExpectedConditions.visibilityOfElementLocated(passConfirm));
    public static By agreement =By.name("agree");
    public static WebElement agree= wait.until(ExpectedConditions.visibilityOfElementLocated(agreement));
    public static By subMit = By.xpath("//input[@type ='submit']");
    public static WebElement submitBtn =wait.until(ExpectedConditions.visibilityOfElementLocated(subMit));
    public static By first = By.cssSelector("input[id ='input-firstname']+div");///--------------??????
 //   public static WebElement firstNameWarning=wait.until(ExpectedConditions.visibilityOfElementLocated(first));
    @FindBy(css = "input[id ='input-lastname']+div")
    public static WebElement lastNameWarning;
    @FindBy(css = "input[id ='input-email']+div")
    public static WebElement emailWarning;
    @FindBy(css = "input[id ='input-telephone']+div")
    public static WebElement phoneWarning;
      @FindBy(css = "input[id ='input-password']+div")
    public static WebElement passwordWarning;

    public static By warn = By.cssSelector(".alert");
      public static WebElement mainWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(warn));
      public static By subscrBtn = By.cssSelector("label:nth-child(1)>[name='newsletter']");
      public static WebElement subscriptionBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(subscrBtn));

      public static   By registerBreadCrumb = By.linkText("Register");
    public static void enterAllDetails(DataTable dataTable,String credentialsType){
        Map<String,String> map =dataTable.asMap(String.class,String.class);

        Elements.TypeText(firstNameField,map.get("FirstName"));
        Elements.TypeText(lastNameField,map.get("LastName"));
        Elements.TypeText(phone,map.get("Telephone"));
        Elements.TypeText(passwordField,map.get("Password"));
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
