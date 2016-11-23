package com.github.mapit.backend.implementation;

import java.util.List;

import com.github.mapit.backend.ImageInfo;

/**
 * Interface for ImageLoaders for providing images.
 * 
 * @author Attila
 *
 */
public interface ImageLoader {
	
	/**
	 * Get the current list of images.
	 * 
	 * @return The current list of images. This could be changing until the ImageLoader ist still loading @see ImageLoader#isLoading()
	 */
    List<ImageInfo> getImages();

	/**
	 * Checks if the ImageLoader is still loading images or it is done and the number of available images is final.
	 * 
	 * @return true if the ImageLoader is still loading, otherwise false.
	 */
    boolean isLoading();
    
    /**
     * Starts the loading of the images.
     */
	void loadImages();
}
