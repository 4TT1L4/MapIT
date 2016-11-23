package com.github.mapit.backend.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.mapit.backend.ImageInfo;
import com.github.mapit.backend.ImageLoader;

/**
 * Provides images for the MapIT application.
 * 
 * @author Attila
 *
 */
public class ImageLoaderImpl implements ImageLoader {

	List<ImageInfo> images = new ArrayList<ImageInfo>();
	volatile boolean isLoading = true;

	LoadImagesJob loaderJob;
	
	/**
	 * Constructor.
	 */
	public ImageLoaderImpl()
	{
		loaderJob = new LoadImagesJob(this);
	}
	
	/**
	 * Constructor for unit testing.
	 */
	public ImageLoaderImpl(LoadImagesJob loaderJob)
	{
		this.loaderJob = loaderJob;
	}
	
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
		loaderJob.start();
	}

	/**
	 * @see ImageLoader#getImages()
	 */
	@Override
	public List<ImageInfo> getImages() {
		return Collections.unmodifiableList(images);
	}
}
