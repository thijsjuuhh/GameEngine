package com.thijsjuuhh.GameEngine.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.thijsjuuhh.GameEngine.Update;
import com.thijsjuuhh.GameEngine.graphics.Render2D;
import com.thijsjuuhh.GameEngine.tile.Tile;

public abstract class Level implements Update {

	protected int width, height;
	protected String path;
	protected static Random r = new Random();

	protected int[] tiles;

	public Level(String path) {
		u.add(this);
		this.path = path;
		getPixels(path);
	}

	protected void getPixels(String path) {
		try {
			BufferedImage img = ImageIO.read(Level.class.getResource(path));
			width = img.getWidth();
			height = img.getHeight();
			tiles = new int[width * height];
			for (int y = 0; y < height; y++)
				for (int x = 0; x < width; x++)
					tiles[x + y * width] = img.getRGB(x, y);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("COULD NOT FIND LEVEL FILE!");
		}
	}

	public abstract void render(int xOffset, int yOffset, Render2D r);

	public abstract Tile getTile(int x, int y);

	public boolean isColliding(int x, int y, int size, int xOffs, int yOffs) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x - c % 2 * size + xOffs) >> 4;
			int yt = (y - c / 2 * size + yOffs) >> 4;
			if (getTile(xt, yt).isSolid())
				solid = true;
		}
		return solid;
	}

}
