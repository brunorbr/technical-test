package com.technicaltest.automation.pageobjects;

import com.technicaltest.automation.tests.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConvertedCurrencyPage extends PageObjectBase {
    @FindBy(xpath = "//p[contains(@class,'result__BigRate')]")
    private WebElement conversionResult;

    public ConvertedCurrencyPage(WebDriver driver){
        super(driver);
    }

    public String getConversionResult(){
        return conversionResult.getText();
    }
}
