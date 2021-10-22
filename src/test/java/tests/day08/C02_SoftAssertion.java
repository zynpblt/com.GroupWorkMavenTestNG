package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {
    // //amazon sayfasina gidin
    //
    //
    //
    //    //testleri soft assertion ile yapin
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void testamazon(){
        driver.get("https://www.amazon.com");
        //url in amazon icerdigini test edin  soft assertle
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"),"url amazon icermiyor");


        //title in amazon icerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"title amazon icermiyor");
        System.out.println(driver.getTitle());

        //java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
        WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("java"+ Keys.ENTER);

        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));

        softAssert.assertTrue(ilkUrun.getText().contains("Java"),"ilk urun java icermiyor");

        softAssert.assertAll();
    }









    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
