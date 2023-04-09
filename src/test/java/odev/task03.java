package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class task03 {

    //-BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
//-Before methodunda http://www.google.com adresine gidin
//-Üç farklı test methodu ile;
//-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
//-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
//-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
//-AfterClass ile kapatın

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws InterruptedException {
        driver.get("http://www.google.com");
        Thread.sleep(1000);

    }

    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//div [@class='QS5gu sy4vM']")).click();
        Thread.sleep(1000);
      WebElement aramaKutusu =  driver.findElement(By.xpath("//input[@class='gLFyf']"));
      Thread.sleep(1000);
      aramaKutusu.sendKeys("The God Father",Keys.ENTER);
      Thread.sleep(1000);
      //aramaKutusu.submit();

    //  WebElement sonuc = driver.findElement(By.xpath("//div [@id='result-stats']"));
      //  System.out.println("sonuc the god father " + sonuc.getText().split(" ")[1]);

    }
    //-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin

    @Test
    public void test02() throws InterruptedException {
        WebElement aramaKutus01 = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutus01.sendKeys("Lord of the Rings",Keys.ENTER);
        Thread.sleep(1000);
       // aramaKutus01.submit();

       // WebElement sonuc01= driver.findElement(By.xpath("//div[@id='result-stats']"));
       // System.out.println("sonuc lord of the rings " +sonuc01.getText().split(" ")[1]);//239.000.000

    }
    @Test
    public void test03(){
        //-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutus02= driver.findElement(By.xpath("//input [@class='gLFyf'] "));
        aramaKutus02.sendKeys("Kill Bill",Keys.ENTER);
       // aramaKutus02.submit();

//WebElement sonuc03= driver.findElement(By.xpath("//div [@id='result-stats']"));
  //      System.out.println("sonuc kill bill " + sonuc03.getText().split(" ")[1]);

    }

    @After
    public void after() {
        WebElement sonuc = driver.findElement(By.xpath("//div [@id='result-stats']"));
        System.out.println(sonuc.getText().split(" ")[1]);

//        @After
//        public void tearDown() {
//            String [] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
//            System.out.println("Arama Sonuc Sayısı = "+sonuc[1]);
    }

    @AfterClass
    public static void close() {
        driver.close();
    }

}
