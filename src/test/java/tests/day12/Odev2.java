package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Odev2 extends TestBase {
    //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    //2. “Our Products” butonuna basin
    //3. “Cameras product”i tiklayin
    //4. Popup mesajini yazdirin
    //5. “close” butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
    @Test
    public void test(){
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        driver.switchTo().frame(0);

        driver.findElement(By.linkText("Our Products")).click();
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();
        String Popup= driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(Popup);

        driver.findElement(By.xpath("//*[text()='Close']")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.partialLinkText(" (IFrame)")).click();
        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedUrl);

    }
}
