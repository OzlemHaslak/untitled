package practiceday04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    @Test
    public void test(){

    // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

    // Videoyu görecek kadar asagiya ininiz
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(1);

    // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));

        driver.switchTo().frame(iframe);

        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();

        /* play i dogru locate edip click yapmamiza ragmen videoyu calistirmadi
        bunun uzerine HTML kodlarini inceleyince
        play'in aslinda bir iframe icerisinde oldugunu gorduk
        bu durumda once iframe'i locate edip switchTo() ile o iframe e gectik
         */
bekle(1);

    // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
       // WebElement youtubeyazisi= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());
        bekle(1);

    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
       WebElement powerfulYazisi = driver.findElement(By.id("Powerful_but_easy_to_misuse"));
        Assert.assertTrue(powerfulYazisi.isDisplayed());



}}
