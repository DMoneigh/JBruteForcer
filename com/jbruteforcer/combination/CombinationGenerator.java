package com.jbruteforcer.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jbruteforcer.combination.listener.GenerateListener;
import com.jbruteforcer.combination.type.CombinationType;

/**
 * Generates character combinations.
 * 
 * @author Desmond Jackson
 */
public class CombinationGenerator extends Thread {

	/**
	 * The characters used in combination generation.
	 */
	private Character[] characters = new Character[] {};
	
	/**
	 * The max length that generated combinations can be.
	 */
	private int maxLength = 5;
	
	/**
	 * The combination listener.
	 */
	private GenerateListener generateListener;

	/**
	 * Creates the combination generator.
	 * 
	 * @param ccts The type of combinations to generate
	 */
	public CombinationGenerator(CombinationType... ccts) {
		super();
		for (CombinationType cct : ccts)
			switch (cct) {
			case LOWERCASE :
				appendCharacters(new Character[] {
						'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
						'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
				});
				break;
			case UPPERCASE :
				appendCharacters(new Character[] {
						'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
						'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
				});
				break;
			case NUMBERS :
				appendCharacters(new Character[] {
						'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
				});
				break;
			case SYMBOLS :
				appendCharacters(new Character[] {
						'`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+',
						'[', '{', ']', '}', '\\', '|', ';', ':', '\'', '"', ',', '<', '.', '>', '/', '?'
				});
				break;
			}
	}

	/**
	 * Appends characters to the array of characters to be used in combination generation.
	 * 
	 * @param newCharacters The characters to append
	 */
	private void appendCharacters(Character[] newCharacters) {
		List<Character> newCharacterList = new ArrayList<Character>(characters.length + newCharacters.length);
		Collections.addAll(newCharacterList, characters);
		Collections.addAll(newCharacterList, newCharacters);
		characters = newCharacterList.toArray(new Character[newCharacterList.size()]);
	}
	
	/**
	 * Sets the max length that the generated combinations can be.
	 * 
	 * @param maxLength The max length
	 */
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	
	/**
	 * Starts generating character combinations.
	 * 
	 * @param generateListener The combination generate listener to call
	 */
	public void startGeneration(GenerateListener generateListener) {
		this.generateListener = generateListener;
		start();
	}
	
	@Override
	public void run() {
		generateCombination("", maxLength);
	}
	
	/**
	 * Generates a character combination.
	 * 
	 * @param combination The combination generated
	 * 
	 * @param length The length of the combination
	 */
	private void generateCombination(String combination, int length) {
		if (length == 0) {
			generateListener.onGenerate(combination);
			return;
		}
		for (int i = 0; i < characters.length; i++)
			generateCombination(combination + characters[i], length - 1);
	}

}
