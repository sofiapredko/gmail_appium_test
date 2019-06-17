package com.sofia.pageobj.gmailpages;

import com.sofia.pageobj.GeneralPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailWelcomePage extends GeneralPage {
    private static final Logger LOG = LogManager.getLogger(GmailWelcomePage.class);

    @FindBy(id="com.google.android.gm:id/welcome_tour_got_it")
    private WebElement gotItButton;

    @FindBy(id="com.google.android.gm:id/setup_addresses_list")
    private WebElement adressesList;

    @FindBy(id="com.google.android.gm:id/action_done")
    private WebElement doneButton;

    @FindBy(id="com.google.android.gm:id/gm_dismiss_button")
    private WebElement dissmissButton;

    public void clickGotItButton() {
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(gotItButton));
        LOG.info("Clicking 'GOT IT' button");
        gotItButton.click();
    }

    public void clickDoneButton() {
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOf(adressesList));
        LOG.info("Clicking 'DONE' button");
        doneButton.click();
    }

    public void clickDissmissButton() {
        dissmissButton.click();
    }

}
