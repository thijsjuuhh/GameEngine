package com.thijsjuuhh.GameEngine.mob;

import com.thijsjuuhh.GameEngine.Render;
import com.thijsjuuhh.GameEngine.Update;
import com.thijsjuuhh.GameEngine.entities.projectiles.Projectile;
import com.thijsjuuhh.GameEngine.entity.Entity;
import com.thijsjuuhh.GameEngine.graphics.Sprite;

public abstract class Mob extends Entity implements Render, Update {

	protected Sprite s;
	protected Direction dir;

	protected enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}

	public Mob(String unlocalizedName, int x, int y, Sprite s) {
		super(unlocalizedName, x, y);
		this.s = s;
		r.add(this);
		u.add(this);
	}

	public void move(int xa, int ya) {
		if (xa > 0)
			dir = Direction.RIGHT;
		if (xa < 0)
			dir = Direction.LEFT;
		if (ya > 0)
			dir = Direction.DOWN;
		if (ya < 0)
			dir = Direction.UP;

		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		while (xa != 0) {
			if (Math.abs(xa) > 1) {
				if (!isColliding(abs(xa), ya))
					this.x += abs(xa);
				xa -= abs(xa);
			} else {
				if (!isColliding(abs(xa), ya))
					this.x += xa;
				xa = 0;
			}
		}

		while (ya != 0) {
			if (Math.abs(ya) > 1) {
				if (!isColliding(xa, abs(ya)))
					this.y += abs(ya);
				ya -= abs(ya);
			} else {
				if (!isColliding(xa, abs(ya))) {
					this.y += ya;
				}
				ya = 0;
			}
		}
	}

	private int abs(double value) {
		if (value < 0)
			return -1;
		return 1;
	}

	protected void shoot(double xt, double yt, Projectile p) {
		double angle = Math.sqrt((xt * xt) + (yt + yt));
		p.activate(angle);
	}

	protected boolean isColliding(double xa, double ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			double xt = ((x + xa) - c % 2 * 15) / 16;
			double yt = ((y + ya) - c / 2 * 15) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (c % 2 == 0)
				ix = (int) Math.floor(xt);
			if (c / 2 == 0)
				iy = (int) Math.floor(yt);

			if (l.getTile(ix, iy).isSolid())
				solid = true;
		}
		return solid;
	}
}
