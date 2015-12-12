package com.thijsjuuhh.GameEngine.entities.projectiles;

import com.thijsjuuhh.GameEngine.GEStartup;
import com.thijsjuuhh.GameEngine.Render;
import com.thijsjuuhh.GameEngine.Update;

public abstract class Projectile implements Update, Render {

	protected final double speed;
	protected final int firerate;
	protected boolean activated = false, canShoot = true;;
	protected int time;
	protected double angle;

	public Projectile(double speed, int firerate) {
		this.speed = speed;
		this.firerate = firerate;
	}

	public void activate(double angle) {
		if (activated)
			return;
		this.angle = angle;
		activated = true;
	}

	public void cooldown() {
		if (canShoot)
			return;
		int start = GEStartup.TIME;
		int end = start + firerate;
		while (start < end)
			start++;
		canShoot = true;
	}

}
