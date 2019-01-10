package com.app.drawing.console;

import com.app.drawing.CoordinateUnit;
import com.app.exception.CanvasException;

public class Canvas {
	private CoordinateUnit[][] coordinates;
	
	public Canvas(int width, int height) throws CanvasException {
		if(width < 1 || height < 1) {
			throw new CanvasException("Canvas width and height must be positive integers");
		} else {
			coordinates = new CoordinateUnit[height][width];
		}
	}

	public CoordinateUnit[][] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(CoordinateUnit[][] coordinates) {
		this.coordinates = coordinates;
	}
	
	
}
