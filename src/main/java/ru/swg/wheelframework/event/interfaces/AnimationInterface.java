package ru.swg.wheelframework.event.interfaces;

/**
 * Animation interface
 */
public interface AnimationInterface {
	// Start animation
	void start();
	// Stop animation
	void stop();
	// Restart animation
	void restart();
	// Run animation
	void run();
	// check if animation running
	boolean isRunning();
}
