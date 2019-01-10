package com.app.command.console;

import com.app.drawing.CoordinateUnit;
import com.app.drawing.console.Canvas;
import com.app.drawing.console.ConsoleColour;
import com.app.exception.ConsoleCommandException;
import com.app.utils.Constants.CoordinateUnitType;

public class LineDrawingCommandHandler extends DrawingCommandHandler {
	
	private final int requiredCommandParametersCount = 5;
	
	@Override
	public Canvas executeDrawingInstructions(String instruction, Canvas canvas) throws ConsoleCommandException {
		String[] instructionParameters = instruction.split(" ");
		int[]drawingcoordinates =  validateGeneralDrawingInstructions(instructionParameters, canvas, 1, 4);
		if(isValidLineDrawingInstructions(drawingcoordinates)) {
			CoordinateUnit[][] canvascoordinates = canvas.getCoordinates();
			int x1 = drawingcoordinates[0]<=drawingcoordinates[2]?drawingcoordinates[0]:drawingcoordinates[2];
			int x2 = drawingcoordinates[0]<=drawingcoordinates[2]?drawingcoordinates[2]:drawingcoordinates[0];
			int y1 = drawingcoordinates[1]<=drawingcoordinates[3]?drawingcoordinates[1]:drawingcoordinates[3];
			int y2 = drawingcoordinates[1]<=drawingcoordinates[3]?drawingcoordinates[3]:drawingcoordinates[1];
			
			for(int vertical=y1-1; vertical<y2; vertical++) {
	            for(int horizontal=x1-1; horizontal<x2; horizontal++) {
	                canvascoordinates[vertical][horizontal] = new CoordinateUnit(CoordinateUnitType.LINE, new ConsoleColour('x'));
	            }
	        }
		} else {
			throw new ConsoleCommandException("Command Error: only horizontal/vertical lines supported");
		}
		return canvas;
	}
	public int getRequiredCommandParametersCount() {
		return requiredCommandParametersCount;
	}
	
	private boolean isValidLineDrawingInstructions(int[]drawingcoordinates) {
		//ensure horizontal/vertical lines
		if(!(drawingcoordinates[0] == drawingcoordinates[2] || drawingcoordinates[1] == drawingcoordinates[3])) {
			return false;
		}
		return true;
	}
	
}
