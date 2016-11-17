package ru.samwanderman.wheel.animation;

/**
 * Interface for object which can play animations
 */
public interface IAnimatedObject {
	void addAnimation(final String name, final IAnimation animation);
	void playAnimation(final String name);
	void stopCurrentAnimation();
	IAnimation getCurrentAnimation();
}
