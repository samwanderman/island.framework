/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.core;

import ru.samwanderman.wheel.view.Color;

/**
 * Framework configuration
 */
public final class Config {
	/**
	 * Default animation thread delay
	 */
	public static final int DEFAULT_ANIMATION_THREAD_DELAY = 500;
	/**
	 * Default background color
	 */
	public static final Color DEFAULT_BACKGROUND_COLOR = Color.GRAY;
	/**
	 * Sync events step
	 */
	public static final int GLOBAL_TIMER_STEP = 10;

	/**
	 * Cell is available
	 */
	public static final int CELL_AVAILABLE = 0;
	/**
	 * Cell is permanently unavailable
	 */
	public static final int CELL_UNAVAILABLE = -1;
	/**
	 * Cell is temporarily unavailable - unit's finish point
	 */
	public static final int CELL_TEMPORARILY_UNAVAILABLE = -2;
	/**
	 * Cell is temporarily unavailable - unit's walk point
	 * 
	 * NOTE: Cell will be available after timeout
	 */
	public static final int CELL_BUSY = -3;
}
