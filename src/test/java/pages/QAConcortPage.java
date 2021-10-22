package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class QAConcortPage {
    WebDriver driver;
   public QAConcortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText="Log in")
    public WebElement FirstLoginButton;

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

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLink;

    @FindBy(partialLinkText = "Hotel List")
    public  WebElement hotelListLink;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public  WebElement addHotel;

    @FindBy(id = "Code")
    public  WebElement addHotelCodeKutusu;

    @FindBy(id = "IDGroup")
    public WebElement IdGroupButton;




    public void ConcortHotelogin(){
     Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
     QAConcortPage qaConcortPage=new QAConcortPage();
     qaConcortPage.FirstLoginButton.click();
     qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAValidUserName"));
     qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
     qaConcortPage.LoginButton.click();
    }
}
