package practiceday03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın

    WebDriver driver;

    @Before
    public void before() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void after() throws Exception {
   //     driver.close();
    }

    @Test
    public void test() throws Exception {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");

        // dropdown'dan "Baby" secenegini secin
       WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(ddm);
        Thread.sleep(1000);
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
       String sectigimOption = select.getFirstSelectedOption().getText();
        System.out.println("sectigimOption = " + sectigimOption);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

        List<WebElement> optionList = select.getOptions();

        int expectedOptionSayisi = 28 ;

        Thread.sleep(1000);

        int actualOptionSayisi = optionList.size();

        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);

        // dropdown'daki optionların tamamını yazdırın

        optionList.forEach(t-> System.out.println(t.getText()));


    }


}
