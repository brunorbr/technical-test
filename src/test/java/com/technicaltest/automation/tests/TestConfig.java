package com.technicaltest.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestConfig {

    protected WebDriver driver;

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
}
