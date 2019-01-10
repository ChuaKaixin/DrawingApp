package com.app.command.console;

import com.app.drawing.CoordinateUnit;
import com.app.drawing.console.Canvas;
import com.app.drawing.console.ConsoleColour;
import com.app.exception.ConsoleCommandException;
import com.app.utils.Constants.CoordinateUnitType;

public class BucketFillDrawingCommandHandler extends DrawingCommandHandler {
	private final int requiredCommandParametersCount = 4;
	
	@Override
	public Canvas executeDrawingInstructions(String instructions, Canvas canvas) throws Exception {
		String[] instructionParameters = instructions.split(" ");
		int[]drawingcoordinates =  validateGeneralDrawingInstructions(instructionParameters, canvas, 1, 2);
		
		if(isValidBucketFillDrawingInstructions(instructionParameters[3])) {
			CoordinateUnit[][] canvascoordinates = canvas.getCoordinates();
			bucketFill(instructionParameters[3].charAt(0), canvascoordinates, drawingcoordinates[0]-1, drawingcoordinates[1]-1);
		} else {
			throw new ConsoleCommandException("Command Error: Colour is expected to be a character");
		}
		return canvas;
	}

	public int getRequiredCommandParametersCount() {
		return requiredCommandParametersCount;
	}
	
	private void bucketFill(char colour, CoordinateUnit[][] canvascoordinates, int x, int y) {
		if(x>=0 && y>=0 && x < canvascoordinates[0].length && y < canvascoordinates.length) {
			CoordinateUnit coordinate = canvascoordinates[y][x];
			//colour only if the coordinate is undefined/not a line/is not the current colour
			if(coordinate==null || 
			(!coordinate.getType().equals(CoordinateUnitType.LINE) && !coordinate.getColour().getColour().equals(colour))) {
				CoordinateUnit newColour = new CoordinateUnit(CoordinateUnitType.COLOUR, new ConsoleColour(colour));
				canvascoordinates[y][x] = newColour;
				bucketFill(colour, canvascoordinates, x+1, y);
				bucketFill(colour, canvascoordinates, x-1, y);
				bucketFill(colour, canvascoordinates, x, y+1);
				bucketFill(colour, canvascoordinates, x, y-1);
				
			}
		}
	}

	private boolean isValidBucketFillDrawingInstructions(String colour) {
		return colour.length()==1;
	}

}
