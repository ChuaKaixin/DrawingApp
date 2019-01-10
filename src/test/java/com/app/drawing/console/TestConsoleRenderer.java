package com.app.drawing.console;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.drawing.CoordinateUnit;
import com.app.drawing.Renderer;
import com.app.drawing.console.ConsoleColour;
import com.app.drawing.console.ConsoleRenderer;
import com.app.utils.Constants.CoordinateUnitType;

public class TestConsoleRenderer {

	@BeforeEach
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(outContent);
		System.setOut(ps);
	}
	
	@Test
	void testRenderEmptyCanvas() throws Exception {
		Renderer cr = new ConsoleRenderer();
		CoordinateUnit[][] units = new CoordinateUnit[3][3];
		cr.renderDrawing(units);
		String renderedOutput = outContent.toString();
		assertEquals("-----\n|   |\n|   |\n|   |\n-----\n", renderedOutput);
	}
	
	@Test
	void testRenderCanvasWithContent() {
		Renderer cr = new ConsoleRenderer();
		CoordinateUnit[][] units = new CoordinateUnit[3][3];
		units[0][0] = new CoordinateUnit(CoordinateUnitType.LINE, new ConsoleColour('o'));
		units[0][1] = new CoordinateUnit(CoordinateUnitType.LINE, new ConsoleColour('o'));
		cr.renderDrawing(units);
		String renderedOutput = outContent.toString();
		assertEquals("-----\n|oo |\n|   |\n|   |\n-----\n", renderedOutput);
	}

	
	private PrintStream originalOut = System.out;
	private OutputStream outContent;
	
	

	@AfterEach
	public void restoreStreams() throws Exception{
		System.setOut(originalOut);
		outContent.close();
	}

}
