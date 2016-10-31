package ru.swg.wheelframework.animation;

import java.util.ArrayList;
import java.util.List;

import ru.swg.wheelframework.core.Config;
import ru.swg.wheelframework.event.interfaces.GuiEventInterface;
import ru.swg.wheelframework.view.DisplayObject;
import ru.swg.wheelframework.view.Graphics;
import ru.swg.wheelframework.view.Image;

/**
 * Clip animation
 */
public final class ClipAnimation extends Animation implements GuiEventInterface {
	private final DisplayObject target;
	private final List<Image> images;
	private final int speed;
	private int step;
	
	public ClipAnimation(final DisplayObject target, final List<Image> images, final int speed) {
		this.target = target;
		this.images = (images == null ? new ArrayList<Image>() : images);
		this.speed = speed;
		step = 0;
	}
	
	@Override
	public final void run() {
		if (step >= speed) {
			stop();
		}

		step += Config.GLOBAL_TIMER_STEP;
	}

	@Override
	public final void paint(final Graphics graphics) {
		final int num = speed / images.size();
		int idx = step / num + (step % num > 0 ? 1 : 0);
		if (idx > images.size() - 1) {
			idx = images.size() - 1;
		}
		graphics.drawImage(images.get(idx), target.getX(), target.getY());
	}
}
