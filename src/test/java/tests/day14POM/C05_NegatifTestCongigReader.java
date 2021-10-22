package tests.day14POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegatifTestCongigReader extends TestBase {
    @Test
    public void test(){
        //https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));
        // login butonuna bas
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        concortHotelPage.FirstLoginButton.click();
        // test data username: manager1 ,
        concortHotelPage.userNameButton.sendKeys(ConfigReader.getProperty("CHInValidUserName"));
        // test data password : manager1!
        concortHotelPage.passwordButton.sendKeys(ConfigReader.getProperty("CHInValidPassword"));
        concortHotelPage.LoginButton.click();

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHotelPage.LoginFailedText.isDisplayed());

    }
}
