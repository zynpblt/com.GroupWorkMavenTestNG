package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class odev1 extends TestBase {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
    @Test
    public void test(){
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions=new Actions(driver);

        WebElement hoverOver1=driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        WebElement link1=driver.findElement(By.xpath("(//a[text()='Link 1'])[1]"));

        actions.moveToElement(hoverOver1).moveToElement(link1).click().perform();

        String alertMesaj=driver.switchTo().alert().getText();
        System.out.println(alertMesaj);
        driver.switchTo().alert().accept();

        WebElement clickandhold= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickandhold).perform();

        WebElement wellDoneYazisi=driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']"));
        System.out.println(wellDoneYazisi.getText());

        WebElement clickMe= driver.findElement(By.tagName("h2"));
        actions.doubleClick(clickMe).perform();



    }
}
