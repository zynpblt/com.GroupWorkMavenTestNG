package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions3 extends TestBase {
    ////Yeni bir class olusturalim: C05_MouseActions3
    //    //1- https://www.amazon.com/ adresine gidelim
    //    //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
    //    //3- “Create a list” butonuna basalim
    //    //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountYazi=driver.findElement(By.xpath("//span[.='Hello, Sign in']"));
        actions.moveToElement(accountYazi).perform();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//span[.='Create a List']")).click();
//        WebElement noThanks= driver.findElement(By.xpath("//span[text()='No, thanks']"));
//        WebDriverWait wait=new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.elementToBeClickable(noThanks));
//        noThanks.click();
        String expectedText="Your Lists";
        String actualText=driver.findElement(By.xpath("//div[@role='heading']")).getText();
        Assert.assertEquals(actualText,expectedText,"Your list text not as expected");




    }
}
