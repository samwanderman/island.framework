/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.io;

import java.util.HashMap;
import java.util.Map;

import ru.samwanderman.rtwf.view.Image;

/**
 * Simple image cache
 */
public final class ImageCache {
	// cache
	private static final Map<String, Image> cache = new HashMap<>();
	
	/**
	 * Set image to cache
	 * 
	 * @param key
	 * @param image
	 */
	public static final void set(final String key, final Image image) {
		cache.put(key, image);
	}
	
	/**
	 * Get image from cache
	 * 
	 * @param key
	 * @return
	 * @throws ImageNotFoundException
	 */
	public static final Image get(final String key) {
		return cache.get(key);
	}
	
	/**
	 * Clear cache
	 */
	public static final void reset() {
		cache.clear();
	}
}
