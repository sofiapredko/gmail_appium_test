package com.sofia.bussinesslayer;

import com.sofia.pageobj.gmailpages.GmailWelcomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WelcomePageBO {
    private static final Logger LOG = LogManager.getLogger(WelcomePageBO.class);
    private GmailWelcomePage welcomePage = new GmailWelcomePage();

    public void skipWelcomePage() {
        LOG.info("Starting with Welcome Page");
        welcomePage.clickGotItButton();
        welcomePage.clickDoneButton();
        welcomePage.clickDissmissButton();
        welcomePage.clickDissmissButton();
    }
}
