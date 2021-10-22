package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {
// //1- Yeni bir class olusturalim: C03_MouseActions1
//    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
//    //3- Cizili alan uzerinde sag click yapalim
//    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
//    //   test edelim.
//    //5- Tamam diyerek alert’I kapatalim
//    //6- Elemental Selenium linkine tiklayalim
//    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(driver);
        WebElement clickKutusu=driver.findElement(By.id("hot-spot"));
        actions.contextClick(clickKutusu).perform();

       String actualAlertYazisi= driver.switchTo().alert().getText();
       String expectedAlertYazisi="You selected a context menu";
       Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi,"yazi istenildigi gibi degil");
       driver.switchTo().alert().accept();

      String ilkHandle= driver.getWindowHandle();

       driver.findElement(By.linkText("Elemental Selenium")).click();
       String ikinciHandle="";
       Set<String> tumHandles =driver.getWindowHandles();
        for (String each:tumHandles
             ) {
            if (!each.equals(ilkHandle)){
                ikinciHandle=each;
            }

        }
        driver.switchTo().window(ikinciHandle);
       WebElement elementalYazisi= driver.findElement(By.tagName("h1"));
       String actualElementalYazisi=elementalYazisi.getText();
       String expectedElementalYazisi="Elemental Selenium";
       Assert.assertEquals(actualElementalYazisi,expectedElementalYazisi,"elemental dogru degil");
    }
}
