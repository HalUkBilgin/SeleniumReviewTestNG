package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase{

    /*
        1. Adım : the-internet.herokuapp.com/windows bu sayfaya gittiğimizde,
                  sayfanın WindowHandle'ını alalım.
        2. Adım : Click Here linkine tıklayalım.

        3. Adım : Gittiğimiz sayfadan, the-internet.herokuapp.com/windows sayfasına
                  window handle'ını kullanarak geçiş yapalım.

     */

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");

        String anaSayfaWindowHandle = driver.getWindowHandle();
        System.out.println(anaSayfaWindowHandle);

        //<a href="/windows/new" ,="" target="_blank">Click Here</a>
        // tagName , xpath, cssSelector , linkText, partialLinkText

        /*WebElement clickHereLinki = driver.findElement(By.partialLinkText("Click Here"));
        clickHereLinki.click();*/

        driver.findElement(By.partialLinkText("Click Here")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // windowhandle kullanarak istediğimiz pencereye şu şekilde geçiş yapabiliyoruz
        driver.switchTo().window(anaSayfaWindowHandle);

        String ikinciSayfaWindowHandle = "";
        // Açık olan tüm pencerelerin window handle'larını almak
        Set<String> tumWindowHandlelar = driver.getWindowHandles();
        // anaSayfaWindowHandle = CDwindow-25B4E1CCF6F29CFBA218A015249EBAEF

        /*
            CDwindow-25B4E1CCF6F29CFBA218A015249EBAEF (Ana Sayfa)
            CDwindow-F89A145C64173B55E2F13576AA1E976A (İkinci Sayfa)
         */
        for (String handle : tumWindowHandlelar){
            if(!handle.equals(anaSayfaWindowHandle)){
                ikinciSayfaWindowHandle = handle;
            }

            System.out.println(handle);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().window(ikinciSayfaWindowHandle);

        ///////////////// Set<String> i Array'e çevirme /////////////////
        Object[] windowHandleDegerleri = tumWindowHandlelar.toArray();
        System.out.println(windowHandleDegerleri[0].toString());
        System.out.println(windowHandleDegerleri[1].toString());


    }

}
