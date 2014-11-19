package com.about80minutes.games.missingletters;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBException;

import com.about80minutes.games.missingletters.json.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

/**
 * Represents a list of categories for the missing vowels game
 */
public class Categories {
	private static final Random CATEGORY_INDEX = new Random();
	private List<Category> categories = Lists.newArrayList();

	/**
	 * initialise the class
	 */
	public Categories() {
		this.loadCategories();
	}
	
	/**
	 * Return a category from the category list
	 * 
	 * @return a {@link com.about80minutes.games.missingletters.json.Category} for use in the game
	 */
	public Category getRandomCategory() {
		//remove each time so categories not duplicated
		return categories.remove(CATEGORY_INDEX.nextInt(categories.size()));
	}
	
	/**
	 * Utility method for loading the category files
	 */
	private void loadCategories() {
		File file = new File("resources");
		File[] files = file.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".json");
			}});
		for(File f : files) {
			try {
				URL tmpURL = f.toURI().toURL();
				Category set = unmarshallCategory(tmpURL);
				categories.add(set);
			} catch (JAXBException e) {
				System.out.println(f + " " + e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(f + " " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Method to read category files
	 * 
	 * @param url a {@link java.net.URL} to process
	 * 
	 * @return a {@link com.about80minutes.games.missingletters.json.Category}
	 */
	private Category unmarshallCategory(URL url) throws JAXBException, IOException  {
		ObjectMapper mapper = new ObjectMapper();
		Category category = mapper.readValue(url.openStream(), Category.class);
		return category;
	}
}
