package com.github.mapit.backend.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.mapit.backend.ImageInfo;

/**
 * Provides images for the MapIT application.
 * 
 * @author Attila
 *
 */
public class ImageLoaderImpl implements ImageLoader {

	List<ImageInfo> images = new ArrayList<ImageInfo>();
	volatile boolean isLoading = true;

	/**
	 * @see ImageLoader#isLoading()
	 */
	@Override
	public boolean isLoading()
	{
		return isLoading;
	}

	/**
	 * @see ImageLoader#loadImages()
	 */
	@Override
	public void loadImages() {
		(new LoadImagesJob(this)).start();
	}

	/**
	 * @see ImageLoader#getImages()
	 */
	@Override
	public List<ImageInfo> getImages() {
		return Collections.unmodifiableList(images);
	}
}
