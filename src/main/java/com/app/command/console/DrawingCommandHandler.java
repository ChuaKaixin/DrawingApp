package com.app.command.console;

import com.app.drawing.CoordinateUnit;
import com.app.drawing.console.Canvas;
import com.app.exception.ConsoleCommandException;
import com.app.exception.IntegerConversionException;
import com.app.utils.Utils;

public abstract class DrawingCommandHandler {
	public abstract Canvas executeDrawingInstructions(String instructions, Canvas canvas) throws Exception; 
	
	abstract int getRequiredCommandParametersCount();
	
	int[] validateGeneralDrawingInstructions(String[] instructions, Canvas canvas, int intStartIndex, int intEndIndex) throws ConsoleCommandException {
		int[]drawingcoordinates = null;
		//ensure canvas is defined already before drawing
		if(canvas==null) {
			throw new ConsoleCommandException("Command Error: Canvas need to be defined first before drawing");
		} else {
			//ensure instruction length is as expected
			if(instructions.length != getRequiredCommandParametersCount()) {
				throw new ConsoleCommandException("Command Error: Invalid command");
			} else {
				//ensure integer instructions are provided
				try {
					drawingcoordinates = Utils.convertStringsToIntArray(instructions, intStartIndex, intEndIndex);
					//ensure coordinates are within the boundaries of the canvas
					CoordinateUnit[][] canvascoordinates = canvas.getCoordinates();
					for(int coordinateIndex=0; coordinateIndex<drawingcoordinates.length; coordinateIndex++) {
						if(drawingcoordinates[coordinateIndex]<1) {
							throw new ConsoleCommandException("Command Error: drawing coordinates are beyond canvas");
						} else if(coordinateIndex%2==0) {
							if(drawingcoordinates[coordinateIndex] > canvascoordinates[0].length) {
								throw new ConsoleCommandException("Command Error: drawing coordinates are beyond canvas");
							} 
						} else {
							if(drawingcoordinates[coordinateIndex] > canvascoordinates.length) {
								throw new ConsoleCommandException("Command Error: drawing coordinates are beyond canvas");
							} 
						}
					}
				} catch (IntegerConversionException e) {
					throw new ConsoleCommandException(e.getMessage());
				}
			}
		}
		return drawingcoordinates;
	}
}
