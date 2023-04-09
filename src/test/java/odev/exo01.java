package odev;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class exo01 extends TestBase {
    /*
https://the-internet.herokuapp.com/windows adresine gidin.
İlk sayfanın ID'sini(Window Handle değerini) alın.
Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
"Click Here" butonuna tıklayın.
Açılan pencereye geçin.
Açılan yeni pencerenin sayfa başlığının(title) "New Window" olduğunu doğrulayın.
Bir önceki pencereye dönüp sayfa başlığının "The Internet" olduğunu  doğrulayın.
2. pencereye tekrar geçin.
1. pencereye tekrar dönün.
*/
//https://the-internet.herokuapp.com/windows adresine gidin.
    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/windows ");


//İlk sayfanın ID'sini(Window Handle değerini) alın.
        System.out.println(driver.getWindowHandle());

//Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String text=driver.findElement(By.xpath("//h3")).getText();
        assertEquals("Opening a new window" , text);
        bekle(1);
//Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String baslik= driver.getTitle();
        assertEquals("The Internet" ,baslik);
        bekle(1);
//"Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        String yeniPencere=driver.getWindowHandle();
        bekle(1);
//Açılan pencereye geçin.
        switchToWindow(1);
        bekle(1);
//Açılan yeni pencerenin sayfa başlığının(title) "New Window" olduğunu doğrulayın.
        String actuelbaslik=driver.getTitle();
        assertEquals("New Window" , actuelbaslik);
        bekle(1);
//Bir önceki pencereye dönüp sayfa başlığının "The Internet" olduğunu  doğrulayın.
        switchToWindow(0);
        bekle(1);
//2. pencereye tekrar geçin.
        switchToWindow(1);
        bekle(1);
//1. pencereye tekrar dönün.
        switchToWindow(0);

    }}