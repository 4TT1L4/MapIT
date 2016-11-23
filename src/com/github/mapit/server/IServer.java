package com.github.mapit.server;

/**
 * Interface for the server.
 * 
 * @author Attila
 *
 */
public interface IServer {
	/**
	 * Initialize the IServer instance.
	 */
	void init();
	
	/**
	 * Free the resources.
	 */
	void kill();
}
