package com.jbruteforcer.combination.listener;

/**
 * The combination generate listener.
 * 
 * @author Desmond Jackson
 */
public interface GenerateListener {

	/**
	 * Called when a combination is generated.
	 * 
	 * @param combination The combination generated 
	 */
	public void onGenerate(String combination);
	
}
