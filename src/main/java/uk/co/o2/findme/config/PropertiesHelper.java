package uk.co.o2.findme.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

class PropertiesHelper {
    private final Properties properties;

    PropertiesHelper(Properties properties) {
        this.properties = properties;
    }

    public boolean getBoolean(String key) {
        String value = properties.getProperty(key).toLowerCase();
        if (!"true".equals(value) && !"false".equals(value)) {
            throw new IllegalArgumentException("Not a valid boolean! : " + key + "=" + value);
        }
        return Boolean.valueOf(value);
    }

    public int getInteger(String key) {
        String value = properties.getProperty(key);
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not a valid number! : " + key + "=" + value, e);
        }
    }

    public URL getUrl(String key) {
        String value = properties.getProperty(key);
        try {
            return new URL(value);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Not a valid URL! : " + key + "=" + value, e);
        }
    }

    public String getString(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("String not found! : " + key + "=" + value);
        }
        return value;
    }
}
