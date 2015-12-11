package com.thijsjuuhh.GameEngine.level;

import java.util.Random;

import com.thijsjuuhh.GameEngine.Update;
import com.thijsjuuhh.GameEngine.graphics.Render2D;
import com.thijsjuuhh.GameEngine.graphics.SpriteSheet;

public abstract class Level implements Update {

	protected int width, height;
	protected SpriteSheet s;
	protected static Random r = new Random();

	protected int[] pixels;

	public Level(SpriteSheet s) {
		u.add(this);
		width = s.getWidth();
		height = s.getHeight();
		pixels = new int[width * height];
		this.s = s;
		getPixels();
	}

	private void getPixels() {
		for (int y = 0; y < s.getHeight(); y++)
			for (int x = 0; x < s.getWidth(); x++)
				pixels[x + y * s.getWidth()] = s.pixels[x + y * s.getWidth()];
	}

	public abstract void render(int xOffset, int yOffset, Render2D r);

}
