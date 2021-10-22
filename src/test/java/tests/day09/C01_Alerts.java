package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01_Alerts {
    ////● Bir class olusturun: C01_Alerts
    //    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //    //● Bir metod olusturun: acceptAlert
    //    //		○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //    //		“You successfully clicked an alert” oldugunu test edin.
    //    //● Bir metod olusturun: dismissAlert
    //    //		○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
    //    //		ve result mesajının“successfuly” icermedigini test edin.
    //    //● Bir metod olusturun: sendKeysAlert
    //    //		○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //    //		OK butonuna 	tıklayın ve result mesajında isminizin
    //    //		görüntülendiğini doğrulayın.
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
        //		○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //    //		“You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement resultYazisiElemeneti= driver.findElement(By.id("result"));
        String expectedResultYazisi="You successfully clicked an alert";
        String actualResultYazisi=resultYazisiElemeneti.getText();
        Assert.assertEquals(actualResultYazisi,expectedResultYazisi,"resultyazisi dogru degil");

    }
    @Test
    public void  dismissAlert(){
        //		○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
        //    //		ve result mesajının“successfuly” icermedigini test edin.
       driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
       driver.switchTo().alert().dismiss();
        WebElement resultYazisiElemeneti= driver.findElement(By.id("result"));
        String istenmeyenKelime="successfuly";
        String actualKelime=resultYazisiElemeneti.getText();
        Assert.assertFalse(actualKelime.contains(istenmeyenKelime),"result yazisi istenmeyen kelime iceriyor");

    }

    @Test
    public void sendKeyseAlert(){
        //		○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        //    //		OK butonuna 	tıklayın ve result mesajında isminizin
        //    //		görüntülendiğini doğrulayın.
        String isim="Zeynep";
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys(isim);
        driver.switchTo().alert().accept();

        WebElement resultYazisiElemeneti= driver.findElement(By.id("result"));
        String ActualName=resultYazisiElemeneti.getText();

        SoftAssert softAssert=new SoftAssert();

       softAssert.assertTrue(ActualName.contains(isim),"isim ayni degil");

        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){

        driver.close();
    }
}

