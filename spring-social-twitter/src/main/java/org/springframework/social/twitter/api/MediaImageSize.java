/**
 * 
 */
package org.springframework.social.twitter.api;

/**
 * @author Steffi Wild
 *
 */
public class MediaImageSize {

	private int w;
	private int h;
	private Resize resize;
	
	public MediaImageSize() {
		
	}
	
	public MediaImageSize(int w, int h, Resize resize) {
		this.w = w;
		this.h = h;
		this.resize = resize;
	}
	
	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}
	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}
	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}
	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}
	/**
	 * @return the resize
	 */
	public Resize getResize() {
		return resize;
	}
	/**
	 * @param resize the resize to set
	 */
	public void setResize(Resize resize) {
		this.resize = resize;
	}
	
	
	
}
