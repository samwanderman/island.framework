/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.ai;

import java.util.LinkedList;

import ru.swg.wheelframework.core.Config;
import ru.swg.wheelframework.util.ArrayUtil;
import ru.swg.wheelframework.view.Point2D;

/**
 * Realization of Lee algorithm
 */
public final class LeeFindPathAlgorithm implements PathFindInterface {
	@Override
	public final LinkedList<Point2D> find(final int[][] srcMap, final Point2D startPoint, final Point2D finishPoint) {
		LinkedList<Point2D> path = new LinkedList<>();
		
		// Check if click on same point
		if (startPoint.equals(finishPoint)) {
			return path;
		}

		// make work array
		final int[][] map = ArrayUtil.clone(srcMap);
		
		if (step1(map, startPoint, finishPoint)) {
			path = step2(map, startPoint, finishPoint);
		}
		
		return path;
	}
	
	/**
	 * Step 1 of algorithm
	 * 
	 * @param map
	 * @param startPoint
	 * @param finishPoint
	 * @return
	 */
	private boolean step1(final int[][] map, final Point2D startPoint, final Point2D finishPoint) {
		final int width = map.length, height = map[0].length;
		final LinkedList<Point2D> queue = new LinkedList<>();
		queue.push(startPoint);
		map[startPoint.getX()][startPoint.getY()] = 1;
		
		while (!queue.isEmpty()) {
			final Point2D tmpPoint = queue.pop();
			final int x = tmpPoint.getX(), y = tmpPoint.getY();
			
			if ((finishPoint.getX() == x) && (finishPoint.getY() == y)) {
				return true;
			}

			// left top
			if ((x > 0) && (y > 0) && isAvailable(map[x - 1][y - 1]) && !isUnavailable(map[x - 1][y]) && !isUnavailable(map[x][y - 1])) {
				map[x - 1][y - 1] = map[x][y] + 1;
				queue.add(new Point2D(x - 1, y - 1));
			}
			
			// left
			if ((x > 0) && isAvailable(map[x - 1][y])) {
				map[x - 1][y] = map[x][y] + 1;
				queue.add(new Point2D(x - 1, y));
			}
			
			// left bottom
			if ((x > 0) && (y < height - 1) && isAvailable(map[x - 1][y + 1]) && !isUnavailable(map[x - 1][y]) && !isUnavailable(map[x][y + 1])) {
				map[x - 1][y + 1] = map[x][y] + 1;
				queue.add(new Point2D(x - 1, y + 1));
			}

			// top
			if ((y > 0) && isAvailable(map[x][y - 1])) {
				map[x][y - 1] = map[x][y] + 1;
				queue.add(new Point2D(x, y - 1));
			}

			// bottom
			if ((y < height - 1) && isAvailable(map[x][y + 1])) {
				map[x][y + 1] = map[x][y] + 1;
				queue.add(new Point2D(x, y + 1));
			}

			// right top
			if ((x < width - 1) && (y > 0) && isAvailable(map[x + 1][y - 1]) && !isUnavailable(map[x + 1][y]) && !isUnavailable(map[x][y - 1])) {
				map[x + 1][y - 1] = map[x][y] + 1;
				queue.add(new Point2D(x + 1, y - 1));
			}

			// right
			if ((x < width - 1) && isAvailable(map[x + 1][y])) {
				map[x + 1][y] = map[x][y] + 1;
				queue.add(new Point2D(x + 1, y));
			} 

			// right bottom
			if ((x < width - 1) && (y < height - 1) && isAvailable(map[x + 1][y + 1]) && !isUnavailable(map[x + 1][y]) && !isUnavailable(map[x][y + 1])) {
				map[x + 1][y + 1] = map[x][y] + 1;
				queue.add(new Point2D(x + 1, y + 1));
			}
		}
		
		return map[finishPoint.getX()][finishPoint.getY()] > 0;
	}
	
	/**
	 * Step 2 of algorithm
	 * 
	 * @param map
	 * @param startPoint
	 * @param finishPoint
	 * @return
	 */
	private final LinkedList<Point2D> step2(final int[][] map, final Point2D startPoint, final Point2D finishPoint) {
		final int width = map.length, height = map[0].length;
		final LinkedList<Point2D> path = new LinkedList<>();
		Point2D tmpPoint = finishPoint;
		
		while (true) {
			path.push(tmpPoint);
			final int x = tmpPoint.getX(), y = tmpPoint.getY();
			int weight = map[x][y];
			
			if ((x == startPoint.getX()) && (y == startPoint.getY())) {
				break;
			}

			// left
			if((x > 0) && (map[x - 1][y] < weight) && (map[x - 1][y] >= 1)) {
				weight = map[x - 1][y];
				tmpPoint = new Point2D(x - 1, y);
			}

			// top
			if ((y > 0) && (map[x][y - 1] < weight) && (map[x][y - 1] >= 1)) {
				weight = map[x][y - 1];
				tmpPoint = new Point2D(x, y - 1);
			}
			
			// bottom
			if ((y < height - 1) && (map[x][y + 1] < weight) && (map[x][y + 1] >= 1)) {
				weight = map[x][y + 1];
				tmpPoint = new Point2D(x, y + 1);
			}

			// right
			if((x < width - 1) && (map[x + 1][y] < weight) && (map[x + 1][y] >= 1)) {
				weight = map[x + 1][y];
				tmpPoint = new Point2D(x + 1, y);
			}

			// left top
			if ((x > 0) && (y > 0) && (map[x - 1][y - 1] < weight) && (map[x - 1][y - 1] >= 1) && !isUnavailable(map[x][y - 1]) && !isUnavailable(map[x - 1][y])) {
				weight = map[x - 1][y - 1];
				tmpPoint = new Point2D(x - 1, y - 1);
			}

			// left bottom
			if ((x > 0) && (y < height - 1) && (map[x - 1][y + 1] < weight) && (map[x - 1][y + 1] >= 1) && !isUnavailable(map[x][y + 1]) && !isUnavailable(map[x - 1][y])) {
				weight = map[x - 1][y + 1];
				tmpPoint = new Point2D(x - 1, y + 1);
			}

			// right top
			if ((x < width - 1) && (y > 0) && (map[x + 1][y - 1] < weight) && (map[x + 1][y - 1] >= 1) && !isUnavailable(map[x][y - 1]) && !isUnavailable(map[x + 1][y])) {
				weight = map[x + 1][y - 1];
				tmpPoint = new Point2D(x + 1, y - 1);
			}

			if ((x < width - 1) && (y < height - 1) && (map[x + 1][y + 1] < weight) && (map[x + 1][y + 1] >= 1) && !isUnavailable(map[x][y + 1]) && !isUnavailable(map[x + 1][y])) {
				weight = map[x + 1][y + 1];
				tmpPoint = new Point2D(x + 1, y + 1);
			}
		}

		return path;
	}
	
	/**
	 * Check if cell is available
	 * 
	 * @param el
	 * @return
	 */
	private static final boolean isAvailable(final int el) { 
		return (el == Config.CELL_AVAILABLE) || (el == Config.CELL_TEMPORARILY_UNAVAILABLE);
	}

	/**
	 * Check if cell is unavailable
	 * 
	 * @param el
	 * @return
	 */
	private static final boolean isUnavailable(final int el) {
		return el == Config.CELL_UNAVAILABLE;
	}
}
