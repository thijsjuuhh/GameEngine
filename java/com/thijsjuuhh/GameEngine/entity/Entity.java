package com.thijsjuuhh.GameEngine.entity;

import com.thijsjuuhh.GameEngine.level.Level;

public class Entity {

	protected int x, y;
	protected Level l;
	protected String unlocalizedName;
	protected boolean removed;

	public Entity(String unlocalizedName, int x, int y) {
		this.x = x;
		this.y = y;
		this.unlocalizedName = unlocalizedName;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isRemoved() {
		return removed;
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}

	public void init(Level l) {
		this.l = l;
	}

}
