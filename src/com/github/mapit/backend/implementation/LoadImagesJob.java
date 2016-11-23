package com.github.mapit.backend.implementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import com.github.mapit.backend.ImageInfo;

/**
 * Loads the images from the pictures folder.
 * 
 * @author Attila
 *
 */
final class LoadImagesJob extends Thread {
	/**
	 * Reference to the ImageLoader instance.
	 */
	private final ImageLoaderImpl imageLoaderImpl;

	/**
	 * @param imageLoaderImpl
	 */
	LoadImagesJob(ImageLoaderImpl imageLoaderImpl) {
		this.imageLoaderImpl = imageLoaderImpl;
	}

	/**
	 * Execute the job and load the image information from the pictures folder.
	 * 
	 * @see Thread#run
	 */
	public void run() {
		File f = new File("resources/pictures");
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));

		for(int i = 0; i < files.size(); i++)
		{
			File file = files.get(i);
			loadFile(file);
		}
		
		this.imageLoaderImpl.isLoading = false;
	}

	/**
	 * Load the image information for the passed file object.
	 * 
	 * @param file The file object to load the image information for.
	 */
	private void loadFile(File file) {
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(file);
			Collection<GpsDirectory> gpsDirectories = metadata.getDirectoriesOfType(GpsDirectory.class);
			
		    if (gpsDirectories == null)
				return;
		    
		    for (GpsDirectory gpsDirectory : gpsDirectories) {
		        GeoLocation geoLocation = gpsDirectory.getGeoLocation();
		        if (geoLocation != null && !geoLocation.isZero()) {
		            ImageInfo image = new Image(geoLocation.getLatitude(), geoLocation.getLongitude());
		            this.imageLoaderImpl.images.add(image);
		            break;
		        }
		    }
		} catch (ImageProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}