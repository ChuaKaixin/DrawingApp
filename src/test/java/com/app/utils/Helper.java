package com.app.utils;

import com.app.drawing.CoordinateUnit;
import com.app.drawing.console.Canvas;
import com.app.utils.Constants.CoordinateUnitType;

public class Helper {
	public static boolean checkCoordinateIsUpdated(Canvas canvas, int x, int y, char colour, CoordinateUnitType type) {
		CoordinateUnit[][] canvascoordinates = canvas.getCoordinates();
		CoordinateUnit coordinateToCheck = canvascoordinates[y][x];
		return coordinateToCheck!=null && coordinateToCheck.getType().equals(type) 
				&& coordinateToCheck.getColour().getColour().equals(colour);
	}
}
