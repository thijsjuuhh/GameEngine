package com.thijsjuuhh.GameEngine.graphics;

public class SubSheet extends SpriteSheet {

	private int x, y;
	private SpriteSheet s;

	public SubSheet(int x, int y, int width, int height, int spriteWidth, int spriteHeight, SpriteSheet s) {
		super(s.path);
		this.width = width * spriteWidth;
		this.height = height * spriteHeight;
		this.s = s;
		this.x = x * spriteWidth;
		this.y = y * spriteHeight;
		load();
	}

	private void load() {
		for (int y = 0; y < height; y++) {
			int yp = y + this.y;
			for (int x = 0; x < width; x++) {
				int xp = x + this.x;
				pixels[x + y * width] = s.pixels[xp + yp * s.getWidth()];
			}
		}
	}
}
