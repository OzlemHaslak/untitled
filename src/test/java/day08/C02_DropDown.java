package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

@After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void selectByIndex() throws InterruptedException {
        //1.Locate DropDown Element
        WebElement year = driver.findElement(By.id("year"));

        //2. Select objesi olustur
        Select yearDropDown = new Select(year);

        //3. Select objesini kullanarak 3 farkli sekilde secim yapabiliriz
        yearDropDown.selectByIndex(22); // secenek 0 dan baslar. 2001 yili 22. sirada

        //4. Select ay secimi
        Thread.sleep(3000);
        WebElement month = driver.findElement(By.id("month"));
        Select monthDropDown = new Select(month);
        monthDropDown.selectByVisibleText("June");

        //Gun secimi
        Thread.sleep(3000);
        WebElement day = driver.findElement(By.id("day"));
        Select dayDropDown = new Select(day);
        dayDropDown.selectByValue("28");
        Thread.sleep(3000);

    }

    @Test
    public void printAll(){
        WebElement state = driver.findElement(By.id("state"));
        Select stateDropDown = new Select(state);
        List<WebElement> stateList = stateDropDown.getOptions();

      /*  for (WebElement w : stateList){
            System.out.println(w.getText());


        }*/

        //Tavsiye edilen
        stateList.forEach(t->System.out.println(t.getText()));


    }
}
