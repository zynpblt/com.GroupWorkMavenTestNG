package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_FileUpload extends TestBase {
    ////2.https://the-internet.herokuapp.com/upload adresine gidelim
    //3.chooseFile butonuna basalim
    //4.Yuklemek istediginiz dosyayi secelim.
    //5.Upload butonuna basalim
    //6.“File Uploaded!” textinin goruntulendigini test edelim.
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaYukle = driver.findElement(By.id("file-upload"));
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\picture.jpg";
        dosyaYukle.sendKeys(dosyaYolu);
        driver.findElement(By.id("file-submit")).click();
         WebElement sonucyazi=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(sonucyazi.isDisplayed());
    }
}
