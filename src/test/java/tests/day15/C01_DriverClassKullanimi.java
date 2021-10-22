package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("FacebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

        Driver.closeDriver();
    }
}
