/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view.ui;

import java.awt.Image;
import java.io.IOException;

import ru.swg.wheelframework.io.ImageCache;
import ru.swg.wheelframework.io.Resources;
import ru.swg.wheelframework.log.Log;
import ru.swg.wheelframework.view.DisplayObject;
import ru.swg.wheelframework.view.GraphicsAdapter;

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
	public GuiImage(final String path) {
		this.path = path;
		Image image = null;
		
		try {
			image = Resources.loadImage(path);
		} catch (final IOException e) {
			Log.error(e.getLocalizedMessage());
		}
		ImageCache.set(path, image);
		setWidth(image.getWidth(null));
		setHeight(image.getHeight(null));
	}
	
	@Override
	public void setParent(final DisplayObject parent) {
		super.setParent(parent);
	}

	@Override
	public void paint(final GraphicsAdapter graphics) {
		graphics.drawImage(ImageCache.get(path), getAbsoluteX(), getAbsoluteY());
	}
	
	public final Image getImage() {
		return ImageCache.get(path);
	}
}
