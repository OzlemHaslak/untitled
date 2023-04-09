package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class task02 {
    /**** Aşağıdaki Task'i Junit framework'u ile yapınız
     - http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
     - Add Element butonuna 100 defa basınız
     - 100 defa basıldığını test ediniz
     - 90 defa delete butonuna basınız
     - 90 defa basıldığını doğrulayınız
     - Sayfayı kapatınız
*/
    static WebDriver driver;

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
   @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01(){

//    - http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
//     - Add Element butonuna 100 defa basınız
        driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]")).click();
        int count= 0 ;
        for (int i = 0; i < 100; i++) {
            driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]")).click();
            count ++;
        }

//     - 100 defa basıldığını test ediniz
        if( count==100){
            System.out.println("100 defa basıldi");
        }else
            System.out.println("100 defa basilmadi");

//     - 90 defa delete butonuna basınız

        driver.findElement(By.xpath("(//button[@class='added-manually'])[1]")).click();
        int count2= 0 ;
        for (int i = 0; i < 90; i++){
            driver.findElement(By.xpath("(//button[@class='added-manually'])[1]")).click();
            count2++;
        }

//     - 90 defa basıldığını doğrulayınız
        if(count2==90){
            System.out.println("90 kere basildi");
        }else
            System.out.println("90 kere basilmadi");

     }}
