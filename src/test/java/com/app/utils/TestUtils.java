package com.app.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.exception.IntegerConversionException;

class TestUtils {

	@Test
	void testInvalidInstructionInvalidIndex() {
		try {
			Utils.convertStringsToIntArray(new String[]{"C", "10", "12"} ,2, 8);
		} catch (IntegerConversionException e) {
			assertEquals("Command Error: The parameters provided are invalid for conversion", e.getMessage());
		}
	}
	
	@Test
	void testInvalidInstructionCannotConvertToInteger() {
		try {
			Utils.convertStringsToIntArray(new String[]{"C", "B", "12"} ,1, 2);
		} catch (IntegerConversionException e) {
			assertEquals("Command Error: Command instructions is invalid", e.getMessage());
		}
	}
	
	@Test
	void testInstructionConversionSuccessful() throws IntegerConversionException{
		int[] ints = Utils.convertStringsToIntArray(new String[]{"C", "3", "12"} ,1, 2);
		assertArrayEquals(new int[] {3,12}, ints);
	}

}
