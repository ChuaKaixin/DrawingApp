package com.app.command.console;

import com.app.drawing.console.Canvas;
import com.app.exception.CanvasException;
import com.app.exception.ConsoleCommandException;
import com.app.exception.IntegerConversionException;
import com.app.utils.Utils;

public class CanvasDrawingCommandHandler extends DrawingCommandHandler {

	private final int requiredCommandParametersCount = 3;
	
	@Override
	public Canvas executeDrawingInstructions(String instruction, Canvas canvas) throws ConsoleCommandException {
		Canvas newcanvas = canvas;
		if(canvas!=null) {
			throw new ConsoleCommandException("Command Error: Canvas has already been defined");
		}
		else {
		String[] instructionParameters = instruction.split(" ");
		int[] canvasWidthHeight = isValidCanvasInstructions(instructionParameters);
		try {
			newcanvas = new Canvas(canvasWidthHeight[0], canvasWidthHeight[1]);
		} catch (CanvasException e) {
			throw new ConsoleCommandException("Command Error: " + e.getMessage());
		}
		return newcanvas;
		}
	}

	public int getRequiredCommandParametersCount() {
		return requiredCommandParametersCount;
	}
	
	private int[] isValidCanvasInstructions(String[] instructions) throws ConsoleCommandException {
		int[]canvasWidthHeight = null;
		try {
			canvasWidthHeight = Utils.convertStringsToIntArray(instructions, 1, 2);
		} catch (IntegerConversionException e) {
			throw new ConsoleCommandException(e.getMessage());
		}
		return canvasWidthHeight;
	}

}
