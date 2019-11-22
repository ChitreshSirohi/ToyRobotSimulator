package com.game.simulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RobotTest {

	@Test
	void verifyExecuteCommand() {
		final Robot robot = new Robot();
		robot.executeCommand("PLACE 0,0,NORTHR");
		assertNull(robot.getPosition());
		robot.executeCommand("PLACE 0,5,NORTH");
		assertNull(robot.getPosition());
		robot.executeCommand("MOVE");
		assertNull(robot.getPosition());
		robot.executeCommand(" plaCe   0  ,  0  ,   north  ");
		assertNotNull(robot.getPosition());
		robot.executeCommand("MOVE");
		assertEquals("0,1,NORTH", robot.getPosition().getStringFormat());
		robot.executeCommand("LEFT");
		assertEquals("0,1,WEST", robot.getPosition().getStringFormat());
		robot.executeCommand("RIGHT");
		assertEquals("0,1,NORTH", robot.getPosition().getStringFormat());
		robot.executeCommand("RIGHT");
		assertEquals("0,1,EAST", robot.getPosition().getStringFormat());
		robot.executeCommand("RIGHT");
		robot.executeCommand("MOVE");
		assertEquals("0,0,SOUTH", robot.getPosition().getStringFormat());
		robot.executeCommand("MOVE"); // This command should not be executed, will pushover the edge
		assertEquals("0,0,SOUTH", robot.getPosition().getStringFormat());
		robot.executeCommand("RIGHT");
		assertEquals("0,0,WEST", robot.getPosition().getStringFormat());
		robot.executeCommand("MOVE");
		assertEquals("0,0,WEST", robot.getPosition().getStringFormat());
		robot.executeCommand("PLACE 3,0,EAST");
		robot.executeCommand("MOVE");
		assertEquals("4,0,EAST", robot.getPosition().getStringFormat()); // At the edge of table top
		robot.executeCommand("MOVE");
		assertEquals("4,0,EAST", robot.getPosition().getStringFormat());
		robot.executeCommand("PLACE 5,0,NORTH"); // Out of table position
		assertEquals("4,0,EAST", robot.getPosition().getStringFormat());
		robot.executeCommand("PLACE 4,0,WEST");
		robot.executeCommand("MOVE");
		robot.executeCommand("    ");
		assertEquals("3,0,WEST", robot.getPosition().getStringFormat());
	}
}