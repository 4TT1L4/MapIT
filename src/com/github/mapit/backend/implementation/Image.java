package com.github.mapit.backend.implementation;

import com.github.mapit.backend.ImageInfo;

/**
 * Immutable data container for the storage of image information.
 * 
 * @author Attila
 *
 */
public class Image implements ImageInfo {
	
	private final double latitude;
	private final double longitude;

	/**
	 * Constructor.
	 * 
	 * @param latitude The latitude of the image.
	 * @param longitude The longitude of the image.
	 */
	public Image(double latitude, double longitude)
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @see ImageInfo#getImagePath
	 */
	@Override
	public String getImagePath() {
		// TODO: Implement
		return "";
	}

	/**
	 * @see ImageInfo#getLongitude
	 */
	@Override
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @see ImageInfo#getLatitude
	 */
	@Override
	public double getLatitude() {
		return latitude;
	}

}
