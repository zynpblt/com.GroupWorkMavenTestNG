package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
     static Properties properties;

     static {
         String dosyaYolu="Configuration.properties";

         FileInputStream fileInputStream= null;
         try {
             fileInputStream = new FileInputStream(dosyaYolu);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         properties=new Properties();
         try {
             properties.load(fileInputStream);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     public static String getProperty(String key){
         String value=properties.getProperty(key);
         return value;
     }

}
