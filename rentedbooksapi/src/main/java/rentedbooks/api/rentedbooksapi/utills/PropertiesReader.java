package rentedbooks.api.rentedbooksapi.utills;



import java.io.IOException;
import java.net.URL;
import java.util.Properties;



import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class PropertiesReader {
	/**
     * Constant LOGGER.
     */
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PropertiesReader.class);

    /**
     * Constant PROPERTIES.
     */
    private static final Properties PROPERTIES;

    /**
     * Constant PROP_FILE.
     */
    private static final String PROP_FILE = "/src/main/resources/apikey.properties";

    /**
     * Default private constructor PropertiesReader.
     */
    private PropertiesReader() {
    }

    static {
        PROPERTIES = new Properties();
        final URL props = ClassLoader.getSystemResource(PROP_FILE);
        try {
            PROPERTIES.load(props.openStream());
        } catch (IOException ex) {

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(ex.getClass().getName() + "PropertiesReader method");
            }
        }
    }

		   /**
		 * Method getProperty.
		 *
		 * @param name String name file.
		 * @return Return property
		 */
		public static String getProperty(final String name) {
		
		    return PROPERTIES.getProperty(name);
		}
}
