package com.github.mapit.backend.implementation;

import com.github.mapit.backend.IMapITApp;
import com.github.mapit.backend.ImageInfo;

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
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see IMapITApp#getImage(int)
	 */
	@Override
	public ImageInfo getImage(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see IMapITApp#isLoading()
	 */
	@Override
	public boolean isLoading() {
		// TODO Auto-generated method stub
		return false;
	}
}
