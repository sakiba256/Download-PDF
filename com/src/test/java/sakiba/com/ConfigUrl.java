package sakiba.com;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUrl {
	

	private static Properties properties;
    //Read Data From Config File
    static {
        properties = new Properties();
        try (InputStream inputStream = ConfigUrl.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getURL(String key) {
        return properties.getProperty(key);
    }
}
	


