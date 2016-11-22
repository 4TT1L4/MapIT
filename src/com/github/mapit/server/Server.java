package com.github.mapit.server;

import static spark.Spark.*;

import com.github.mapit.backend.IMapITApp;

/**
 * Implements the web server for the MapIT system.
 * 
 * @author Attila
 *
 */
public class Server implements IServer {
	private final IMapITApp application;
	private final IPageLoader loader;

	/**
	 * Constructor.
	 * 
	 * @param application The IMapITApp object to be used by the Server instance.
	 */
	public Server(IMapITApp application)
	{
		this.application = application;
		this.loader = new PageLoader();
	}

	/**
	 * Constructor for unit testing.
	 * 
	 * @param application The IMapITApp object to be used by the Server instance.
	 * @param loader The IPageLoader instance to be used by the Server instance.
	 */
	public Server(IMapITApp application, IPageLoader loader)
	{
		this.application = application;
		this.loader = loader;
	}
	
	/**
	 * Initialize the web server.
	 */
	@Override
	public void init()
	{
		get("/isLoading", (req, res) -> "" + isLoading());
		get("/getImageCount", (req, res) -> "" + getImageCount());
		get("/", (req, res) -> getWebpage());
	}
	
	/**
	 * @return The content of the index page.
	 */
	String getWebpage() {
		return loader.getIndex();
	}

	/**
	 * @return if the system is still loading.
	 */
	boolean isLoading()
	{
		return application.isLoading();
	}		
	
	/**
	 * @return the count of the available images.
	 */
	int getImageCount()
	{
		return application.getImageCount();
	}

	@Override
	public void kill() {
		stop();
	}		
}
