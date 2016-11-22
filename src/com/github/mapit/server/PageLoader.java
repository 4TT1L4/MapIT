package com.github.mapit.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Loads resources from the filesystem.
 * 
 * @author Attila
 *
 */
public class PageLoader implements IPageLoader {

	private String index;

	/**
	 * Contstructor.
	 */
	public PageLoader()
	{
		loadIndexPage();
	}

	/**
	 * Loads the index page from the resources folder.
	 */
	private void loadIndexPage() {
		File file = new File("resources/index.html");

		try (FileInputStream fis = new FileInputStream(file))
		{
			byte[] data = new byte[(int) file.length()];
			fis.read(data);

			index = new String(data, "UTF-8");
			fis.close();
		}
		catch (IOException e)
		{
			index = "The service is not available at the moment.";
			e.printStackTrace();
		}
	}

	@Override
	public String getIndex() {
		return index;
	}

}
