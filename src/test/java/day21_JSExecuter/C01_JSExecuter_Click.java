package day21_JSExecuter;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C01_JSExecuter_Click extends TestBase {

    /*
        Eğer bir web sayfasının HTML kodları tamamen yada kısmen JavaScript kullanılarak oluşturulduysa
     o sayfaya müdahale etmek için genellikle JavaScriptExecutor arayüzünü kullanmak gerekir.
        Bu durumda, sayfayı manipüle etmek veya etkileşimde bulunmak için standart WebDriver komutları
     yetersiz kalabilir. Bu nedenle JSExecutor arayüzü, sayfanın JS kodlarına doğrudan erişebilir.
        Ancak, mümkünse WebDriver'in sunduğu standart yöntemlerle sorunları çözmek her zaman daha iyidir.
     Çünkü JS kullanımı, sayfanın daha yavaş yüklenmesine neden olabili.
    */

    /*
    http://www.uitestpractice.com/Students/Form sayfasına git
    Formu doldur
    Submit tuşuna tıkla
    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
    */

    @Test
    public void clickByJSTest() {
//        http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");

//        Formu doldur
        driver.findElement(By.id("firstname")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());

//        Submit tuşuna tıkla
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        //submitButton.click(); ==> selenium calismadi javascript ile calistiracagiz

        //Driver'ı JavascriptExecutor classına "cast" ediyoruz:
//        JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;
//
//        //executeScript() metodu ile uygun script'i çalıştırıyoruz:
//        jsExecuter.executeScript("arguments[0].click();",submitButton);

        //clickByJS metodu oluşturarak gerekli yerlerde tıklama yapabiliriz:
        clickByJS(submitButton);//TestBase classındaki clickByJS() methodu

//        Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        assertEquals("http://www.uitestpractice.com/Students/Form?", driver.getCurrentUrl());

    }

    @Test
    public void test() {
        //http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form ");

        //Formu doldur
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,Keys.TAB,Keys.TAB,
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,faker.phoneNumber().cellPhone());
        bekle(1);

        //Submit tuşuna tıkla
        /*
        org.openqa.selenium.ElementClickInterceptedException: Eğer JS kodlarıyla bir web element oluşturulmuşsa
        normal click() methodunda bu exception'ı alırız
         */

        WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));
       /*
        try {
            submit.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",submit);
        }*/
        click(submit);

        //Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        Assert.assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on",driver.getCurrentUrl());
    }
}













