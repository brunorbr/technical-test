package com.technicaltest.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyConverterPage extends PageObjectBase {
    @FindBy(id = "amount")
    public WebElement amountField;

    @FindBy(id = "midmarketFromCurrency")
    private WebElement originCurrencyField;

    @FindBy(id = "midmarketToCurrency")
    private WebElement targetCurrencyField;

    @FindBy(xpath = "//div[@data-key='GBP']")
    private WebElement conversionRateEURtoGBP;

    public CurrencyConverterPage(WebDriver driver){
        super(driver);
    }

    public void inputAmount(String amount){
        amountField.sendKeys(amount);
    }

    public void selectOriginCurrency(String originCurrency){
        originCurrencyField.sendKeys(originCurrency);
    }

    public void selectTargetCurrency(String targetCurrency){
        targetCurrencyField.sendKeys(targetCurrency);
    }

    public String getConvertRate(){
        String conversionRate = conversionRateEURtoGBP.getText().split("\n")[1];
        while(conversionRate == "Send") conversionRate = conversionRateEURtoGBP.getText().split("\n")[1];
        return conversionRate;
    }
}