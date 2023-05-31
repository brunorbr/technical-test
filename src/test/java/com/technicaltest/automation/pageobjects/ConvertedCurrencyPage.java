package com.technicaltest.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConvertedCurrencyPage extends PageObjectBase {
    @FindBy(xpath = "//p[contains(@class,'result__BigRate')]")
    private WebElement conversionResult;
    private WebDriverWait wait;

    public ConvertedCurrencyPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public String getConversionResult(){
        wait.until(ExpectedConditions.elementToBeClickable(conversionResult));
        return conversionResult.getText();
    }
}
