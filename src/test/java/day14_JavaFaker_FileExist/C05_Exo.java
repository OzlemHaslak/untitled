package day14_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class C05_Exo extends TestBase {

    /*
https://the-internet.herokuapp.com/upload adresine gidelim
chooseFile butonuna basalim
Yuklemek istediginiz dosyayi secelim.
Upload butonuna basalim.
"File Uploaded!" textinin goruntulendigini test edelim.

     */

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement uploadButton = driver.findElement(By.id("file-upload"));
        bekle(3);
        uploadButton.sendKeys("C:/Users/Asus/Desktop/logo.jpeg");
        bekle(3);
        driver.findElement(By.id("file-submit")).click();
        bekle(3);
        WebElement sonuc = driver.findElement(By.xpath("//h3"));
        bekle(3);
        assertTrue(sonuc.isDisplayed());
    }

    }







