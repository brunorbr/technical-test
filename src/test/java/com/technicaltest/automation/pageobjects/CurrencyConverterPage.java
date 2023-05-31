package com.technicaltest.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyConverterPage extends PageObjectBase {
    @FindBy(id = "amount")
    public WebElement amountField;

    @FindBy(id = "midmarketFromCurrency")
    private WebElement originCurrencyField;

    @FindBy(id = "midmarketFromCurrency-option-1")
    private WebElement euroSelectionOnOrigin;

    @FindBy(id = "midmarketToCurrency")
    private WebElement targetCurrencyField;

    @FindBy(id = "midmarketToCurrency-option-2")
    private WebElement poundsSelectionOnTarget;

    @FindBy(xpath = "//div[@data-key='GBP']")
    private WebElement conversionRateEURtoGBP;

    @FindBy(xpath = "//button[text() = 'Convert']")
    private WebElement convertButton;
    public CurrencyConverterPage(WebDriver driver){
        super(driver);
    }

    public void inputAmount(String amount){
        amountField.click();
        amountField.sendKeys(amount);
    }

    public void selectOriginCurrency(){
        originCurrencyField.click();
        euroSelectionOnOrigin.click();
    }

    public void selectTargetCurrency(){
        targetCurrencyField.click();
        poundsSelectionOnTarget.click();
    }

    public ConvertedCurrencyPage submitCurrencyConversion(){
        convertButton.click();
        return new ConvertedCurrencyPage(driver);
    }

    public String getConvertRate(){
        String conversionRate = conversionRateEURtoGBP.getText().split("\n")[1];
        while(conversionRate.length() < 7) conversionRate = conversionRateEURtoGBP.getText().split("\n")[1];
        return conversionRate;
    }
}