/**
 * 
 */
package org.springframework.social.twitter.api;

/**
 * @author Steffi Wild
 *
 */
public enum Resize {

	CROP("crop"),
	FIT("fit");
	
	private final String name;
	
	private Resize(String s) {
		this.name = s;
	}
	
	public String toString() {
		return this.name();
	}
}
