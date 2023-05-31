package com.technicaltest.automation.tests;

import com.technicaltest.automation.pageobjects.ConvertedCurrencyPage;
import com.technicaltest.automation.pageobjects.CurrencyConverterPage;
import com.technicaltest.automation.utils.CurrencyConversion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    @ValueSource(strings = {"0.25", "0.72", "1.0", "1.32", "45.0"})
    public void validateIfConversionIsDoneCorrectly(String valueInEUR) throws InterruptedException {
        converterPage = new CurrencyConverterPage(driver);
        converterPage.inputAmount(valueInEUR);
        converterPage.selectOriginCurrency();
        expectedResult = getExpectedResult(valueInEUR);
        converterPage.selectTargetCurrency();
        conversionResultPage = converterPage.submitCurrencyConversion();
        Assertions.assertEquals(expectedResult, conversionResultPage.getConversionResult());
    }

    public String getExpectedResult(String EUR){
        testConversion = new CurrencyConversion(EUR, converterPage.getConvertRate());
        return String.valueOf(testConversion.getConvertedValue() + " British Pounds");
    }
}
