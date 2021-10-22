package tests.day14POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_ConfigReaderPositifTest extends TestBase {
    @Test
    public void test(){
        ////1 ) Bir Class olustur : PositiveTest
        //        //2) Bir test method olustur positiveLoginTest()
        //        // https://www.concorthotel.com/ adresine git

        driver.get(ConfigReader.getProperty("CHUrl"));


        // login butonuna bas
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        concortHotelPage.FirstLoginButton.click();

        // test data username: manager ,
        concortHotelPage.userNameButton.sendKeys(ConfigReader.getProperty("CHValidUserName"));
        // test data password : Manager1!
        concortHotelPage.passwordButton.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.LoginButton.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.ListOfUsersText.isDisplayed());

    }

}
