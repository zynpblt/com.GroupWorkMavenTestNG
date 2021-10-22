package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test(){
        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        //nutella icin arama yap
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        //9.urune bas
        driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[15]")).click();
    }



}
