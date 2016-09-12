/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.core;

import java.awt.Color;

/**
 * Framework configuration
 */
public final class Config {
	// Default animation thread delay
	public static final int DEFAULT_ANIMATION_THREAD_DELAY = 500;
	// Default background color
	public static final Color DEFAULT_BACKGROUND_COLOR = Color.GRAY;
	// Sync events step
	public static final int GLOBAL_TIMER_STEP = 10;
	
	// Cell statuses
	public static final int CELL_AVAILABLE = 0;
	public static final int CELL_UNAVAILABLE = -1;
	public static final int CELL_TEMPORARILY_UNAVAILABLE = -2;
}
