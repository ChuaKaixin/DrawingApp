package com.app.command.console;

import java.util.HashMap;
import java.util.Map;

import com.app.command.Handler;
import com.app.drawing.Colour;
import com.app.drawing.console.Canvas;
import com.app.exception.ConsoleCommandException;

public class ConsoleHandler implements Handler {
	
	private Canvas canvas;
	
	private Map<Character, DrawingCommandHandler> handlers; 
	public ConsoleHandler() {
		handlers = new HashMap<>();
		handlers.put('C', new CanvasDrawingCommandHandler());
		handlers.put('R', new RectangleDrawingCommandHandler());
		handlers.put('L', new LineDrawingCommandHandler());
		handlers.put('B', new BucketFillDrawingCommandHandler());
	}
	
	@Override
	public Canvas executeCommand(String command) throws Exception {
		if(command==null || command.length()<1) {
			throw new ConsoleCommandException("Program expects command parameter C/R/L/B/Q");
		} else {
			char commandType = command.charAt(0);
			switch(commandType) {
			case 'Q':
				break;
			case 'C': case 'R': case 'L': case 'B':
				canvas = handlers.get(commandType).executeDrawingInstructions(command, canvas);
				break;
			default:
				throw new ConsoleCommandException("Program expects command parameter C/R/L/B/Q");
			}
		}
		return canvas;
	}
	
	
	

}
