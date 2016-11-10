/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.util;

import ru.samwanderman.wheel.log.Log;

/**
 * Array util
 */
public final class ArrayUtil {
	/**
	 * Clone array
	 * 
	 * @param array
	 * @return
	 */
	public static final int[][] clone(final int[][] array) {
		final int[][] newArray = new int[array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				newArray[i][j] = array[i][j];
			}
		}
		
		return newArray;
	}
	
	/**
	 * Print simple level
	 * 
	 * @param level
	 */
	public static void print(final int[][] level) {
		final int width = level.length, height = level[0].length;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Log.log(level[j][i] + " ");
			}
			Log.log("\r\n");
		}
	}
}
