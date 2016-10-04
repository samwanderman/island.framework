/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view.ui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import ru.swg.wheelframework.io.ImageCache;
import ru.swg.wheelframework.io.Resources;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Class for Images
 */
public class GuiImage extends DisplayObject {
	// path to image
	private final String path;
	
	/**
	 * Constructor
	 * 
	 * @param path
	 */
	public GuiImage(final String path) 
			throws IOException {
		this.path = path;
		final Image image = Resources.loadImage(path);
		ImageCache.set(path, image);
		setWidth(image.getWidth(null));
		setHeight(image.getHeight(null));
	}
	
	@Override
	public void setParent(final DisplayObject parent) {
		super.setParent(parent);
	}

	@Override
	public void paint(final Graphics2D graphics) {
		graphics.drawImage(ImageCache.get(path), getAbsoluteX(), getAbsoluteY(), null);
	}
	
	public final Image getImage() {
		return ImageCache.get(path);
	}
}
