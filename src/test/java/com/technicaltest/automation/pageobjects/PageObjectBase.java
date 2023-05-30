package com.technicaltest.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectBase {
    protected WebDriver driver;

    public PageObjectBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
