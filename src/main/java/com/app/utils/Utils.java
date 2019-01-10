package com.app.utils;

import com.app.exception.IntegerConversionException;

public interface Utils {
	public static int [] convertStringsToIntArray(String[] items, int startIndex, int endIndex) throws IntegerConversionException {
		int[] returnInts;
		if(items==null || items.length ==0 ||
				startIndex < 0 || endIndex < 0 || 
				startIndex > items.length-1 || endIndex > items.length-1 || startIndex > endIndex
				) {
			throw new IntegerConversionException("Command Error: The parameters provided are invalid for conversion");
		} else {
			returnInts = new int[endIndex - startIndex + 1];
			int returnIntsIndex = 0;
			try {
				for (int index = startIndex; index <= endIndex; index++) {
					returnInts[returnIntsIndex] = Integer.parseInt(items[index]);
					returnIntsIndex++;
				}
			} catch (Exception e) {
				throw new IntegerConversionException("Command Error: Command instructions is invalid");
			}
			
		}
		return returnInts;
	}
}
