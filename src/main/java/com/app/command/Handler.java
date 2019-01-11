package com.app.command;

import java.io.InputStream;

import com.app.drawing.console.Canvas;

public interface Handler {
	
	public void startProgram(InputStream in) throws Exception;
	//public Canvas executeCommand(String command) throws Exception ;
	
}
