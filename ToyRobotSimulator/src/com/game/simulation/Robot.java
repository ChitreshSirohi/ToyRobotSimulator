package com.game.simulation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Robot {
	private Position position;

	public void executeCommand(final String commandInput) {
		// Change toUppercase,remove spaces and get tokens from the command
		final String command = commandInput.trim().toUpperCase();
		if (command.isEmpty()) {
			return;
		}
		final List<String> tokens = Arrays.stream(command.split(",")).map(String::trim).collect(Collectors.toList());

		if (tokens.size() > 1) {
			executePlace(tokens);
		} else if (position != null) {
			final Command commandEnum = Command.valueOf(command);
			switch (commandEnum) {
			case LEFT:
				position.setDirection(getNewDirection(Command.LEFT));
				break;
			case RIGHT:
				position.setDirection(getNewDirection(Command.RIGHT));
				break;
			case MOVE:
				executeMove();
				break;
			case REPORT:
				output(position.getStringFormat());
				break;
			default:
				break;
			}
		}
	}

	private void output(final String string) {
		System.out.println(string);
	}

	private void executeMove() {
		if (position == null) {
			return;
		}
		final Position newPostion = new Position(position.getRow(), position.getCol(), position.getDirection());
		switch (position.getDirection()) {
		case EAST:
			newPostion.setRow(position.getRow() + 1);
			break;
		case WEST:
			newPostion.setRow(position.getRow() - 1);
			break;
		case NORTH:
			newPostion.setCol(position.getCol() + 1);
			break;
		case SOUTH:
			newPostion.setCol(position.getCol() - 1);
			break;
		}
		position = TableTop.isWithinBoundary(newPostion) ? newPostion : position;
	}

	private Direction getNewDirection(final Command command) {
		final List<Direction> values = Arrays.asList(Direction.values());
		final int oldIndex = values.indexOf(position.getDirection());
		if (Command.LEFT.equals(command)) {
			return oldIndex == 0 ? values.get(values.size() - 1) : values.get(oldIndex - 1);
		}
		if (Command.RIGHT.equals(command)) {
			return oldIndex == (values.size() - 1) ? values.get(0) : values.get(oldIndex + 1);
		}
		return position.getDirection();
	}

	private void executePlace(final List<String> tokens) {
		if ((tokens.size() == 3) && tokens.get(0).startsWith(Command.PLACE.name())) {
			try {
				final Direction direction = Direction.valueOf(tokens.get(2));
				final int row = Integer.parseInt(tokens.get(0).substring(Command.PLACE.name().length()).trim());
				final int col = Integer.parseInt(tokens.get(1));
				final Position position = new Position(row, col, direction);
				this.position = TableTop.isWithinBoundary(position) ? position : this.position;
			} catch (final IllegalArgumentException ignored) {
			}
		}
	}

	public Position getPosition() {
		return position;
	}

}
