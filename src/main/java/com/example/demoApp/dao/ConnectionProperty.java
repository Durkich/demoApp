package com.example.demoApp.dao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ConnectionProperty {
    public static final String CONFIG_NAME = "C:/Users/79283/IdeaProjects/demoApp/config.properties";
    public static final Properties GLOBAl_CONFIG = new Properties();
    public ConnectionProperty() throws FileNotFoundException,
            IOException {
        GLOBAl_CONFIG.load(new FileReader(CONFIG_NAME));
    }
    public static String getProperty(String property) {
        return GLOBAl_CONFIG.getProperty(property);
    }
}