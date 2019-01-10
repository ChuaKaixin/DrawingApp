package com.app.drawing;

import com.app.drawing.console.ConsoleColour;
import com.app.utils.Constants.CoordinateUnitType;

public class CoordinateUnit {
	private CoordinateUnitType type;
	private ConsoleColour colour;
	
	public CoordinateUnit(CoordinateUnitType type, ConsoleColour colour) {
		this.type = type;
		this.colour = colour;
	}

	public CoordinateUnitType getType() {
		return type;
	}

	public void setType(CoordinateUnitType type) {
		this.type = type;
	}

	public ConsoleColour getColour() {
		return colour;
	}

	public void setColour(ConsoleColour colour) {
		this.colour = colour;
	}
	
}
