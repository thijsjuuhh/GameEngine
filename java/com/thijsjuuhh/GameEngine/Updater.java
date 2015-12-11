package com.thijsjuuhh.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class Updater {
	private static List<Update> toUpdate = new ArrayList<Update>();

	Updater() {
	}

	public void add(Update toAdd) {
		toUpdate.add(toAdd);
	}

	static List<Update> getToUpdate() {
		return toUpdate;
	}
}
