package com.app.drawing.console;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.app.drawing.console.Canvas;
import com.app.exception.*;

class TestCanvas {

	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	@Test
	void testCanvasInitPostiveHeightWidth() throws Exception {
		Canvas canvas = new Canvas(10,10);
	}
	
	@Test
	void testCanvasInitNonPositiveHeightWidth() throws Exception {
		try {
			Canvas canvas = new Canvas(-10,-10);
		} catch (CanvasException e) {
			assertEquals("Canvas width and height must be positive integers", e.getMessage());
		}
	}

}
