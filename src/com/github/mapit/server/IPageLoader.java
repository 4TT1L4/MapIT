package com.github.mapit.server;

/**
 * Inteface for loading static content.
 * 
 * @author Attila
 *
 */
interface IPageLoader {

	/**
	 * @return the content for the index page.
	 */
	String getIndex();

}
