package com.sofia.pageobj.gmailpages;

import com.sofia.pageobj.GeneralPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePage extends GeneralPage {
    @FindBy(id="com.google.android.gm:id/compose_button")
    private WebElement composeButton;

    @FindBy(id="com.google.android.gm:id/to")
    private WebElement fieldTo;

    @FindBy(id="com.google.android.gm:id/subject")
    private WebElement fieldSubject;

    @FindBy(id="com.google.android.gm:id/body_wrapper")
    private WebElement emailTextField;

    @FindBy(id="com.google.android.gm:id/send")
    private WebElement sendEmailButton;

    public void clickComposeButton() {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(composeButton));
        composeButton.click();
    }

    public void clickSendButton() {
        sendEmailButton.click();
    }

    public void fillToField(String toWhom) {
        fieldTo.sendKeys(toWhom);
    }

    public void fillSubjectField(String subject) {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(fieldSubject));
        fieldSubject.click();
        fieldSubject.sendKeys(subject);
    }

    public void fillEmailText(String emailText) {
        emailTextField.sendKeys(emailText);
    }

    public String getReceiverValue() {
        return fieldTo.getText();
    }

    public String getSubjectValue() {
        return fieldSubject.getText();
    }

}
