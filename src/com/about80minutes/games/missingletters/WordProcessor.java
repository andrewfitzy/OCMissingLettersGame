package com.about80minutes.games.missingletters;

import java.util.Random;

/**
 * Utility class for processing words
 */
public class WordProcessor {
	private static final Random SPACE_INDEX = new Random();
	
	/**
	 * Method for processing a word. This method
	 * 1. Converts the input word to UPPERCASE
	 * 2. Strips any trailing spaces
	 * 3. Strips spaces from the word
	 * 4. Strips vowels from the word
	 * 5. reinserts the correct number of spaces
	 * 6. returns the word
	 * 
	 * @param input a {@link java.lang.String} to process
	 * 
	 * @return a {@link java.lang.String} result
	 */
	public static String processWord(String input) {
		StringBuilder result = new StringBuilder();
		//convert to uppercase and trim
		input = input.toUpperCase().trim();
		int spaceCount = 0;
		for(char character : input.toCharArray()) {
			//count number of spaces
			if(' ' == character) {
				spaceCount++;
			} else if(!isVowel(character) && isLetter(character)) { //remove all vowels
				//append to result
				result.append(character);
			}
		}
		
		//randomly insert spaces back into the word
		for(int i = 0;i < spaceCount;i++) {
			//for each space
			//get a random index > first char but less than last char
			//insert space at index
			int insertIndex = SPACE_INDEX.nextInt(result.length());
			if(insertIndex == 0) {
				insertIndex = 1;
			} else if(insertIndex == result.length() -1) {
				insertIndex = result.length() -2;
			}
			result.insert(insertIndex, ' ');
		}
		return result.toString();
	}
	
	/**
	 * Utility method for checking if the letter is a vowel.
	 * 
	 * @param character a char containing the character to check
	 * 
	 * @return a {@link java.lang.Boolean} indicating if the character is a vowel
	 */
	private static Boolean isVowel(char character) {
		Boolean isVowel = Boolean.FALSE;
		//evaluate in order of character popularity: http://en.wikipedia.org/wiki/Letter_frequency
		if('E' == character || 'A' == character || 'O' == character || 'I' == character || 'U' == character) {
			isVowel = Boolean.TRUE;
		}
		return isVowel;
	}
	
	/**
	 * Utility method for checking if the letter is a letter i.e. A-Z.
	 * 
	 * @param character a char containing the character to check
	 * 
	 * @return a {@link java.lang.Boolean} indicating if the character is a letter
	 */
	private static Boolean isLetter(char character) {
		//check character value range for uppercase letters
		Boolean isLetter = Boolean.FALSE;
		if(character >= 'A' && character <= 'Z') {
			isLetter = Boolean.TRUE;
		}
		return isLetter;
	}
}
