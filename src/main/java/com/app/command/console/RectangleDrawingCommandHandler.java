package com.app.command.console;

import com.app.drawing.CoordinateUnit;
import com.app.drawing.console.Canvas;
import com.app.drawing.console.ConsoleColour;
import com.app.exception.ConsoleCommandException;
import com.app.utils.Constants.CoordinateUnitType;

public class RectangleDrawingCommandHandler extends DrawingCommandHandler {
	
	private final int requiredCommandParametersCount = 5;
	
	@Override
	public Canvas executeDrawingInstructions(String instructions, Canvas canvas) throws ConsoleCommandException{
		String[] instructionParameters = instructions.split(" ");
		int[]drawingcoordinates =  validateGeneralDrawingInstructions(instructionParameters, canvas, 1, 4);
		if(isValidRectangleDrawingInstructions(drawingcoordinates)) {
			CoordinateUnit[][] canvascoordinates = canvas.getCoordinates();
			/**
			 * x1y1---x2y2
			 * |		|
			 * x4y4---x3y3	
			 */
			int x1 = drawingcoordinates[0];
			int y1 = drawingcoordinates[1];
			int x2 = drawingcoordinates[2];
			int y2 = drawingcoordinates[1];
			int x3 = drawingcoordinates[2];
			int y3 = drawingcoordinates[3];
			int x4 = drawingcoordinates[1];
			int y4 = drawingcoordinates[3];
			
			drawSide(x1, y1, x2, y2, canvascoordinates);
			drawSide(x2, y2, x3, y3, canvascoordinates);
			drawSide(x4, y4, x3, y3, canvascoordinates);
			drawSide(x1, y1, x4, y4, canvascoordinates);
		} else {
			throw new ConsoleCommandException("Command Error: Expected coordinates for top left and bottom right of rectangle");
		}
		return canvas;
	}

	public int getRequiredCommandParametersCount() {
		return requiredCommandParametersCount;
	}
	
	private void drawSide(int xstart, int ystart, int xend, int yend, CoordinateUnit[][] canvascoordinates) {
		for(int vertical=ystart-1; vertical<yend; vertical++) {
            for(int horizontal=xstart-1; horizontal<xend; horizontal++) {
                canvascoordinates[vertical][horizontal] = new CoordinateUnit(CoordinateUnitType.LINE, new ConsoleColour('x'));
            }
        }
	}
	
	private boolean isValidRectangleDrawingInstructions(int[]drawingcoordinates) {
		//ensure top left and bottom right coordinates are valid
		if(!(drawingcoordinates[0] < drawingcoordinates[2] && drawingcoordinates[1] < drawingcoordinates[3])) {
			return false;
		}
		return true;
	}

}
