package tests.smokeTest;

import javafx.scene.layout.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class negativeTest {
    // 1) smokeTest  paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    //				- yanlisSifre
    //				- yanlisKulllanici
    //				- yanlisSifreKullanici
    //test data yanlis username: manager1 , yanlis password : manager1!
    //2) https://qa-environment.concorthotel.com/ adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et
    QAConcortPage qaConcortPage;

    @Test(priority = -1)
    public void yanlisSifre(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        qaConcortPage=new QAConcortPage();
        qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAValidUserName"));
        qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAInValidPassword"));
        qaConcortPage.LoginButton.click();
        Assert.assertTrue(qaConcortPage.LoginFailedText.isDisplayed());

    }
    @Test(dependsOnMethods = "yanlisSifre ")
    public void yanlisKullanici(){
        qaConcortPage=new QAConcortPage();
        qaConcortPage.userNameButton.clear();
        qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAInValidUserName"));
        qaConcortPage.passwordButton.clear();
        qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.LoginButton.click();
        Assert.assertTrue(qaConcortPage.LoginFailedText.isDisplayed());
    }
    @Test(dependsOnMethods = "yanlisSifre ")
    public void yanlisSifreKullanici(){
        qaConcortPage=new QAConcortPage();
        qaConcortPage.userNameButton.clear();
        qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAInValidUserName"));
        qaConcortPage.passwordButton.clear();
        qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAInValidPassword"));
        qaConcortPage.LoginButton.click();
        Assert.assertTrue(qaConcortPage.LoginFailedText.isDisplayed());
        Driver.closeDriver();
    }

}
