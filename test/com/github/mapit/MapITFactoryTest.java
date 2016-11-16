package com.github.mapit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.mapit.backend.IMapITApp;
import com.github.mapit.backend.implementation.ImageLoader;
import com.github.mapit.server.IServer;

/**
 * Tests the MapITFactory test class.
 * 
 * @author Attila
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MapITFactoryTest {

	// Object under test.
	IMapITFactory factory = new MapITFactory();

	@Mock
	IMapITApp app;
	
	@Mock
	ImageLoader loader;
	
    @Test
    public void test_getServer()
    {
    	IServer server = factory.getServer(app);
    	assertNotNull(server);
	}
	
    @Test
    public void test_getApp()
    {
    	IMapITApp app = factory.getApp(loader);
    	assertNotNull(app);
	}
	
    @Test
    public void test_getImageLoader()
    {
    	ImageLoader loader = factory.getImageLoader();
    	assertNotNull(loader);
	}
}
