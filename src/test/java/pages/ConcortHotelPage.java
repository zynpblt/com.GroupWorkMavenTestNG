package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestBase;

public class ConcortHotelPage {
    WebDriver driver;
  public ConcortHotelPage(WebDriver driver){
   this.driver=driver;
      PageFactory.initElements(driver,this);
 }
   @FindBy(linkText="Log in")
   public  WebElement FirstLoginButton;

  @FindBy(id = "UserName")
    public WebElement userNameButton;

  @FindBy(id = "Password")
    public WebElement passwordButton;

  @FindBy(id = "btnSubmit")
    public WebElement LoginButton;

  @FindBy(xpath = "//span[text()='ListOfUsers']")
    public  WebElement ListOfUsersText;

  @FindBy(xpath = "//span[text()='Try again please']")
    public WebElement LoginFailedText;



}
