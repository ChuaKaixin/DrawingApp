package com.app.command.console;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.command.Handler;
import com.app.drawing.Renderer;
import com.app.drawing.console.Canvas;
import com.app.drawing.console.ConsoleRenderer;
import com.app.exception.ConsoleCommandException;

public class ConsoleHandler implements Handler {
	
	private Canvas canvas;
	
	private Map<Character, DrawingCommandHandler> handlers; 
	
	private Scanner scan = null;
	
	private Renderer renderer = new ConsoleRenderer();
	
	private boolean consoleRunMode = false;
	
	public ConsoleHandler() {
		handlers = new HashMap<>();
		handlers.put('C', new CanvasDrawingCommandHandler());
		handlers.put('R', new RectangleDrawingCommandHandler());
		handlers.put('L', new LineDrawingCommandHandler());
		handlers.put('B', new BucketFillDrawingCommandHandler());
	}
	
	private void executeCommand(String command) {
		try {
			if(command==null || command.length()<1) {
				throw new ConsoleCommandException("Program expects command parameter C/R/L/B/Q");
			} else {
				char commandType = command.charAt(0);
				switch(commandType) {
					case 'Q':
						System.out.println("Program Exited!");
				        scan.close();
				        if(consoleRunMode)
				        	System.exit(0);
						break;
					case 'C': case 'R': case 'L': case 'B':
						canvas = handlers.get(commandType).executeDrawingInstructions(command, canvas);
						break;
					default:
						throw new ConsoleCommandException("Program expects command parameter C/R/L/B/Q");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void startProgram(InputStream in) throws Exception {
		if(in.equals(System.in)) {
			consoleRunMode = true;
		}
		
		scan = new Scanner(in);
		String command = null;
		boolean toQuit = false;
		while(!toQuit) {
            System.out.print("\nenter command:");
            command = scan.nextLine().trim();
            if(command.equals("Q")) {
		        scan.close();
		        toQuit = true;
		        if(consoleRunMode)
		        	System.exit(0);
            } else {
	            executeCommand(command);
	            if(canvas!=null)
	            	renderer.renderDrawing(canvas.getCoordinates());
            }
        }
		
	}
	
	
	

}
