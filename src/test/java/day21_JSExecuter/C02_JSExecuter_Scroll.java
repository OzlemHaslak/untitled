package day21_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Scroll extends TestBase {

    /*
    Techpro education ana sayfasına git
    "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
     */

    @Test
    public void jSExecuterScrollTest(){
//        Techpro education ana sayfasına git
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

//        "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));

        bekle(3);

        scrollIntoView(weOffer);//scrollIntoView() ==> TestBase classındaki method
        tumSayfaResmi();
        bekle(3);

//        Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
        scrollIntoView(enrollFree);
        bekle(1);

//        Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//h3[.='WHY US?']"));
        scrollIntoView(whyUs);
        tumSayfaResmi();
        bekle(3);

//        Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        scrollIntoView(enrollFree);
        tumSayfaResmi();
        bekle(3);

        //Sayfayı en alta kaydır:
        scrollEndJS();
        bekle(3);

        //Sayfayı en üste kaydır:
        scrollTopJS();

    }

    @Test
    public void test(){
        JavascriptExecutor js;

        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        bekle(2);
        /*
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
         */
        scroll(weOffer);
        bekle(2);
        tumSayfaResmi();
        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        /*
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
         */
        scroll(enrollFree);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs=driver.findElement(By.xpath("//*[text()='WHY US?']"));
        scroll(whyUs);

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    }
}
