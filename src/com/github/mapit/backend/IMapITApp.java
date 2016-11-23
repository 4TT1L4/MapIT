package com.github.mapit.backend;

/**
 *  Interface for the MapIT application logic.
 * 
 * @author Attila
 *
 */
public interface IMapITApp {
	/**
	 * Provides the actual count of the available images. 
	 * 
	 * @return The actual count of available images.
	 */
	int getImageCount();
	
	/**
	 * Provides access to the loaded images.
	 * 
	 * @param index  The index of the image to be returned. 
	 * @return
	 */
	ImageInfo getImage(int index);
	
	/**
	 * Tells if the backend is still loading and the image count is going to change.
	 * 
	 * If the loading process is done, then the image count is not going to increase anymore.
	 * 
	 * @return true if the backend is still loading images. If the images had been loaded and the image count is final, then it returns false.
	 */
	boolean isLoading();
	
	/**
	 * Starts the initialization of the Map IT application.
	 */
	void init();
}
