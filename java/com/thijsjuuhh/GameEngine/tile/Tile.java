package com.thijsjuuhh.GameEngine.tile;

import java.util.ArrayList;
import java.util.List;

import com.thijsjuuhh.GameEngine.Update;
import com.thijsjuuhh.GameEngine.graphics.Render2D;
import com.thijsjuuhh.GameEngine.graphics.Sprite;

public abstract class Tile implements Update {

	protected String unlocalizedName;
	protected Sprite sprite;
	public static List<Tile> tiles = new ArrayList<Tile>();
	private final int mapCol;

	public Tile(String unlocalizedName, Sprite s, int mapCol) {
		u.add(this);
		this.unlocalizedName = "tile:" + unlocalizedName;
		sprite = s;
		this.mapCol = mapCol;
		tiles.add(this);
	}

	public int getMapCol() {
		return mapCol;
	}

	public abstract void render(int x, int y, Render2D r);

	public abstract boolean isSolid();

	public abstract boolean isMineable();

}
