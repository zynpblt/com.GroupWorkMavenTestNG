package tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C02_Faker extends TestBase {
    //// "https://facebook.com"  Adresine gidin
    //driver.get("https://facebook.com");
    ////"create new account"  butonuna basin
    ////"firstName" giris kutusuna bir isim yazin
    ////"surname" giris kutusuna bir soyisim yazin
    ////"email" giris kutusuna bir email yazin
    ////"email" onay kutusuna emaili tekrar yazin
    ////Bir sifre girin
    ////Tarih icin gun secin
    ////Tarih icin ay secin
    ////Tarih icin yil secin
    ////Cinsiyeti secin
    ////Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    ////Sayfayi kapatin

    @Test
    public void test() throws InterruptedException {
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[text()='Allow All Cookies']")).click();
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        Actions actions=new Actions(driver);
        WebElement female= driver.findElement(By.xpath("//input[@value='1']"));
        List<WebElement> listOfGender= driver.findElements(By.xpath("//input[@name='sex']"));


        actions.click(firstName)
                .sendKeys(faker.funnyName().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,30)))
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1990,2021)))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .click(listOfGender.get(0))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        // Thread.sleep(5000);

         WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeSelected(listOfGender.get(0)));
        Assert.assertTrue(listOfGender.get(0).isSelected());
        Assert.assertFalse(listOfGender.get(1).isSelected());
        Assert.assertFalse(listOfGender.get(2).isSelected());
                actions.sendKeys(Keys.ENTER).perform();




    }
}
