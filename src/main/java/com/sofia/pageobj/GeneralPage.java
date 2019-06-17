package com.sofia.pageobj;

import com.sofia.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GeneralPage {
    protected WebDriver driver;
    private WebDriverWait webDriverWait;

    public GeneralPage() {
        driver = DriverManager.getDriver();
        webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
}

