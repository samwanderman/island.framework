/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import ru.swg.wheelframework.log.Log;

/**
 * Class for resources manipulating
 */
public final class Resources {
	// String properties
	private final static Properties strings = new Properties();
	
	/**
	 * Init module
	 */
	public static void init() throws FileNotFoundException, IOException {
		Log.info("Resource loading...");
		loadStrings();
		Log.info("Strings loaded");
	}
	
	/**
	 * Load localized strings
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void loadStrings() 
			throws FileNotFoundException, IOException {
		File file = new File("./resources/strings/strings_ru.properties");
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		
		InputStreamReader is = new InputStreamReader(new FileInputStream(file), "UTF-8"); 
		strings.load(is);
		is.close();
	}
	
	/**
	 * Get string from properties
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return strings.getProperty(key);
	}
}
