package com.sofia.bussinesslayer;

import com.sofia.pageobj.gmailpages.GmailHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageBO {
    private static final Logger LOG = LogManager.getLogger(WelcomePageBO.class);
    private GmailHomePage homePage = new GmailHomePage();

    public void fillReceiverInfo(String receiver) {
        LOG.info("Filling receiver email");
        homePage.fillToField(receiver);
    }

    public void fillSubjectInfo(String subject) {
        LOG.info("Filling email`s subject field");
        homePage.fillSubjectField(subject);
    }

    public void typeEmailText(String emailText) {
        LOG.info("Typing email`s text");
        homePage.fillEmailText(emailText);
    }

    public void createEmail(){
        LOG.info("Starting to compose email");
        homePage.clickComposeButton();
    }

    public void sendEmail(){
        LOG.info("Sending email");
        homePage.clickSendButton();
    }
}
