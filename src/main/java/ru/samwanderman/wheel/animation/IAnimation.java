package ru.samwanderman.wheel.animation;

import ru.samwanderman.wheel.event.event.ISyncEvent;
import ru.samwanderman.wheel.view.Image;

/**
 * Animation interface
 */
public interface IAnimation extends ISyncEvent {
	boolean isRunning();
	void play();
	void pause();
	void stop();
	Image getImage();
}
