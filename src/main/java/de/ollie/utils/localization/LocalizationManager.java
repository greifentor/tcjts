package de.ollie.utils.localization;

import static de.ollie.utils.Check.ensure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * A component which is able to provide localization resources.
 *
 * @author ollie
 *
 */
@Component
public class LocalizationManager {

	public static final Logger LOG = LoggerFactory.getLogger(LocalizationManager.class);

	private Map<SupportedLanguage, Properties> resources = new Hashtable<>();

	/**
	 * Creates a new LocalizationManager and reads the resources from the resource files.
	 */
	public LocalizationManager() {
		super();
		for (SupportedLanguage language : SupportedLanguage.values()) {
			String fileName = "META-INF/localization/resources_" + language.name() + ".properties";
			try {
				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
				InputStream is = classloader.getResourceAsStream(fileName);
				Properties properties = new Properties();
				properties.load(is);
				this.resources.put(language, properties);
			} catch (FileNotFoundException e) {
				LOG.error("Resource file not found for language: " + language + ", file: " + fileName);
				e.printStackTrace();
			} catch (IOException e) {
				LOG.error("Error while reading resource file for language: " + language + ", file: " + fileName
						+ ", exception: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * Returns the localized resource for the passed identifier and language.
	 *
	 * @param identifier The identifier of the text resource which is to return.
	 * @param language   The language which the text resource is to return for.
	 * @return The text resource for the passed identifier and language or a "null" value if no text resource is found
	 *         for the passed identifier and language.
	 * @throws IllegalArgumentException Passing a "null" value as language.
	 */
	public String getText(String identifier, SupportedLanguage language) {
		ensure(language != null, "language cannot be null.");
		if (identifier == null) {
			return null;
		}
		Properties p = this.resources.get(language);
		return p.getProperty(identifier);
	}

}