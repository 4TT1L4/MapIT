package com.github.mapit.server;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.mapit.backend.IMapITApp;
import com.github.mapit.backend.ImageInfo;

/**
 * Tests the Server class.
 * 
 * @author Attila
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ServerTest {

	private static final int IMAGE_COUNT = 43364;

	private static final String INDEX_CONTENT = "Content of the index page.";

	// Object under test.
	Server server;

	@Mock
	IMapITApp app;
	
	@Mock
	IPageLoader loader;

	@Mock
	ImageInfo imageInfoFour;
	
    @Before
    public void setup()
    {
    	server = new Server(app, loader);
	}
    
    /**
     * Makes sure, that the getImageCount results in the actual image count provided by the application.
     */
    @Test
    public void test_ImageCount_ValueIsReturned()
    {
    	// Setup.
    	when(app.getImageCount()).thenReturn(IMAGE_COUNT);
    	
    	// Exercise.
    	int imageCount = server.getImageCount();
    	
    	// Verify.
    	assertEquals(IMAGE_COUNT, imageCount);
    }
    
    /**
     * If the application is still loading, then this should be visible for the Server.
     */
    @Test
    public void test_isLoading_TrueValueIsReturnedWhenLoading()
    {
    	// Setup.
    	when(app.isLoading()).thenReturn(true);
    	
    	// Exercise.
    	boolean isLoading = server.isLoading();
    	
    	// Verify.
    	assertTrue(isLoading);
    }
    
    /**
     * If the application is not loading anymore, then this should be visible for the Server.
     */
    @Test
    public void test_isLoading_FalseValueIsReturnedWhenNotLoading()
    {
    	// Setup.
    	when(app.isLoading()).thenReturn(false);
    	
    	// Exercise.
    	boolean isLoading = server.isLoading();
    	
    	// Verify.
    	assertFalse(isLoading);
    }
    
    /**
     * Test if the content provided by the page loader is accessible through the server.
     */
    @Test
    public void test_getWebpage_providesProperContext()
    {
    	// Setup.
    	when(loader.getIndex()).thenReturn(INDEX_CONTENT);
    	
    	// Exercise.
    	String content = server.getWebpage();
    	
    	// Verify.
    	assertEquals(INDEX_CONTENT, content);
    }
}
