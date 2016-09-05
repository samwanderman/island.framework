/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view.ui;

import java.awt.Graphics2D;
import java.io.IOException;

import ru.swg.wheelframework.io.ImageCache;
import ru.swg.wheelframework.io.Resources;
import ru.swg.wheelframework.log.Log;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Class for Images
 */
public class GuiImage extends DisplayObject {
	private final String path;
	
	public GuiImage(final String path) {
		this.path = path;
		
		try {
			ImageCache.set(path, Resources.loadImage(path));
		} catch (IOException e) {
			Log.error("Image not found!");
		}
	}
	
	@Override
	public final void paint(final Graphics2D graphics) {
		super.paint(graphics);
		graphics.drawImage(ImageCache.get(path), getParent().getX() + getX(), getParent().getY() + getY(), null);
	}
}
