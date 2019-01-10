package com.app.drawing.console;

import com.app.drawing.CoordinateUnit;
import com.app.drawing.Renderer;

public class ConsoleRenderer implements Renderer {

	@Override
	public void renderDrawing(CoordinateUnit[][] coordinates) {
		StringBuilder drawing = new StringBuilder();
		drawing.append(generateWidthString(coordinates[0].length));
		drawing.append(generateDrawingContent(coordinates));
		drawing.append(generateWidthString(coordinates[0].length));
		System.out.print(drawing.toString());
	}
	
	private String generateWidthString(int widthLen) {
		StringBuilder returnStr = new StringBuilder();
		for(int index = 0; index <= widthLen+1; index++) {
			returnStr.append('-');
		}
		returnStr.append("\n");
		return returnStr.toString();
	}
	
	private String generateDrawingContent(CoordinateUnit[][] coordinates) {
		StringBuilder returnStr = new StringBuilder();
		for(CoordinateUnit[] rowCoordinates : coordinates) {
			returnStr.append('|');
			for(CoordinateUnit coordinate : rowCoordinates) {
				if(coordinate==null) {
					returnStr.append(" ");
				} else {
					returnStr.append(coordinate.getColour().getColour());
				}
			}
			returnStr.append("|\n");
			
		}
		return returnStr.toString();
	}
	
}
