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

import static com.sofia.utils.Property.getProperty;

public class DriverManager {
    private static final Logger LOG = LogManager.getLogger(DriverManager.class);
    private static AndroidDriver<WebElement> driver;
    private static URL url;
    private static final String PLATFORM = getProperty("platform");
    private static final String DEVICE = getProperty("device");
    private static final String APP_PACK = getProperty("app_pack");
    private static final String APP_ACTIVITY = getProperty("app_activity");


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
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    private static DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACK);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        return capabilities;
    }

    public static void quitDriver() {
        LOG.info("Quiting driver");
        getDriver().quit();
    }
}
