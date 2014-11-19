package com.about80minutes.games.missingletters.json;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to represent a category object
 */
public class Category {
	/*
	 {
    "id":"premier_league_teams_2014_2015"
    "display":"Premier League Teams 2014/15"
    "answers":["Chelsea","Arsenal", ...]
    }
	 */
	
	/**
	 * The ID of the category
	 */
	@JsonProperty("id")
	public String id;
	
	/**
	 * The display name for the category
	 */
	@JsonProperty("display")
	public String displayName;
	
	@JsonProperty("answers")
	private List<String> answers;
	
	private static final Random ANSWER_INDEX = new Random();
	
	/**
	 * Sets the answer objects
	 * 
	 * @param answers a {@link java.util.List} of {@link java.lang.String} answers
	 */
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	/**
	 * Gets a random answer from the answer set
	 * 
	 * @return a {@link java.lang.String} containing an answer
	 */
	public String getRandomAnswer() {
		String answer = null;
		if(!answers.isEmpty()) {
			answer = answers.remove(ANSWER_INDEX.nextInt(answers.size()));
		}
		return answer;
	}
}
