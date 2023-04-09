package practiceday03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;

public class C01_DropDown  {

  WebDriver driver;

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin

   @Before
    public void setUp() throws Exception {

       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   }
   @After
    public void tearDown() throws Exception {
       driver.close();
   }

   @Test
    public void test01() throws Exception {

       driver.get("https://www.amazon.com");

       WebElement ddm = driver.findElement(By.id("searchDropdownBox"));

       Select select = new Select(ddm);

       select.selectByVisibleText("Books");

       Thread.sleep(1000);

       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

       WebElement aramaSonucElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'] )[1]"));

       String aramaSonucYaszisi = aramaSonucElementi.getText();

       Thread.sleep(1000);

       Assert.assertTrue(aramaSonucYaszisi.contains("Java"));


   }



    }


