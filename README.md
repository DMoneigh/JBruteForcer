JBruteForcer
========

Java Brute Forcer.

Requirements For Compilation
============

Java 8 (JDK) - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Example
=======
'''
		// Create combination generator object and specify what type of character combinations to generate.
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
'''

Donations
=========

Bitcoin Address - 14ESpgxqm1eJ1mnhbg1XeVEum54gejcKXg
