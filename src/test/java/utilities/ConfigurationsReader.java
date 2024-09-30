package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Utility class to read configuration properties from a file.
 */
public class ConfigurationsReader {
    private static Properties configFile;

    static {
        try {
            String path = "config.properties";
            FileInputStream input = new FileInputStream(path);
            configFile = new Properties();
            configFile.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the property value for the given key.
     *
     * @param key the property key
     * @return the property value
     */
    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }

    public static void set(String keyName, String value) {
        String path = "Configuration.properties";

        try {
            OutputStream output = new FileOutputStream(path);
            configFile.setProperty(keyName, value);
            configFile.store(output, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}