package com.game.simulation;

class Position {
	private int row;
	private int col;
	private Direction direction;

	Position(final int row, final int col, final Direction direction) {
		this.row = row;
		this.col = col;
		this.direction = direction;
	}

	int getRow() {
		return row;
	}

	int getCol() {
		return col;
	}

	Direction getDirection() {
		return direction;
	}

	void setRow(final int row) {
		this.row = row;
	}

	void setCol(final int col) {
		this.col = col;
	}

	void setDirection(final Direction direction) {
		this.direction = direction;
	}

	String getStringFormat() {
		return String.format("%s,%s,%s", this.row, this.col, this.direction);
	}
}
