package com.sofia.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final Logger LOG = LogManager.getLogger(DriverManager.class);
    private static AndroidDriver<WebElement> driver;
    private static URL url;

    private DriverManager() {
    }

    static {
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver<WebElement> getDriver() {
        if (Objects.isNull(driver)) {
            LOG.info("Creating driver instance");
            setUpSettings();
        }
        return driver;
    }

    private static void setUpSettings() {
        LOG.info("Setting up driver");
        driver = new AndroidDriver(url, setCapabilities());
        driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
    }

    private static DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "69adc89e7d94");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.gm");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.gm.ConversationListActivityGmail");
        return capabilities;
    }

    public static void quitDriver() {
        LOG.info("Quiting driver");
        getDriver().quit();
    }
}
