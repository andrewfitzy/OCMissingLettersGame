package com.about80minutes.games.missingletters;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the {@link com.about80minutes.games.missingletters.WordProcessor} class
 */
public class WordProcessorTest {
	
	/**
	 * Test the processWord method
	 */
	@Test
	public void testProcessWord() {
		String[] inwords = new String[]{"test","aardvark","re-evaluate"};
		String[] outwords = new String[]{"TST","RDVRK","RVLT"};
		assertEquals(inwords.length, outwords.length);
		for(int i = 0;i < inwords.length;i++) {
			assertEquals(outwords[i], WordProcessor.processWord(inwords[i]));
		}
	}
}
