package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MentorOdev extends TestBase {
    @Test
    public void test() throws InterruptedException {

        //    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        //    ~ click on Phones & PDAs
        driver.findElement(By.linkText("Phones & PDAs")).click();
        //    ~ get the brandName of phones
        List<WebElement> brandnameList= driver.findElements(By.xpath("//h4"));
        List<String> brandnameStringList=new ArrayList<>();
        for (WebElement element:brandnameList) {
            System.out.println(element.getText());
            brandnameStringList.add(element.getText());
        }
        Collections.sort(brandnameStringList);
        //    ~ click on add to button for all elements
        List<WebElement> addChartList= driver.findElements(By.xpath("//*[text()='Add to Cart']"));
        for (WebElement element:addChartList) {
            element.click();
            //Thread.sleep(3000);
        }
        //    ~ click on black total added cart button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-loading-text='Loading...']")).click();
        //    ~ get the names of list from the cart
        List<WebElement> addedChartNames= driver.findElements(By.xpath("//td[@class='text-left']"));
        List<String> ChartStringList=new ArrayList<>();

        for (WebElement element:addedChartNames) {
            System.out.println(element.getText());
            ChartStringList.add(element.getText());
        }
        Collections.sort(ChartStringList);
        //    ~ compare the names from displaying list and cart list
        SoftAssert softAssert=new SoftAssert();

        for (int i=0; i<addChartList.size();i++){
           softAssert.assertEquals(brandnameStringList.get(i),ChartStringList.get(i));
        }
        softAssert.assertAll();

    }


}
