package com.app.command.console;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.command.console.BucketFillDrawingCommandHandler;
import com.app.command.console.DrawingCommandHandler;
import com.app.drawing.CoordinateUnit;
import com.app.drawing.console.Canvas;
import com.app.drawing.console.ConsoleColour;
import com.app.utils.Constants.CoordinateUnitType;
import com.app.exception.ConsoleCommandException;
import com.app.utils.Helper;

class TestBucketFillDrawingCommandHandler {


	private DrawingCommandHandler commandHandler = new BucketFillDrawingCommandHandler();
	
	@Test
	void testBucketFillDrawingCommandInvalid_Only1IntegerProvided() throws Exception {
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("B 1 A", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Invalid command", e.getMessage());
		}
	}
	
	
	@Test
	void testBucketFillDrawingCommandInvalid_NonIntegerProvided() throws Exception{
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("B 1 A A", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Command instructions is invalid", e.getMessage());
		}
	}
	
	@Test
	void testBucketFillDrawingCommandInvalid_BeyondCanvasBoundary() throws Exception {
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("B 100 100 B", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: drawing coordinates are beyond canvas", e.getMessage());
		}
	}
	
	@Test
	void testBucketFillDrawingCommandInvalid_ColourProvidedIsNotChar() throws Exception {
		try {
			Canvas canvas = new Canvas(10, 10);
			commandHandler.executeDrawingInstructions("B 10 10 BA", canvas);
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Colour is expected to be a character", e.getMessage());
		}
	}
	
	
	@Test
	void testBucketFillDrawing_FillWholeCanvas() throws Exception {
		Canvas canvas = new Canvas(2, 2);
		canvas = commandHandler.executeDrawingInstructions("B 1 1 B", canvas);
		CoordinateUnit[][] canvasCoordinates = canvas.getCoordinates();
		for(int height = 0; height < canvasCoordinates.length; height++) {
			for(int width = 0; width < canvasCoordinates[0].length; width++) {
				assertTrue(Helper.checkCoordinateIsUpdated(canvas, width,height, 'B', CoordinateUnitType.COLOUR));
			}
		}
	}
	
	@Test
	void testBucketFillDrawing_FillWholeCanvasReplaceColour() throws Exception {
		Canvas canvas = new Canvas(2, 2);
		CoordinateUnit[][] canvasCoordinates = canvas.getCoordinates();
		canvas = commandHandler.executeDrawingInstructions("B 1 1 B", canvas);
		for(int height = 0; height < canvasCoordinates.length; height++) {
			for(int width = 0; width < canvasCoordinates[0].length; width++) {
				assertTrue(Helper.checkCoordinateIsUpdated(canvas, width,height, 'B', CoordinateUnitType.COLOUR));
			}
		}

		canvas = commandHandler.executeDrawingInstructions("B 1 1 T", canvas);
		for(int height = 0; height < canvasCoordinates.length; height++) {
			for(int width = 0; width < canvasCoordinates[0].length; width++) {
				assertTrue(Helper.checkCoordinateIsUpdated(canvas, width,height, 'T', CoordinateUnitType.COLOUR));
			}
		}
	}
	
	@Test
	void testBucketFillDrawing_ColourIgnoreLines() throws Exception {
		Canvas canvas = new Canvas(3, 3);
		CoordinateUnit[][] canvasCoordinates = canvas.getCoordinates();
		canvasCoordinates[1][1] = new CoordinateUnit(CoordinateUnitType.LINE, new ConsoleColour('x'));
		
		canvas = commandHandler.executeDrawingInstructions("B 1 1 B", canvas);
		for(int height = 0; height < canvasCoordinates.length; height++) {
			for(int width = 0; width < canvasCoordinates[0].length; width++) {
				if(height==1 && width==1) {
					assertTrue(Helper.checkCoordinateIsUpdated(canvas, width,height, 'x', CoordinateUnitType.LINE));
				}
				else
					assertTrue(Helper.checkCoordinateIsUpdated(canvas, width,height, 'B', CoordinateUnitType.COLOUR));
			}
		}
	}
	
}
