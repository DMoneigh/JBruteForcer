package com.jbruteforcer;

import com.jbruteforcer.combination.CombinationGenerator;
import com.jbruteforcer.combination.listener.GenerateListener;
import com.jbruteforcer.combination.type.CombinationType;

/**
 * A Java Brute Forcer.
 * 
 * @author Desmond Jackson
 */
public class JBruteForcer extends Object {
	
	/**
	 * The main method.
	 * 
	 * @param args String arguments
	 */
	public static void main(String[] args) {
		
		// Create combination generator object and specify what type of character combinations to generate.
		// Different combination types are separated by commas.
		CombinationGenerator cg = new CombinationGenerator(CombinationType.LOWERCASE, CombinationType.NUMBERS);
		
		// Set the max length that generations can be. Default is 5.
		cg.setMaxLength(3);
		
		// Start generating character combinations with the GenerateListener class.
		cg.startGeneration(new GenerateListener() {

			@Override
			public void onGenerate(String combination) {
				
				// Write code to handle the generated character combination.
				System.out.println(combination);
			}
			
		});
	}

}
