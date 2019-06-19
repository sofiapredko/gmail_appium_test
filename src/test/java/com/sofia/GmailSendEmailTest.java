package com.sofia;

import com.sofia.bussinesslayer.HomePageBO;
import com.sofia.bussinesslayer.WelcomePageBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sofia.utils.DriverManager.getDriver;
import static com.sofia.utils.DriverManager.quitDriver;
import static org.testng.AssertJUnit.assertEquals;

public class GmailSendEmailTest {
    private static final Logger LOG = LogManager.getLogger(GmailSendEmailTest.class);
    private WelcomePageBO welcomePage = new WelcomePageBO();
    private HomePageBO homePage = new HomePageBO();
    private static final String RECEIVER = "vmuka1998@gmail.com";
    private static final String SUBJECT = "TA Test Letter";
    private static final String EMAIL_TEXT = "HELLLLOOOO";

    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @Test
    public void testWelcome() {
        welcomePage.skipWelcomePage();
        homePage.createEmail();
        assertEquals(homePage.fillReceiverInfo(RECEIVER), RECEIVER);
        homePage.fillSubjectInfo(SUBJECT);
        //assertEquals(homePage.getSubjectValue(), SUBJECT);
        homePage.typeEmailText(EMAIL_TEXT);
        homePage.sendEmail();
    }

    @AfterMethod
    public void endTest() {
        quitDriver();
    }
}
