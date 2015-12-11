package com.thijsjuuhh.GameEngine;

import java.awt.Canvas;

public class GEStartup extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private int width, height;
	private Thread t;
	private static int scale = 1;
	private String title;
	private boolean running = false;

	public GEStartup(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		t = new Thread(this, title);
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	public int getScaledWidth() {
		return width * scale;
	}

	public int getScaledHeight() {
		return height * height;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		t.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}

			if ((System.currentTimeMillis() - timer) > 1000) {
				System.out.println(updates + "ups + " + frames + "fps");
				updates = 0;
				frames = 0;
				timer += 1000;
			}

			render();
			frames++;
		}
		stop();
	}

	private void render() {
	}

	private void update() {
	}

}
