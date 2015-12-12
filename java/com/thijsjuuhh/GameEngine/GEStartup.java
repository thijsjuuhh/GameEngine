package com.thijsjuuhh.GameEngine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.thijsjuuhh.GameEngine.graphics.Render2D;

public class GEStartup extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int TIME = 0;

	private int width, height;
	private Thread t;
	private static int scale = 1;

	public static boolean moved = false;
	private String title;
	private boolean running = false;
	private Render2D render;
	private BufferedImage img;
	private int[] pixels;

	private static JFrame frame;

	public GEStartup(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		t = new Thread(this, title);

		frame = new JFrame();

		render = new Render2D(width, height);

		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

	}

	public String getTitle() {
		return title;
	}

	@Override
	public int getWidth() {
		return width;
	}

	protected void setScale(int s) {
		scale = s;
	}

	public int getScale() {
		return scale;
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

	public JFrame createWindow(boolean undecorated) {
		frame.setUndecorated(undecorated);
		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		return frame;
	}

	private void render() {
		BufferStrategy bs = frame.getBufferStrategy();
		if (bs == null) {
			frame.createBufferStrategy(3);
			return;
		}

		render.clear();

		for (Render r : Renderer.getToRender()) {
			r.render(render);
		}

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = render.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, width * scale, height * scale, null);
		g.dispose();
		bs.show();
	}

	private void update() {
		TIME++;
		if (TIME >= Integer.MAX_VALUE - 100)
			TIME = 0;
		for (Update u : Updater.getToUpdate())
			u.update();

	}

	public static void moveFrame(int x, int y) {
		if (moved) {
			frame.setLocation(x, y);
		}
	}

}
