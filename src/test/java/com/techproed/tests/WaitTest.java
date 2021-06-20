package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {

    @Test
    public void implicitlyWaitTest(){
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // implicitly wait : Sayfadaki findElement işlemi gerçekleşirken,
        //                   belirlediğimiz maksimum süreye kadar bekliyor.
        //                   Öncesinde bulursa, bekleme işlemini bırakıp devam ediyor.
        //                   Örnek : Eğer 2. saniyede aranılan webelementi bulursa,
        //                           8 saniye daha BEKLEMİYOR. Direk alt satıra geçiyor.

        driver.get("http://google.com");

        //WebElement hamzaYilmazLink = driver.findElement(By.id("hamza_yilmaz"));
        WebElement aramaKutusu = driver.findElement(By.name("q"));

    }

    @Test
    public void explicitWaitTest(){
        // WebDriverWait class'ından nesne üretmek zorundayız !
        // implicitlyWait'ten en önemli farkı, burada herhangi bir webelement için
        // özel bir bekleme işlemi gerçekleştiriyoruz.

        // Explicit Wait içinde en önemli fark, burada bir koşul belirtiyoruz.
        // Örnek : Aradığımız WebElement tıklayabiliyor olsun.
        // Örnek : Aradığımız webelement'in yazısı "deneme" olsun.

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        //<button autocomplete="off" type="button" onclick="swapCheckbox()">Remove</button>
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

        // <p id="message">It's gone!</p>
        // Eğer explicit wait kullanmak istiyorsak, WebDriverWait'ten nesne üretmek zorundayız.
        WebDriverWait wait = new WebDriverWait(driver  ,  120);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message.getText());

    }




}
