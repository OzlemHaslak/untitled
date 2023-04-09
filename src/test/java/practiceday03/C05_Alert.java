package practiceday03;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_Alert extends TestBase {

    //http://demo.guru99.com/test/delete_customer.php adresine gidin
    //customer id kısmına 53920 yazın
    //submit butonuna tıklayın
    //cıkan alert mesajını yazdırın
    //alerti kabul edin
    //cıkan 2. alert mesajını yazdırın
    //cıkan 2. alerti kabul edin

    @Test
    public void name() {
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        //customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("53920");

        //submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //cıkan alert mesajını yazdırın
        System.out.println(driver.switchTo().alert().getText());

        //alerti kabul edin
        driver.switchTo().alert().accept();

        //cıkan 2. alert mesajını yazdırın
        System.out.println(driver.switchTo().alert().getText());

        //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();
    }
}
