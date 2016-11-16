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
	
	/**
	 * Constructor.
	 * 
	 * @param application The IMapITApp object to be used by the Server instance.
	 */
	public Server(IMapITApp application)
	{
		this.application = application;
	}
	
	/**
	 * Initialize the web server.
	 */
	@Override
	public void init()
	{
		get("/isLoading", (req, res) -> "" + isLoading());
		get("/getImageCount", (req, res) -> "" + getImageCount());
	}
	
	private boolean isLoading()
	{
		return application.isLoading();
	}		
	
	public int getImageCount()
	{
		return application.getImageCount();
	}

	@Override
	public void kill() {
		stop();
	}		
}
