package ru.samwanderman.wheel.animation;

import ru.samwanderman.wheel.core.IPlayable;
import ru.samwanderman.wheel.event.event.ISyncEvent;
import ru.samwanderman.wheel.view.Image;

/**
 * Animation interface
 */
public interface IAnimation extends IPlayable, ISyncEvent {
	String getName();
	Image getImage();
}
