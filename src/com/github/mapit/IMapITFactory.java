package com.github.mapit;

import com.github.mapit.backend.IMapITApp;
import com.github.mapit.backend.ImageLoader;
import com.github.mapit.server.IServer;

/**
 * Factory interface for the main components.
 * 
 * @author Attila
 *
 */
interface IMapITFactory {
	/**
	 * Creates an IServer instance.
	 * 
	 * @param app The IMapITApp instance to be used by the server.
	 * @return The created IServer instance.
	 */
	IServer getServer(IMapITApp app);
	
	/**
	 * Creates an IMapITApp instance.
	 * 
	 * @param loader The ImageLoader instance to be used by the IMapITApp instance.
	 * @return The created IMapITApp instance.
	 */
	IMapITApp getApp(ImageLoader loader);
	
	/**
	 * Creates an ImageLoader instance.
	 * 
	 * @return The created ImageLoader instance.
	 */
	ImageLoader getImageLoader();
}
