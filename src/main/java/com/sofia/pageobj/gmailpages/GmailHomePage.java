package com.sofia.pageobj.gmailpages;

import com.sofia.pageobj.GeneralPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends GeneralPage {
    @FindBy(id="com.google.android.gm:id/compose_button")
    private WebElement composeButton;

    @FindBy(id="com.google.android.gm:id/to")
    private WebElement fieldTo;

    @FindBy(id="com.google.android.gm:id/subject")
    private WebElement fieldSubject;


}
