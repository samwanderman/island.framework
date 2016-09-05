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
	public static final void init() 
			throws FileNotFoundException, IOException {
		Log.info("esource loading...");
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
		final File file = new File("./resources/strings/strings_ru.properties");
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
		return ImageIO.read(new File("./resources/images/" + path));
	}
}
