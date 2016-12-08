package ru.samwanderman.wheel.animation;

import ru.samwanderman.wheel.core.IPlayable;
import ru.samwanderman.wheel.event.event.ISyncEvent;
import ru.samwanderman.wheel.event.listener.ObjectListener;
import ru.samwanderman.wheel.view.Image;

/**
 * Animation interface
 */
public interface IAnimation extends IPlayable, ISyncEvent {
	void play(final ObjectListener<Object> callback);
	String getName();
	Image getImage();
}
