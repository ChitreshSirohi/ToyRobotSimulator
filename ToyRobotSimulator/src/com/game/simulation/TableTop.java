package com.game.simulation;

class TableTop {
	private static final byte rows = 5;
	private static final byte cols = 5;

	static boolean isWithinBoundary(final Position position) {
		if ((position.getRow() < 0) || (position.getCol() < 0)) {
			return false;
		} else {
			return (position.getRow() < rows) && (position.getCol() < cols);
		}
	}
}
