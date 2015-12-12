package com.thijsjuuhh.GameEngine.graphics;

import java.awt.image.BufferedImage;

public class Sprite {

	protected SpriteSheet s;
	protected SubSheet sub;
	protected int w;
	protected int h;
	protected int x;
	protected int y;
	public int[] pixels;
	protected BufferedImage i;

	public Sprite(SubSheet s, int width, int height) {
		this.s = s;
		w = width;
		h = height;
		pixels = new int[w * h];
		load();
	}

	public Sprite(int width, int height, int x, int y, SpriteSheet s) {
		this.s = s;
		w = width;
		h = height;
		this.x = width * x;
		this.y = height * y;
		pixels = new int[width * height];
		load();
	}

	public Sprite(int width, int height, int col) {
		w = width;
		h = height;
		pixels = new int[w * h];
		setColor(col);
	}

	private void setColor(int col) {
		for (int i = 0; i < w * h; i++) {
			pixels[i] = col;
		}
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	private void load() {
		for (int y = 0; y < h; y++)
			for (int x = 0; x < w; x++)
				pixels[x + y * w] = s.pixels[(x + this.x) + (y + this.y) * s.getWidth()];

		i = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		i.setRGB(0, 0, w, h, pixels, 0, w);

	}

	public Sprite(int[] pixels, int w, int h) {
		this.w = w;
		this.h = h;
		this.pixels = new int[pixels.length];
		for (int i = 0; i < pixels.length; i++) {
			this.pixels[i] = pixels[i];
		}
	}

	public static Sprite rotate(Sprite s, double angle) {
		return new Sprite(rotate(s.pixels, s.getWidth(), s.getHeight(), angle), s.getWidth(), s.getHeight());
	}

	private static int[] rotate(int[] pixels, int width, int height, double angle) {
		int[] result = new int[width * height];

		double nx_x = rotX(-angle, 1.0, 0.0);
		double nx_y = rotY(-angle, 1.0, 0.0);
		double ny_x = rotX(-angle, 0.0, 1.0);
		double ny_y = rotY(-angle, 0.0, 1.0);

		double x0 = rotX(-angle, -width / 2.0, -height / 2.0) + width / 2.0;
		double y0 = rotY(-angle, -width / 2.0, -height / 2.0) + height / 2.0;

		for (int y = 0; y < height; y++) {
			double x1 = x0;
			double y1 = y0;
			for (int x = 0; x < width; x++) {
				int xx = (int) x1;
				int yy = (int) y1;
				int col = 0;
				if (xx < 0 || xx >= width || yy < 0 || yy >= width)
					col = 0xffff00ff;
				else
					col = pixels[xx + yy * width];
				result[x + y * width] = col;
				x1 += nx_x;
				y1 += nx_y;
			}
			x0 += ny_x;
			y0 += ny_y;

		}

		return result;
	}

	private static double rotX(double angle, double x, double y) {
		double cos = Math.cos(angle - Math.PI / 2);
		double sin = Math.sin(angle - Math.PI / 2);
		return x * cos + y * -sin;
	}

	private static double rotY(double angle, double x, double y) {
		double cos = Math.cos(angle - Math.PI / 2);
		double sin = Math.sin(angle - Math.PI / 2);
		return x * sin + y * cos;
	}

}
