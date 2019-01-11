package com.app;

import com.app.command.Handler;
import com.app.command.console.ConsoleHandler;

public class DrawingApp {

	public static void main(String[] args) {
		try {
			Handler drawingHandler = new ConsoleHandler();
			drawingHandler.startProgram(System.in);
		} catch (Exception e) {
			System.out.println("Exception in program----");
			e.printStackTrace();
		}
		
	}

}
