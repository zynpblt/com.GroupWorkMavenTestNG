package tests.day14POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C04_AmazonConfigReaderPositifTest extends TestBase {
    @Test
    public void testAmazon(){
        // amazon sayfasina gidip
        driver.get(ConfigReader.getProperty("AmazonUrl"));
        //// nutella icin arama yapin
        AmazonPage amazonPage=new AmazonPage(driver);
        amazonPage.searchBox.sendKeys(ConfigReader.getProperty("AmazonArananKelime")+Keys.ENTER);

        //// sonuc sayisini yazdirin ve sonuc yazisinin nutella icerdigini test edin
        System.out.println(amazonPage.AramaSonucYazisi.getText());
        Assert.assertTrue(amazonPage.AramaSonucYazisi.getText().contains(ConfigReader.getProperty("AmazonArananKelime")));

    }
}
