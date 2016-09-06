/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.io;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.swg.wheelframework.log.Log;

/**
 * Class for resources manipulating
 */
public final class Resources {
	// Default resources folder
	private static final String CONST_RESOURCES = "./resources/";
	// String properties
	private static final Properties strings = new Properties();
	// JSON mapper
	private static final ObjectMapper mapper;
	
	// Static initializer
	static {
		// Mapper initialization and configuration
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}
	
	/**
	 * Init module
	 */
	public static final void init() 
			throws FileNotFoundException, IOException {
		Log.info("Resources loading...");
		loadStrings();
		Log.info("Strings loaded");
	}
	
	/**
	 * Load localized strings
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static final void loadStrings() 
			throws FileNotFoundException, IOException {
		final File file = new File(CONST_RESOURCES + "/strings/strings_ru.properties");
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		
		final InputStreamReader is = new InputStreamReader(new FileInputStream(file), "UTF-8"); 
		strings.load(is);
		is.close();
	}
	
	/**
	 * Get string from properties
	 * 
	 * @param key
	 * @return
	 */
	public static final String getString(final String key) {
		return strings.getProperty(key);
	}
	
	/**
	 * Load image from default storage
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static final Image loadImage(final String path) 
			throws IOException {
		return ImageIO.read(new File(CONST_RESOURCES + "/images/" + path));
	}
	
	/**
	 * Load any json object
	 * 
	 * @param path
	 * @param objectClass
	 * @return
	 * @throws IOException
	 */
	public static <T> T loadObject(final String path, final Class<T> objectClass) 
			throws IOException {
		return mapper.readValue(new File(CONST_RESOURCES + path), objectClass);
	}
	
	/**
	 * Load raw json
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static JsonNode loadJSON(final String path) 
			throws IOException {
		return mapper.readTree(new File(CONST_RESOURCES + path));
	}
}
