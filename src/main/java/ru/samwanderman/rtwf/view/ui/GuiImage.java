/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.view.ui;

import java.io.IOException;

import ru.samwanderman.rtwf.io.ImageCache;
import ru.samwanderman.rtwf.io.Resources;
import ru.samwanderman.rtwf.log.Log;
import ru.samwanderman.rtwf.view.DisplayObject;
import ru.samwanderman.rtwf.view.Graphics;
import ru.samwanderman.rtwf.view.Image;

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
		setWidth(image.getWidth());
		setHeight(image.getHeight());
	}
	
	@Override
	public void setParent(final DisplayObject parent) {
		super.setParent(parent);
	}

	@Override
	public void paint(final Graphics graphics) {
		graphics.drawImage(ImageCache.get(path), getAbsoluteX(), getAbsoluteY());
	}
	
	public final Image getImage() {
		return ImageCache.get(path);
	}
}
