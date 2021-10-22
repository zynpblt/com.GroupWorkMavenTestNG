package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class Odev3 extends TestBase {

    @Test
    public void test(){
        Actions actions=new Actions(driver);
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        WebElement loginPortal= driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        actions.moveToElement(loginPortal).perform();

        String ParentHandle=driver.getWindowHandle();
        //3."Login Portal" a tiklayin
        loginPortal.click();
        //4.Diger window'a gecin


        Set<String> allHandles= driver.getWindowHandles();
        for (String element:allHandles) {
            if (!element.equals(ParentHandle)){
                driver.switchTo().window(element);
            }
        }

        //5."username" ve "password" kutularina deger yazdirin
        WebElement userName= driver.findElement(By.id("text"));
        userName.sendKeys("Zeynep");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("125487");
        //6."login" butonuna basin
        WebElement logIn= driver.findElement(By.id("login-button"));
        logIn.click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualAllertText=driver.switchTo().alert().getText();
        String expectedAlertText="validation failed";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualAllertText,expectedAlertText,"Alert message is not as expected");


        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ParentHandle);
        //10.Ilk sayfaya donuldugunu test edin
        String expectedUrl="http://webdriveruniversity.com/";
        String actualUrl= driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Parent handle is not as expected");
        softAssert.assertAll();
    }
}
