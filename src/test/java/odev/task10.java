package odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class task10 extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

    @Test
    public void test(){

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        //Sayfanın resmini alalım
        tumSayfaResmi();

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("(//h2)[8]"));
        clickByJS(browser);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("//button [@class='btn btn-dark btn-lg btn-block rounded-0 text-left']")).click();
        driver.findElement(By.xpath("//a[@href='https://chromedriver.chromium.org/']")).click();////a[@href='/112.0.5615.49/chromedriver_win32.zip']

        //Documentation webelementinin resmini alalım
     WebElement documentation = driver.findElement(By.id("yDmH0d"));
     webElementResmi(documentation);



        driver.findElement(By.xpath("//span[text()='ChromeDriver 112.0.5615.49']")).click();

        switchToWindow(1);

        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("//a[@href='/112.0.5615.49/chromedriver_win32.zip']")).click();

        //Driver'in indiğini doğrulayalım

       String userHome = System.getProperty("user.home");
        boolean isExist = Files.exists(Paths.get(userHome + "/Downloads/chromedriver_win32.zip"));
        System.out.println("isExist = " + isExist);
        assertTrue(isExist);

        //İndirmiş olduğumuz dosyayı silelim

        File indirilen=new File(userHome + "/Downloads/chromedriver_win32.zip");
        indirilen.delete();

        //Silindiğini doğrulayalım
        assertFalse(Files.exists(Path.of(userHome + "/Downloads/chromedriver_win32.zip")));

        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)




        //Açılan pencerede chromedriver'i indirelim
        //Driver'in indiğini doğrulayalım
        //İndirmiş olduğumuz dosyayı silelim
        //Silindiğini doğrulayalım
        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

    }

}
