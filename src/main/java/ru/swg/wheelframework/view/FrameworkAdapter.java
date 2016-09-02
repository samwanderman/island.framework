/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.awt.Component;

import ru.swg.wheelframework.core.Config;
import ru.swg.wheelframework.log.Log;

/**
 * Adapter between framework and jwm 
 */
public class FrameworkAdapter extends Component implements Runnable {
	private static final long serialVersionUID = -2752101691826758979L;
	
	/**
	 * Main game board
	 */
	private DisplayObject board = null;
	
	/**
	 * Animation thread
	 */
	private Thread animator = null;
	
	/**
	 * Default constructor
	 * 
	 * @param board
	 */
	public FrameworkAdapter(DisplayObject board) {
		this.board = board;
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		
    	animator = new Thread(this);
    	animator.start();
	}
	
	@Override
    public void run() {
		long beforeTime = System.currentTimeMillis(), timeDiff, sleep;
		
		while (true) {
			repaint();
			
			// how many time have passed
			timeDiff = System.currentTimeMillis() - beforeTime;
			/**
			 * how long thread should sleep, if paint was too fast - wait longer
			 */
			sleep = Config.CONST_ANIM_THREAD_TIME_DELAY - timeDiff;
			if (sleep < 0) {
				sleep = 2;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				Log.error("ERROR: Thread.sleep() error");
			}
			
			beforeTime = System.currentTimeMillis();
		}
	}
}
