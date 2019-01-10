package com.app.command;

import com.app.drawing.console.Canvas;

public interface Handler {
	
	public Canvas executeCommand(String command) throws Exception ;
	
}
