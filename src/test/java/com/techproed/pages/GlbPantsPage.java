package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbPantsPage {
    public GlbPantsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy ( xpath = "//p[@class='cat_bg_top']")
    public List<WebElement> basliklar;

}
