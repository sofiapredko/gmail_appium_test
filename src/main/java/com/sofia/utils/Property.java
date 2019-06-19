package com.sofia.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class Property {
    private static final Logger LOG = LogManager.getLogger(Property.class);

    public static String getProperty(final String keyToFile) {
        Properties properties = new Properties();
        try (InputStream input = Property.class.getClassLoader().getResourceAsStream("capabilities.properties")) {
            properties.load(Objects.requireNonNull(input));
            return properties.getProperty(keyToFile);
        } catch (IOException e) {
            LOG.error(e.getClass());
            LOG.error(e.getMessage());
            LOG.trace(e.getStackTrace());
            return null;
        }
    }
}