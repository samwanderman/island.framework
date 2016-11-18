package ru.samwanderman.wheel.sound;

import javax.sound.sampled.Clip;

import ru.samwanderman.wheel.core.IPlayable;

public final class Sound implements IPlayable {
	private final Clip clip;
	
	public Sound(final Clip clip) { 
		this.clip = clip;
		clip.setFramePosition(0);
		clip.stop();
	}

	@Override
	public final boolean isRunning() {
		return clip.isRunning();
	}

	@Override
	public final void play() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
	}

	@Override
	public final void pause() {
		clip.stop();
	}

	@Override
	public final void stop() {
		clip.stop();
		clip.setFramePosition(0);
	}
}
