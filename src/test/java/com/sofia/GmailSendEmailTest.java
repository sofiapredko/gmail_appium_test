package com.sofia;

import com.sofia.bussinesslayer.WelcomePageBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sofia.utils.DriverManager.getDriver;
import static com.sofia.utils.DriverManager.quitDriver;

public class GmailSendEmailTest {
    private static final Logger LOG = LogManager.getLogger(GmailSendEmailTest.class);
    private WelcomePageBO page = new WelcomePageBO();

    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @Test
    public void testWelcome() {
        page.skipWelcomePage();
    }

    @AfterMethod
    public void endTest() {
        quitDriver();
    }
}
