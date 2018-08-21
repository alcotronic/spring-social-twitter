/**
 * 
 */
package org.springframework.social.twitter.api;

import java.util.List;

/**
 * @author steffi
 *
 */
public class ExtendedTweet {

	private String fullText;
	private List<Integer> displayTextRange;
	private Entities entities;
	
	public ExtendedTweet(String fullText, List<Integer> displayTextRange, Entities entities) {
		this.fullText = fullText;
		this.displayTextRange = displayTextRange;
		this.entities = entities;
	}

	public String getFullText() {
		return fullText;
	}
	
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	
	public List<Integer> getDisplayTextRange() {
		return displayTextRange;
	}
	
	public void setDisplayTextRange(List<Integer> displayTextRange) {
		this.displayTextRange = displayTextRange;
	}
	
	public Entities getEntities() {
		return entities;
	}
	
	public void setEntities(Entities entities) {
		this.entities = entities;
	}
	
}
