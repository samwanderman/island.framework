/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.io;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.samwanderman.wheel.log.Log;
import ru.samwanderman.wheel.view.Graphics;
import ru.samwanderman.wheel.view.Image;

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

	private static final Image loadImage(final File file) 
			throws IOException {
		return new Image(ImageIO.read(file));
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
		return loadImage(new File(CONST_RESOURCES + "/images/" + path));
	}
	
	/**
	 * Save image to default storage
	 * 
	 * @param path
	 * @param image
	 * @throws IOException
	 */
	public static final void saveImage(final String path, final Image image) 
			throws IOException {
		final BufferedImage buffImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		final Graphics graphics = new Graphics(buffImage.createGraphics());
		graphics.setComposite(Graphics.COMPOSITE_ALPHA);
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
		graphics.setComposite(Graphics.COMPOSITE_SRC);
		graphics.drawImage(image, null, null);
		ImageIO.write((RenderedImage) buffImage, "png", new File(CONST_RESOURCES + "/images/" + path));
	}
	
	/**
	 * Load animation
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static final List<Image> loadAnimation(final String path) 
			throws IOException {
		final List<Image> images = new ArrayList<Image>();
		final File directory = new File(CONST_RESOURCES + "/animations/" + path);
		if (!directory.exists() || !directory.isDirectory()) {
			return images;
		}
		
		final File[] files = directory.listFiles();
		for (final File file: files) {
			if (file.isFile()) {
				images.add(loadImage(file));
			}
		}
		
		return images;
	}
	
	/**
	 * Load any json object
	 * 
	 * @param path
	 * @param objectClass
	 * @return
	 * @throws IOException
	 */
	public static final <T> T loadObject(final String path, final Class<T> objectClass) 
			throws IOException {
		return mapper.readValue(new File(CONST_RESOURCES + path), objectClass);
	}
	
	/**
	 * Load any json object
	 * 
	 * @param file
	 * @param objectClass
	 * @return
	 * @throws IOException
	 */
	public static final <T> T loadObject(final File file, final Class<T> objectClass) 
			throws IOException {
		return mapper.readValue(file, objectClass);
	}
	
	/**
	 * Save any json object
	 * 
	 * @param path
	 * @param object
	 * @throws IOException
	 */
	public static final <T> void saveObject(final String path, final T object) 
			throws IOException {
		mapper.writeValue(new File(CONST_RESOURCES + path), object);
	}
	
	public static final <T> void saveObject(final String path, final T object, final boolean f) 
			throws IOException {
		mapper.writeValue(new File(path), object);
	}
	
	/**
	 * Load any json object through absolute path
	 * 
	 * @param absolutePath
	 * @param objectClass
	 * @param absolute
	 * @return
	 * @throws IOException
	 */
	public static final <T> T loadObject(final String absolutePath, final Class<T> objectClass, final boolean absolute) 
			throws IOException {
		return mapper.readValue(new File(absolutePath), objectClass);
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
	
	public static JsonNode loadJSON(final String path, final boolean f) 
			throws IOException {
		return mapper.readTree(new File(path));
	}
}
