package com.github.mapit;

import com.github.mapit.backend.IMapITApp;
import com.github.mapit.backend.ImageLoader;
import com.github.mapit.backend.implementation.ImageLoaderImpl;
import com.github.mapit.backend.implementation.MapITApp;
import com.github.mapit.server.IServer;
import com.github.mapit.server.Server;

/**
 * Factory for the main components.
 * 
 * @author Attila
 *
 */
public class MapITFactory implements IMapITFactory {
	
	/**
	 * @see IMapITFactory#getServer
	 */
	@Override
	public IServer getServer(IMapITApp app) {
		return new Server(app);
	}

	/**
	 * @see IMapITFactory#getApp
	 */
	@Override
	public IMapITApp getApp(ImageLoader loader) {
		return new MapITApp(loader);
	}

	/**
	 * @see IMapITFactory#getImageLoader
	 */
	@Override
	public ImageLoader getImageLoader() {
		return new ImageLoaderImpl();
	}

}
