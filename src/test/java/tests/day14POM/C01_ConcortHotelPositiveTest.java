package tests.day14POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelPositiveTest extends TestBase {
    @Test
    public void testPositive(){ //1 ) Bir Class olustur : PositiveTest
        //2) Bir test method olustur positiveLoginTest()
        // https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");
        // login butonuna bas
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        concortHotelPage.FirstLoginButton.click();
        // test data username: manager ,
        concortHotelPage.userNameButton.sendKeys("manager");
        // test data password : Manager1!
        concortHotelPage.passwordButton.sendKeys("Manager1!");
        concortHotelPage.LoginButton.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.ListOfUsersText.isDisplayed());
    }
}
