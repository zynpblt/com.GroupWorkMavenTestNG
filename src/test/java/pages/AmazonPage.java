package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
     WebDriver driver;
    public AmazonPage(WebDriver driver){
       this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public  WebElement AramaSonucYazisi;
}
