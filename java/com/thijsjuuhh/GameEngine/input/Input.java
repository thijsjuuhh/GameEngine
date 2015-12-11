package com.thijsjuuhh.GameEngine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.thijsjuuhh.GameEngine.GEStartup;

public class Input implements MouseListener, MouseMotionListener, KeyListener {

	static boolean[] keys = new boolean[10000];
	static boolean left = false, right = false, middle = false;

	static boolean scrollUp = false;
	static boolean scrollDown = false;

	static int x = 0, y = 0;

	private int startX = 0, startY = 0;
	private static boolean start = false;

	static int i = 0;

	private static int instances = 0;

	public Input() {
		if (instances == 0)
			new Keys();
		instances++;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if (Keys.right_click) {
			GEStartup.moved = true;

			if (!start) {
				startX = e.getX();
				startY = e.getY();
				start = true;
			}
			if (start) {
				GEStartup.moveFrame(e.getXOnScreen() - startX, e.getYOnScreen() - startY);
			}
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		switch (e.getButton()) {
		case 1:
			left = true;
			break;
		case 2:
			middle = true;
			break;
		case 3:
			right = true;
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		start = false;
		startX = 0;
		startY = 0;
		switch (e.getButton()) {
		case 1:
			left = false;
			break;
		case 2:
			middle = false;
			break;
		case 3:
			right = false;
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}