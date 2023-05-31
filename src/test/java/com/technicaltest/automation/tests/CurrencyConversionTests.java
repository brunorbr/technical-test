package com.technicaltest.automation.tests;

import com.technicaltest.automation.pageobjects.ConvertedCurrencyPage;
import com.technicaltest.automation.pageobjects.CurrencyConverterPage;
import com.technicaltest.automation.utils.CurrencyConversion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CurrencyConversionTests {

    private WebDriver driver;
    private CurrencyConverterPage converterPage;
    private ConvertedCurrencyPage conversionResultPage;
    private CurrencyConversion testConversion;
    private String valueToCheck;
    private String expectedResult;


    @BeforeEach
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.xe.com/currencyconverter/");
    }

    @AfterEach
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.25", "0.72", "3.3", "21.32", "145.34", "211.00"})
    public void validateIfConversionIsDoneCorrectly(String valueInEUR) throws InterruptedException {
        converterPage = new CurrencyConverterPage(driver);
        converterPage.inputAmount(valueInEUR);
        converterPage.selectOriginCurrency();
        valueToCheck = converterPage.getConvertRate();
        converterPage.selectTargetCurrency();
        conversionResultPage = converterPage.submitCurrencyConversion();
        Assertions.assertEquals(getExpectedResult(valueInEUR,
                valueToCheck, conversionResultPage.getDecimals()),
                conversionResultPage.getConversionResult());
    }

    public String getExpectedResult(String EUR, String rate, int scale){
        testConversion = new CurrencyConversion(EUR, rate, scale);
        return String.valueOf(testConversion.getConvertedValue() + " British Pounds");
    }
}
