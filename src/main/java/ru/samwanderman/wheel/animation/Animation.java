package ru.samwanderman.wheel.animation;

import java.util.ArrayList;
import java.util.List;

import ru.samwanderman.wheel.core.Config;
import ru.samwanderman.wheel.view.Image;

/**
 * Animation
 * 
 * Simple animation without state controls
 */
public class Animation implements IAnimation {
	private boolean running = false;
	private final List<Image> images;
	private final int speed;
	private int step;
	
	public Animation(final List<Image> images, final int speed) {
		this.images = (images == null ? new ArrayList<Image>() : images);
		this.speed = speed;
		step = 0;
	}
	
	@Override
	public final boolean isRunning() {
		return running;
	}
	
	@Override
	public final void play() {
		running = true;
	}
	
	@Override
	public final void pause() {
		running = false;
	}
	
	@Override
	public void stop() {
		running = false;
		step = 0;
	}
		
	@Override
	public final void sync() {
		if (!running) {
			return;
		}
		
		if (step >= speed) {
			step = 0;
		}

		step += Config.GLOBAL_TIMER_STEP;
	}
	
	@Override
	public final Image getImage() {
		final int num = speed / images.size();
		int idx = step / num + (step % num > 0 ? 1 : 0);
		if (idx > images.size() - 1) {
			idx = images.size() - 1;
		}
		
		return images.get(idx);
	}
}
