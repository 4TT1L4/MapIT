package com.github.mapit.backend;

/**
 * Interface for an image descriptor object. Provides access to the path, longitude and latitude of the image. 
 * 
 * @author Attila
 *
 */
public interface ImageInfo {
	/**
	 * Provides access to the path of the image.
	 *  
	 * @return The path of the image.
	 */
	String getImagePath();
	
	/**
	 * Provides access to the longitude of the image.
	 * 
	 * @return The longitude of the image.
	 */
	double getLongitude();
	
	/**
	 * Provides access to the latitude of the image.
	 * 
	 * @return The latitude of the image.
	 */
	double getLatitude();
}
