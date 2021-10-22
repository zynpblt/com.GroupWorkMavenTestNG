package tests.day14POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_ConcortHotelLoginNegative extends TestBase {
        @Test
        public void CHNegativeTest(){
                //Bir test method olustur NegativeLoginTest()
                // https://www.concorthotel.com/ adresine git
                driver.get("https://www.concorthotel.com/");
                ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
                // login butonuna bas
                concortHotelPage.FirstLoginButton.click();
                // test data username: manager1 ,
                concortHotelPage.userNameButton.sendKeys("manager1");
                // test data password : manager1!
                concortHotelPage.passwordButton.sendKeys("manager1!");
                concortHotelPage.LoginButton.click();
                // Degerleri girildiginde sayfaya girilemedigini test et
                Assert.assertTrue(concortHotelPage.LoginFailedText.isDisplayed());

        }


}
