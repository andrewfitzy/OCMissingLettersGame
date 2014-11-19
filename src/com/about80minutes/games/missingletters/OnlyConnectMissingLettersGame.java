package com.about80minutes.games.missingletters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.about80minutes.games.missingletters.json.Category;

/**
 * Main driving class, this is responsible for controlling the flow of the game
 */
public class OnlyConnectMissingLettersGame {

	/**
	 * Main method, used to initialise the application
	 * 
	 * @param args a {@link java.lang.String}[] of arguments
	 */
	public static void main(String[] args) {
		int noOfRounds = 5; //pass this in as an argument
		int questionsPerRound = 5; //pass this in as an argument
		BufferedReader stdin =  new BufferedReader(
                				new InputStreamReader(System.in));
		
		System.out.println("Categories and their words will be presented, press enter for the answer and for the next clue");
		Categories categories = new Categories();
		for(int i = 0;i < noOfRounds;i++) {
			Category category = categories.getRandomCategory();
			System.out.println(category.displayName);
			for(int j = 0;j < questionsPerRound;j++) {
				String answer = category.getRandomAnswer();
				if(answer != null) {
					System.out.print(WordProcessor.processWord(answer));
					try {
						stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.print(answer);
					System.out.println();
					System.out.println();
				} else {
					break;
				}
			}
			System.out.println();
			System.out.println();
		}
	}
}
