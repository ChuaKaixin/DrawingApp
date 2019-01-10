package com.app.command.console;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.drawing.CoordinateUnit;
import com.app.drawing.console.Canvas;
import com.app.exception.ConsoleCommandException;
import com.app.utils.Helper;
import com.app.utils.Constants.CoordinateUnitType;

class TestConsoleHandler {
	private ConsoleHandler handler = new ConsoleHandler();
	@Test
	void testCanvasNotInitialized_Error() throws Exception {
		try {
			handler.executeCommand("B 1 1 B");
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Canvas need to be defined first before drawing", e.getMessage());
		}
	}
	
	@Test
	void testCanvasDoubleInitialized_Error() throws Exception{
		try {
			handler.executeCommand("C 10 10");
			handler.executeCommand("C 10 10");
		} catch(ConsoleCommandException e) {
			assertEquals("Command Error: Canvas has already been defined", e.getMessage());
		}
	}
	
	@Test
	void testCanvasDrawing() throws Exception {
		handler.executeCommand("C 10 10");
		Canvas canvas = handler.executeCommand("B 1 1 B");
		CoordinateUnit[][] canvasCoordinates = canvas.getCoordinates();
		for(int height = 0; height < canvasCoordinates.length; height++) {
			for(int width = 0; width < canvasCoordinates[0].length; width++) {
				assertTrue(Helper.checkCoordinateIsUpdated(canvas, width,height, 'B', CoordinateUnitType.COLOUR));
			}
		}
	}

}
