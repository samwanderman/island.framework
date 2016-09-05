/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import ru.swg.wheelframework.core.Config;
import ru.swg.wheelframework.event.Events;
import ru.swg.wheelframework.event.event.GuiEvent;
import ru.swg.wheelframework.log.Log;

/**
 * Adapter to java view system
 */
public class FrameworkAdapter extends Component implements Runnable {
	private static final long serialVersionUID = -2752101691826758979L;
	
	// Fake container for proper event dispatching
	private final DisplayContainer fakeContainer = new DisplayContainer();
	// Current game board
	private final DisplayObject board;
	// Animation thread
	private Thread animator = null;
	
	/**
	 * Constructor
	 * 
	 * @param board
	 */
	public FrameworkAdapter(final DisplayObject board) {
		this.board = board;
		fakeContainer.addChild(board);
	}
	
	@Override
	public final void addNotify() {
		super.addNotify();
		
    	animator = new Thread(this);
    	animator.start();
	}
	
	@Override
	public final void paint(final Graphics graphics) {
		super.paint(graphics);
		final GuiEvent event = new GuiEvent(board, (Graphics2D) graphics);
		Events.dispatch(event);
	}
	
	@Override
    public final void run() {
		long beforeTime = System.currentTimeMillis(), timeDiff, sleep;
		
		while (true) {
			repaint();
			
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = Config.DEFAULT_ANIMATION_THREAD_DELAY - timeDiff;
			if (sleep < 0) {
				sleep = 2;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				Log.error("Thread.sleep() error");
			}
			
			beforeTime = System.currentTimeMillis();
		}
	}
}
