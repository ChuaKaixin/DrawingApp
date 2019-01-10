package com.app.command.console;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.drawing.console.Canvas;
import com.app.exception.ConsoleCommandException;
import com.app.utils.Constants.CoordinateUnitType;
import com.app.utils.Helper;
import com.app.command.console.DrawingCommandHandler;
import com.app.command.console.LineDrawingCommandHandler;

class TestLineDrawingCommandHandler {

	private DrawingCommandHandler commandHandler = new LineDrawingCommandHandler();
	
	@Test
	void testLineDrawingCommandInvalid_Only3IntegersProvided() throws Exception {
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("L 1 2 3", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Invalid command", e.getMessage());
		}
	}
	
	
	@Test
	void testLineDrawingCommandInvalid_NonIntegerProvided() throws Exception{
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("L 1 2 3 A", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Command instructions is invalid", e.getMessage());
		}
	}
	
	@Test
	void testLineDrawingCommandInvalid_BeyondCanvasBoundary() throws Exception {
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("L 1 2 3 100", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: drawing coordinates are beyond canvas", e.getMessage());
		}
	}
	
	
	@Test
	void testLineDrawingCommandInvalid_NonHorizontalVerticalLine() throws Exception{
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("L 1 2 3 8", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: only horizontal/vertical lines supported", e.getMessage());
		}
	}
	@Test
	void testLineDrawing_HorizontalLineLeftToRight() throws Exception{
		Canvas canvas = new Canvas(10, 10);
		canvas = commandHandler.executeDrawingInstructions("L 1 1 3 1", canvas);
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 0,0, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,0, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 2,0, 'x', CoordinateUnitType.LINE));
	}
	
	@Test
	void testLineDrawing_VerticalLineTopToBottom() throws Exception{
		Canvas canvas = new Canvas(10, 10);
		canvas = commandHandler.executeDrawingInstructions("L 2 1 2 5", canvas);
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,0, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,1, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,2, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,3, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,4, 'x', CoordinateUnitType.LINE));
	}
	
	@Test
	void testLineDrawing_Dot() throws Exception{
		Canvas canvas = new Canvas(10, 10);
		canvas = commandHandler.executeDrawingInstructions("L 2 2 2 2", canvas);
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,1, 'x', CoordinateUnitType.LINE));
	}
	
	@Test
	void testLineDrawing_HorizontalLineRightToLeft() throws Exception{
		Canvas canvas = new Canvas(10, 10);
		canvas = commandHandler.executeDrawingInstructions("L 3 1 1 1", canvas);
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 0,0, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,0, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 2,0, 'x', CoordinateUnitType.LINE));
	}
	
	@Test
	void testLineDrawing_VerticalLineBottomToTop() throws Exception{
		Canvas canvas = new Canvas(10, 10);
		canvas = commandHandler.executeDrawingInstructions("L 2 5 2 1", canvas);
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,0, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,1, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,2, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,3, 'x', CoordinateUnitType.LINE));
		assertTrue(Helper.checkCoordinateIsUpdated(canvas, 1,4, 'x', CoordinateUnitType.LINE));
	}
	

}
