package ru.samwanderman.wheel.view;

/**
 * Simple wrapper
 */
public final class Image {
	private final java.awt.Image image;
	
	/**
	 * Constructor
	 * 
	 * @param image
	 */
	public Image(final java.awt.Image image) {
		this.image = image;
	}
	
	/**
	 * Get image width
	 * 
	 * @return
	 */
	public final int getWidth() {
		return image.getWidth(null);
	}
	
	/**
	 * Get image height
	 * 
	 * @return
	 */
	public final int getHeight() {
		return image.getHeight(null);
	}
	
	/**
	 * Get content
	 * 
	 * @return
	 */
	public final java.awt.Image getContent() {
		return image;
	}
}
