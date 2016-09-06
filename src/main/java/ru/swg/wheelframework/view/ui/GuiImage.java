/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view.ui;

import java.awt.Graphics2D;
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
		ImageCache.set(path, Resources.loadImage(path));
	}
	
	@Override
	public final void paint(final Graphics2D graphics) {
		super.paint(graphics);
		graphics.drawImage(ImageCache.get(path), getAbsoluteX(), getAbsoluteY(), null);
	}
}
