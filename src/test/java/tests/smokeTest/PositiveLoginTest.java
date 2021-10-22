package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {
    @Test
    public void test(){
        //Bir test method olustur positiveLoginTest()
        //https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        //login butonuna bas
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.FirstLoginButton.click();
        //test data username: manager ,
        qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHValidUserName"));
        //test data password : Manager1!
        qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        qaConcortPage.LoginButton.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(qaConcortPage.ListOfUsersText.isDisplayed());
        Driver.closeDriver();

    }
}
