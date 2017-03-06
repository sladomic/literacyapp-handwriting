package org.literacyapp.handwriting.entity;

public interface LanguageProcessor {
	
	/**
	 * 
	 * @param previous the String present to the left of cursor 
	 * @param current the current String to be input
	 * @return 
	 */
	public String[] process(String previous, CharData current);
	public String getStack();
	public String getEngineName();
	public String getFontName();
}
