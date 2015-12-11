package com.thijsjuuhh.GameEngine;

import java.util.Random;

import com.thijsjuuhh.GameEngine.graphics.SpriteSheet;

public abstract class Level implements Update {

	protected int width, height;
	protected SpriteSheet s;
	protected static Random r = new Random();

	public Level(int width, int height, SpriteSheet s) {
		this.width = width;
		this.height = height;
		this.s = s;
	}

}
