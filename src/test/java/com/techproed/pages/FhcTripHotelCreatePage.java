package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelCreatePage {
    WebDriver driver;
    public FhcTripHotelCreatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy ( id = "Code")
    public WebElement codeKutusu;
    @FindBy ( id = "Name")
    public WebElement nameKutusu;
    @FindBy ( id = "Address")
    public WebElement adressKutusu;
    @FindBy ( id = "Phone")
    public WebElement phoneKutusu;
    @FindBy ( id = "Email")
    public WebElement emailKutusu;
    @FindBy ( id = "IDGroup")
    public WebElement idGroupDropDown;
    @FindBy ( id = "btnSubmit")
    public WebElement saveButonu;
    @FindBy ( className = "bootbox-body")
    public WebElement basariliYazisi;

}
