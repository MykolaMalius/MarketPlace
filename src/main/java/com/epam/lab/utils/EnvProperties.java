package com.epam.lab.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvProperties {
    private Properties properties;

    public EnvProperties() {
        properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getBaseUrl () {
        return properties.getProperty("BaseURL");
    }
    public String getCategoryURL () {
        return properties.getProperty("CategoryURL");
    }
    public String getSearchURL () {
        return properties.getProperty("SearchURL");
    }
}

