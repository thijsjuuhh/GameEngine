package com.thijsjuuhh.GameEngine;

public class GEStartup implements Runnable {

	private static int width, height;
	private Thread t;
	private static int scale = 1;
	private String title;
	private boolean running = false;

	public GEStartup(String title, int width, int height) {
		this.width = width;
		this.height = height;
		t = new Thread(this, title);
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		t.start();
	}

	public synchronized void srop() {
		if (!running)
			return;
		running = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double delta = 0;
		double ns = 1000000000.0 / 60.0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(TITLE + " | " + updates + " ups " + frames + " fps");
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}

		}
	}

}
