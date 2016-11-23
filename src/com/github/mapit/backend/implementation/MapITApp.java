package com.github.mapit.backend.implementation;

import com.github.mapit.backend.IMapITApp;
import com.github.mapit.backend.ImageInfo;
import com.github.mapit.backend.ImageLoader;

/**
 * MapIT application implementation.
 * 
 * @author Attila
 *
 */
public class MapITApp implements IMapITApp {

	private ImageLoader loader;

	/**
	 * Constructor.
	 * 
	 * @param loader
	 */
	public MapITApp(ImageLoader loader)
	{
		this.loader = loader;
	}
	
	/**
	 * @see IMapITApp#getImageCount()
	 */
	@Override
	public int getImageCount() {
		return this.loader.getImages().size();
	}

	/**
	 * @see IMapITApp#getImage(int)
	 */
	@Override
	public ImageInfo getImage(int index) {
		return this.loader.getImages().get(index);
	}

	/**
	 * @see IMapITApp#isLoading()
	 */
	@Override
	public boolean isLoading() {
		return this.loader.isLoading();
	}

	/**
	 * @see IMapITApp#init()
	 */
	@Override
	public void init() {
		loader.loadImages();
	}
}
