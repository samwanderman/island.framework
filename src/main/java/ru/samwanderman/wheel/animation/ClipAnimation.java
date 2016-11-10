package ru.samwanderman.wheel.animation;

import java.util.ArrayList;
import java.util.List;

import ru.samwanderman.wheel.core.Config;
import ru.samwanderman.wheel.event.interfaces.GuiEventInterface;
import ru.samwanderman.wheel.event.listener.ObjectListener;
import ru.samwanderman.wheel.view.DisplayObject;
import ru.samwanderman.wheel.view.Graphics;
import ru.samwanderman.wheel.view.Image;

/**
 * Clip animation
 */
public class ClipAnimation extends Animation implements GuiEventInterface {
	private final DisplayObject target;
	private final List<Image> images;
	private final int speed;
	private int step;
	
	public ClipAnimation(final DisplayObject target, final List<Image> images, final int speed, final ObjectListener<Boolean> successCallback, final ObjectListener<Object> errorCallback) {
		super(successCallback, errorCallback);
		this.target = target;
		this.images = (images == null ? new ArrayList<Image>() : images);
		this.speed = speed;
		step = 0;
	}
	
	@Override
	public final void reset() {
		stop();
		step = 0;
	}
	
	@Override
	public final void run() {
		if (!isRunning()) {
			return;
		}
		
		if (step >= speed) {
			if (getSuccessCallback() != null) {
				getSuccessCallback().on(true);
				return;
			}
			
			step = 0;
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
		
		paintImage(graphics, images.get(idx));
	}
	
	protected final DisplayObject getTarget() {
		return target;
	}
	
	protected void paintImage(final Graphics graphics, final Image image) {
		graphics.drawImage(image, target.getX(), target.getY());		
	}
}
