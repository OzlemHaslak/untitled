package pdf_soru;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class soru01 extends TestBase {
 /*

a. http://a.testaddressbook.com adresine gidiniz.
b.  log in butonuna basin
c. email textbox,password textbox, and  log in button elementlerini locate ediniz..
d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (log in)buttonunu tıklayın:
i. Username : testtechproed@gmail.com
ii. Password : Test1234!
e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
f. "Addresses" ve "Sign Out" textlerinin görüntülendiğini( displayed) doğrulayin(verify).
3. Sayfada kac tane link oldugunu bulun.
     */

    @Test
    public void Test01() {

        driver.get("http://a.testaddressbook.com");
        driver.switchTo().frame(0);
        driver.findElement(By.linkText("Build something amazing")).click();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("email")).sendKeys("testtechproed@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test1234!");

       // Assert.assertEquals("testtechproed@gmail.com", driver.findElement(By.id("email")).sendKeys("testtechproed@gmail.com"));




    }
}
