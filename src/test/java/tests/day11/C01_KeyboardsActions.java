package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardsActions extends TestBase {
    ////1- Bir Class olusturalim C01_KeyboardActions1
    //    //2- https://www.amazon.com sayfasina gidelim
    //    //3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //    //4- aramanin gerceklestigini test edin
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.click(aramaKutusu)
                .sendKeys("samsung")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71").perform();
                actions.sendKeys(Keys.ENTER).perform();

                String arananKelime="samsungA71";
                String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));
    }
}
