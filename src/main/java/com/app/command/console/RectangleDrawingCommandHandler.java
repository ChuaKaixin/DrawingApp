package com.app.command.console;

import com.app.drawing.console.Canvas;

public class RectangleDrawingCommandHandler extends DrawingCommandHandler {
	
	private final int requiredCommandParametersCount = 5;
	
	@Override
	public Canvas executeDrawingInstructions(String instructions, Canvas canvas) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	public int getRequiredCommandParametersCount() {
		return requiredCommandParametersCount;
	}

}
