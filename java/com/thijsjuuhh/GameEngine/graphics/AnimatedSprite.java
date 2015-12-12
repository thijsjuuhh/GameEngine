package com.thijsjuuhh.GameEngine.graphics;

import com.thijsjuuhh.GameEngine.Update;

public class AnimatedSprite extends Sprite implements Update {

	private SubSheet s;
	private int startFrame, endFrame, tsox, tsoy;
	private int current = 0;
	private boolean active = false;
	private int rate;
	private Sprite[] sprites;
	int time = 0;

	public AnimatedSprite(SubSheet s, int width, int height, int rate, int startFrame, int endFrame) {
		super(s, width, height);
		u.add(this);
		this.s = s;
		w = width;
		h = height;
		this.rate = rate;
		tsox = s.getWidth() / width;
		tsoy = s.getHeight() / height;
		this.startFrame = startFrame;
		this.endFrame = endFrame;
		sprites = new Sprite[w * h];

		load();
	}

	public void setActive(boolean active) {
		if (this.active == active)
			return;
		this.active = active;
		if (active)
			current = startFrame;
		else
			current = 0;

	}

	private void load() {
		for (int y = 0; y < tsoy; y++) {
			for (int x = 0; x < tsox; x++) {
				sprites[x + y * tsox] = new Sprite(w, h, x, y, s);
			}
		}
	}

	public Sprite[] getSprites() {
		return sprites;
	}

	public Sprite getCurrent() {
		return sprites[current];
	}

	@Override
	public void update() {
		time++;
		if (time >= Integer.MAX_VALUE - 100)
			time = 0;
		if (active) {
			if (time % rate == 0)
				if (current <= endFrame - 1)
					current++;
				else
					current = startFrame;
		}

	}
}
