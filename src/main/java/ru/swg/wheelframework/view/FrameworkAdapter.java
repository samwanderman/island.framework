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
	
	private final DisplayContainer fakeContainer;
	private final DisplayObject board;
	private Thread animator = null;
	
	public FrameworkAdapter(final DisplayObject board) {
		fakeContainer = new DisplayContainer();
		this.board = board;
		fakeContainer.addChild(board);
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		
    	animator = new Thread(this);
    	animator.start();
	}
	
	@Override
	public void paint(final Graphics graphics) {
		super.paint(graphics);
		GuiEvent event = new GuiEvent(board, (Graphics2D) graphics);
		Events.dispatch(event);
	}
	
	@Override
    public void run() {
		long beforeTime = System.currentTimeMillis(), timeDiff, sleep;
		
		while (true) {
			repaint();
			
			timeDiff = System.currentTimeMillis() - beforeTime;
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
