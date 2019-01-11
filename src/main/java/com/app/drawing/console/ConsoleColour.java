package com.app.drawing.console;

import com.app.drawing.Colour;

public class ConsoleColour implements Colour<Character>{
	private char charColour;
	
	public ConsoleColour(char charColour) {
		this.charColour = charColour;
	}

	public void setCharColour(char charColour) {
		this.charColour = charColour;
	}

	@Override
	public Character getColour() {
		return charColour;
	}
	
	
}
