package com.thijsjuuhh.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class Renderer {

	private static List<Render> toRender = new ArrayList<Render>();

	Renderer() {
	}

	public void add(Render toAdd) {
		toRender.add(toAdd);
	}

	static List<Render> getToRender() {
		return toRender;
	}

}
