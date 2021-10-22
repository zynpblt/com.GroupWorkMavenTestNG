package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class C02_E2ETest {
    @Test()
    public void test(){
        // 1. Tests packagenin altına class olusturun: D17_CreateHotel
        //2. Bir metod olusturun: createHotel
        //3. https://qa-environment.concorthotel.com/ adresine git.

        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
        //	a. Username : manager
        //	b. Password  : Manager1!
        //5. Login butonuna tıklayın.
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelogin();
        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        qaConcortPage.hotelManagementLink.click();
        qaConcortPage.hotelListLink.click();
        qaConcortPage.addHotel.click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        actions.
                click(qaConcortPage.addHotelCodeKutusu).
                                sendKeys(faker.address().zipCode()).
                                sendKeys(Keys.TAB).sendKeys(faker.name().name()).
                                sendKeys(Keys.TAB).
                                sendKeys(faker.address().fullAddress()).
                                 sendKeys(Keys.TAB).
                                 sendKeys(faker.phoneNumber().phoneNumber()).
                                 sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .perform();
        //Select select=new Select(Driver.getDriver());
        //8. Save butonuna tıklayın.
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        //10. OK butonuna tıklayın.
    }
}
