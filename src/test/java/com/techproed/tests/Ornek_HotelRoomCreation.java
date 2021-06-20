package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelRoomCreation extends TestBase {

    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://fhctrip-qa.com/admin/HotelroomAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void test(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement idHotelDropdown = driver.findElement(By.id("IDHotel"));
        WebElement codeKutusu      = driver.findElement(By.id("Code")) ;
        WebElement nameKutusu      = driver.findElement(By.id("Name"));
        WebElement locationKutusu  = driver.findElement(By.id("Location"));
        WebElement descKutusu      = driver.findElement(By.xpath("(//textarea)[2]"));
        WebElement priceKutusu     = driver.findElement(By.id("Price"));
        WebElement fiyat500        = driver.findElement(By.xpath("//li[@data-id='500']"));
        WebElement roomDropdown    = driver.findElement(By.id("IDGroupRoomType"));
        WebElement adultCountKutusu= driver.findElement(By.id("MaxAdultCount"));
        WebElement childCountKutusu= driver.findElement(By.id("MaxChildCount"));
        WebElement saveButonu      = driver.findElement(By.id("btnSubmit"));

        Select hotelDropdown = new Select(idHotelDropdown);
        hotelDropdown.selectByIndex(2);

        codeKutusu.sendKeys("1234");
        nameKutusu.sendKeys("Yılmaz");
        locationKutusu.sendKeys("Selamlar");
        descKutusu.sendKeys("Bu oda review derslerinde oluşturulmuştur.");

        //dragAndDrop  -  Actions
        Actions actions = new Actions(driver);
        actions.dragAndDrop(fiyat500,priceKutusu).perform();

        Select odaDropdown = new Select(roomDropdown);
        odaDropdown.selectByIndex(3);

        adultCountKutusu.sendKeys("2");
        childCountKutusu.sendKeys("5");

        saveButonu.click();
    }
}
