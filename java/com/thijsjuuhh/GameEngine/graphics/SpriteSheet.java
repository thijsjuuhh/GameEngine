package com.thijsjuuhh.GameEngine.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private int width, height;
	private String path;
	public int[] pixels;

	public SpriteSheet(String path) {
		this.path = path;
		load();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void load() {
		try {
			System.out.print("Loading : " + path + " ... ");
			BufferedImage i = ImageIO.read(SpriteSheet.class.getResource(path));
			System.out.println(" Succeeded!");
			width = i.getWidth();
			height = i.getHeight();
			pixels = new int[width * height];
			i.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(" FAILED!");
		}
	}

}
