package POM;


import Base.Elements;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;




public class TutorialRegisterPage {
    private WebDriver driver;
    public TutorialRegisterPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

//   @FindBy(css = "[name =firstname]")
//    public static WebElement firstName;
     public  By name = By.id("input-firstname");
    public   WebElement firstNameField = hooks.MyHooks.wait
            .until(ExpectedConditions.elementToBeClickable(name));
   public  By lastName= By.id("input-lastname");
    public  WebElement lastNameField =hooks.MyHooks.wait
            .until(ExpectedConditions.visibilityOfElementLocated(lastName));
  public  By email =By.id ("input-email");
    public  WebElement emailAddress=hooks.MyHooks.wait.
            until(ExpectedConditions.visibilityOfElementLocated(email))   ;
    public  By phoneNumb =By.id("input-telephone");
    public  WebElement phone = hooks.MyHooks.wait
            .until(ExpectedConditions.visibilityOfElementLocated(phoneNumb));
    public  By passwordPlace =By.id  ("input-password");
    public  WebElement passwordField=hooks.MyHooks.wait
            .until(ExpectedConditions.visibilityOfElementLocated(passwordPlace));
   public  By passConfirm = By.id("input-confirm");
    public  WebElement passwordConfirm =hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(passConfirm));
    public  By agreement =By.name("agree");
    public  WebElement agree= hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(agreement));
    public  By subMit = By.xpath("//input[@type ='submit']");
    public  WebElement submitBtn =hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(subMit));
    public  By first = By.cssSelector("input[id ='input-firstname']+div");///--------------??????
 //   public static WebElement firstNameWarning=wait.until(ExpectedConditions.visibilityOfElementLocated(first));
    By lastN = By.cssSelector("input[id ='input-lastname']+div");
    public  WebElement lastNameWarning= hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(lastN));
    By emailWarn = By.cssSelector("input[id ='input-email']+div");
    public WebElement emailWarning= hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(emailWarn));
    By phoneWarn = By.cssSelector("input[id ='input-telephone']+div");
    public  WebElement phoneWarning = hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(phoneWarn));
      By passwordWarn = By.cssSelector("input[id ='input-password']+div");
    public  WebElement passwordWarning=hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(passwordWarn));

    public By warn = By.cssSelector(".alert");
      public  WebElement mainWarning = hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(warn));
      public  By subscrBtn = By.cssSelector("label:nth-child(1)>[name='newsletter']");
      public  WebElement subscriptionBtn = hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(subscrBtn));

      public static   By registerBreadCrumb = By.linkText("Register");
    public  void enterAllDetails(DataTable dataTable,String credentialsType){
        Map<String,String> map =dataTable.asMap(String.class,String.class);

        Elements.TypeText(firstNameField,map.get("FirstName"));
        Elements.TypeText(lastNameField,map.get("LastName"));
        Elements.TypeText(phone,map.get("Telephone"));
        Elements.TypeText(passwordField,map.get("Password"));
        Elements.TypeText(passwordConfirm,map.get("Password"));
        if(credentialsType.equalsIgnoreCase("duplicate")){
            Elements.TypeText(emailAddress,map.get("Email"));
    }else {

            Elements.TypeText(emailAddress,System.currentTimeMillis()+map.get("Email"));
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
