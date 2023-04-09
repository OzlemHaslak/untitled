package practiceday02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")).click();

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String googleTite = driver.getTitle();

        if(googleTite.contains("Google")){
            System.out.println("title google iceriyor");
        }else
            System.out.println("title google icermiyor");

        Thread.sleep(3000);

        // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella"+ Keys.ENTER);

        // bulunan sonuc sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));

        //  System.out.println(sonucYazisi.getText());

        String arr[] = sonucYazisi.getText().split(" ");

        String sonuc = arr[1];

        System.out.println(sonuc);

        // sonuc sayısının 100000000  fazla oldugunu test edin

        String sonucc = sonuc.replaceAll("\\D","");

        if(Integer.parseInt(sonucc)>100000000){
            System.out.println("Sonuc sayisi 100000000'dan fazla");
        }else{
            System.out.println("Sonuc sayisi 100000000'dan fazla degil");
        }

        // sayfayı kapatın
        driver.close();

    }
}