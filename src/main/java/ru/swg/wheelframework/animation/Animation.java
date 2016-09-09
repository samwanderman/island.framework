/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.animation;

/**
 * Animation interface
 */
public interface Animation {
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
