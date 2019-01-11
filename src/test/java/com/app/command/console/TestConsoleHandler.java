package com.app.command.console;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestConsoleHandler {
	private ConsoleHandler handler = new ConsoleHandler();
	
	@BeforeEach
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(outContent);
		System.setOut(ps);
	}
	
	@AfterClass
	public void cleanup() {
		System.setIn(System.in);
	}
	
	
	@Test
	void testCanvasNotInitialized_Error() throws Exception {

		String input = "B 1 1 B\nQ";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    handler.startProgram(in);
	    String renderedOutput = outContent.toString();
		assertEquals(
				"\nenter command:Command Error: Canvas need to be defined first before drawing"
				+ "\n\nenter command:", 
				renderedOutput);
	}
	
	@Test
	void testCanvasDoubleInitialized_Error() throws Exception{
		String input = "C 3 3\nC 3 3\nQ";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    handler.startProgram(in);
	    String renderedOutput = outContent.toString();
		assertEquals(
				"\nenter command:-----\n|   |\n|   |\n|   |\n-----"
				+ "\n\nenter command:Command Error: Canvas has already been defined\n"
				+ "-----\n|   |\n|   |\n|   |\n-----"
				+ "\n\nenter command:", 
				renderedOutput);
	}
	
	@Test
	void testCanvasDrawing() throws Exception {
		String input = "C 3 3\nB 1 1 B\nQ";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    handler.startProgram(in);
	    
	    String renderedOutput = outContent.toString();
		assertEquals(
				"\nenter command:-----\n|   |\n|   |\n|   |\n-----"
				+ "\n\nenter command:"
				+ "-----\n|BBB|\n|BBB|\n|BBB|\n-----"
				+ "\n\nenter command:", 
				renderedOutput);
	    
	}
	
	private PrintStream originalOut = System.out;
	private OutputStream outContent;
	
	

	@AfterEach
	public void restoreStreams() throws Exception{
		System.setOut(originalOut);
		outContent.close();
	}

}
