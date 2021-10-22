package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {
    ////1. Bir class olusturun : C01_WaitTest
    //    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //    //  Iki metod icin de asagidaki adimlari test edin.
    //    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //    //4. Remove butonuna basin.
    //    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //    //6. Add buttonuna basin
    //    //7. It’s back mesajinin gorundugunu test edin
    @Test
    public void explicitlyWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait wait=new WebDriverWait(driver,30);
        WebElement itsgone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assert.assertTrue(itsgone.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        WebElement itsback= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assert.assertTrue(itsback.isDisplayed());
    }
}


