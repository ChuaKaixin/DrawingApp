package com.app.drawing.console;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.command.console.DrawingCommandHandler;
import com.app.command.console.RectangleDrawingCommandHandler;
import com.app.drawing.CoordinateUnit;
import com.app.exception.ConsoleCommandException;
import com.app.utils.Constants.CoordinateUnitType;
import com.app.utils.Helper;

class TestRectangleDrawingCommandHandler {
	
	private DrawingCommandHandler commandHandler = new RectangleDrawingCommandHandler();
	
	@Test
	void testRecDrawingCommandInvalid_Only3IntegersProvided() throws Exception {
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("R 1 2 3", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Invalid command", e.getMessage());
		}
	}
	
	
	@Test
	void testRecDrawingCommandInvalid_NonIntegerProvided() throws Exception{
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("R 1 2 3 A", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Command instructions is invalid", e.getMessage());
		}
	}
	
	@Test
	void testRecDrawingCommandInvalid_BeyondCanvasBoundary() throws Exception {
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("R 1 2 3 100", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: drawing coordinates are beyond canvas", e.getMessage());
		}
	}
	
	@Test
	void testRecDrawingCommandInvalid_TopLeftBottomRightCoordinatesIncorrect() throws Exception {
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("R 10 10 5 5", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Expected coordinates for top left and bottom right of rectangle", e.getMessage());
		}
	}
	
	@Test
	void testRecDrawing_CorrectCommand() throws Exception{
		Canvas canvas = new Canvas(10, 10);
		canvas = commandHandler.executeDrawingInstructions("R 1 1 3 3", canvas);
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 0,0, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,0, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 2,0, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 2,1, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 2,2, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,2, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 0,2, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 0,1, 'x', CoordinateUnitType.LINE));
	}
	

}
