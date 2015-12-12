package com.thijsjuuhh.GameEngine.graphics;

public class Render2D {

	private int width, height;
	public int[] pixels;

	private final int ALPHA_COL = 0xffff00ff;

	private int xOffset, yOffset;

	public Render2D(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderSpriteSheet(int xOffs, int yOffs, SpriteSheet s, boolean fixed) {
		if (fixed) {
			xOffs -= xOffset;
			yOffs -= yOffset;
		}
		for (int y = 0; y < s.getHeight(); y++) {
			int yP = y + yOffs;
			for (int x = 0; x < s.getWidth(); x++) {
				int xP = x + xOffs;
				if (outOfBounds(xP, yP))
					continue;
				int col = s.pixels[x + y * s.getWidth()];
				if (col != ALPHA_COL)
					pixels[xP + yP * width] = col;
			}
		}
	}

	public void renderSprite(int xOffs, int yOffs, Sprite s, boolean fixed) {
		if (fixed) {
			xOffs -= xOffset;
			yOffs -= yOffset;
		}
		for (int y = 0; y < s.getHeight(); y++) {
			int yP = y + yOffs;
			for (int x = 0; x < s.getWidth(); x++) {
				int xP = x + xOffs;
				if (outOfBounds(xP, yP))
					continue;
				int col = s.pixels[x + y * s.getWidth()];
				if (col != ALPHA_COL)
					pixels[xP + yP * width] = col;
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private boolean outOfBounds(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height)
			return true;
		return false;
	}

	public void fillRect(int x0, int y0, int w, int h, int col) {
		for (int y = y0; y < y0 + h; y++) {
			for (int x = x0; x < x0 + w; x++) {
				if (outOfBounds(x, y))
					continue;
				pixels[x + y * width] = col;
			}
		}
	}

	public void setOffset(int nxo, int nyo) {
		xOffset = nxo;
		yOffset = nyo;
	}

}
