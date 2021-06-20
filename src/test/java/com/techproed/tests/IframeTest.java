package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    // https://the-internet.herokuapp.com/iframe
    // 1. Adım : Sayfadaki iframe'i bulacağız.
    // 2. Adım : O iframe'in içerisindeki "p" tag name'ine sahip webelementi bulacağız.
    // 3. Adım : İçerisine "Selamlar IFRAME" yazdıracağız.
    // 4. Adım : Iframe'den çıkış yapıp, sayfamıza döneceğiz (defaultContent)
    // 5. Adım : "Elemental Selenium" linkini bulup, tıklayacağız.

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

      /*
         <iframe id="mce_0_ifr" src="javascript:&quot;&quot;" allowtransparency="true"
         title="Rich Text Area. Press ALT-F9 for menu. Press ALT-F10 for toolbar. Press ALT-0 for help" style="width: 100%; height: 100px; display: block;"
         frameborder="0"></iframe>
      */

        // 1. index ile
        // driver.switchTo().frame(0);

        // 2. id attribute değeri ile
        // driver.switchTo().frame("mce_0_ifr");

        // 3. webelement ile
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);


        WebElement yaziBolumu = driver.findElement(By.tagName("p"));
        yaziBolumu.clear();
        yaziBolumu.sendKeys("Selamlar IFRAME");

        driver.switchTo().defaultContent();

        //<a target="_blank" href="http://elementalselenium.com/">Elemental Selenium</a>
        // tagName, linkText, partialLinkText, xpath, cssSelector

        WebElement link = driver.findElement(By.partialLinkText("Elemental Selenium"));
        link.click();


    }


}
