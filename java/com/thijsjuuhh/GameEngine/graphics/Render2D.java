package com.thijsjuuhh.GameEngine.graphics;

public class Render2D {

	private int width, height;
	public int[] pixels;

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

	public void fillRect(int x0, int y0, int w, int h, int col) {
		for (int y = y0; y < y0 + h; y++) {
			for (int x = x0; x < x0 + w; x++) {
				if (x < 0 || x >= width || y < 0 || y >= height)
					continue;
				pixels[x + y * width] = col;
			}
		}
	}

}
