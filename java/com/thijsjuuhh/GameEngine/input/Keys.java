package com.thijsjuuhh.GameEngine.input;

import java.awt.event.KeyEvent;

import com.thijsjuuhh.GameEngine.Update;

public class Keys implements Update {

	private static boolean[] keys = Input.keys;

	public Keys() {
		u.add(this);
	}

	public static boolean UP;
	public static boolean DOWN;
	public static boolean LEFT;
	public static boolean RIGHT;

	public static boolean A;
	public static boolean B;
	public static boolean C;
	public static boolean D;
	public static boolean E;
	public static boolean F;
	public static boolean G;
	public static boolean H;
	public static boolean I;
	public static boolean J;
	public static boolean K;
	public static boolean L;
	public static boolean M;
	public static boolean N;
	public static boolean O;
	public static boolean P;
	public static boolean Q;
	public static boolean R;
	public static boolean S;
	public static boolean T;
	public static boolean U;
	public static boolean V;
	public static boolean W;
	public static boolean X;
	public static boolean Y;
	public static boolean Z;
	public static boolean SHIFT;
	public static boolean ESCAPE;
	public static boolean CONTROL;
	public static boolean BACK;

	public static boolean left_click;
	public static boolean right_click;
	public static boolean middle_click;
	public static int mouseX;
	public static int mouseY;
	public static boolean ScrollUp;
	public static boolean ScrollDown;

	@Override
	public void update() {
		UP = keys[KeyEvent.VK_UP];
		DOWN = keys[KeyEvent.VK_DOWN];
		LEFT = keys[KeyEvent.VK_LEFT];
		RIGHT = keys[KeyEvent.VK_RIGHT];

		A = keys[KeyEvent.VK_A];
		B = keys[KeyEvent.VK_B];
		C = keys[KeyEvent.VK_C];
		D = keys[KeyEvent.VK_D];
		E = keys[KeyEvent.VK_E];
		F = keys[KeyEvent.VK_F];
		G = keys[KeyEvent.VK_G];
		H = keys[KeyEvent.VK_H];
		I = keys[KeyEvent.VK_I];
		J = keys[KeyEvent.VK_J];
		K = keys[KeyEvent.VK_K];
		L = keys[KeyEvent.VK_L];
		M = keys[KeyEvent.VK_M];
		N = keys[KeyEvent.VK_N];
		O = keys[KeyEvent.VK_O];
		P = keys[KeyEvent.VK_P];
		Q = keys[KeyEvent.VK_Q];
		R = keys[KeyEvent.VK_R];
		S = keys[KeyEvent.VK_S];
		T = keys[KeyEvent.VK_T];
		U = keys[KeyEvent.VK_U];
		V = keys[KeyEvent.VK_V];
		W = keys[KeyEvent.VK_W];
		X = keys[KeyEvent.VK_X];
		Y = keys[KeyEvent.VK_Y];
		Z = keys[KeyEvent.VK_Z];
		SHIFT = keys[KeyEvent.VK_SHIFT];
		CONTROL = keys[KeyEvent.VK_CONTROL];
		ESCAPE = keys[KeyEvent.VK_ESCAPE];
		BACK = keys[KeyEvent.VK_BACK_SPACE];

		left_click = Input.left;
		right_click = Input.right;
		middle_click = Input.middle;
		mouseX = Input.x;
		mouseY = Input.y;

		ScrollDown = Input.scrollDown;
		ScrollUp = Input.scrollUp;
	}
}
