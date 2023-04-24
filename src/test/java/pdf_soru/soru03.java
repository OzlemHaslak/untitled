package pdf_soru;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class soru03 extends TestBase {
/*
    @Test
    public void test() {

//    1- https://the-internet.herokuapp.com/add_remove_elements/ adresine
    driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

//    2- Add Element butonuna basin
driver.findElement(By.xpath("//button[@onclick='addElement()']"));

//3. Delete butonu’nun gorunur oldugunu test edin
       // WebElement buton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        WebElement buttonDelete = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        buttonDelete.isDisplayed();
//4. Delete tusuna basin
        driver.findElement(By.xpath("//button[@class='added-manually']")).click();

//5. “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        System.out.println("control " + driver.findElement(By.xpath("//h3")).isDisplayed());

    }*/
@Test
public void test01() throws InterruptedException {
    driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
    driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
    Thread.sleep(2000);
    WebElement buttonDelete = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
    System.out.println("Delete Butonu Gorunur mu?: "+buttonDelete.isDisplayed());
    driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
    System.out.println("Add/Remove Elements yazisi gorunur mu? "+driver.findElement(By.xpath("//h3")).isDisplayed());

}

}
