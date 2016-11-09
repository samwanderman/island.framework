/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import ru.samwanderman.rtwf.core.Config;
import ru.samwanderman.rtwf.event.Events;
import ru.samwanderman.rtwf.event.event.GuiEvent;
import ru.samwanderman.rtwf.event.event.GuiRepaintEvent;
import ru.samwanderman.rtwf.event.event.SyncEvent;
import ru.samwanderman.rtwf.event.interfaces.GuiRepaintEventInterface;
import ru.samwanderman.rtwf.event.listener.GuiRepaintEventListener;
import ru.samwanderman.rtwf.log.Log;

/**
 * Adapter to java view system
 */
public class FrameworkAdapter extends Component implements Runnable, GuiRepaintEventInterface {
	private static final long serialVersionUID = -2752101691826758979L;
	
	// Fake container for proper event dispatching
	private final DisplayContainer fakeContainer;
	// Current game board
	private final DisplayObject board;
	// Animation thread
	private final Thread animator = new Thread(this);
	// sync thread
	private final Thread syncer = new Thread(new SyncThread());
	// Gui repaint event listener
	private final GuiRepaintEventListener guiRepaintEventListener = new GuiRepaintEventListener(this);
	
	/**
	 * Constructor
	 * 
	 * @param board
	 */
	public FrameworkAdapter(final DisplayObject board, final int width, final int height) {
		this.board = board;
		setSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.BLACK);
		fakeContainer = new DisplayContainer(width, height);
		fakeContainer.addChild(board);
		Events.addListener(GuiRepaintEvent.class, guiRepaintEventListener);
	}
	
	@Override
	public final void addNotify() {
		super.addNotify();
    	animator.start();
    	syncer.start();
	}
	
	@Override
	public final void paint(final java.awt.Graphics graphics) {
		super.paint(graphics);
		final GuiEvent event = new GuiEvent(board, new Graphics(graphics));
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
	
	@Override
	public final void onRepaint() {
		this.repaint();
	}
	
	/**
	 * Sync Thread
	 * 
	 */
	private static final class SyncThread implements Runnable {
		@Override
		public final void run() {
			while (true) {
				Events.dispatch(new SyncEvent());
				try {
					Thread.sleep(Config.GLOBAL_TIMER_STEP);
				} catch (InterruptedException e) {
					Log.error("Sync event dispatch error");
				}
			}
		}
	}
}
