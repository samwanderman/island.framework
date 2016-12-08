package ru.samwanderman.wheel.animation;

import ru.samwanderman.wheel.event.listener.ObjectListener;

/**
 * Interface for object which can play animations
 */
public interface IAnimatedObject {
	void addAnimation(final String name, final IAnimation animation);
	void playAnimation(final String name);
	void playAnimation(final String name, final ObjectListener<Object> listener);
	void stopCurrentAnimation();
	IAnimation getCurrentAnimation();
}
