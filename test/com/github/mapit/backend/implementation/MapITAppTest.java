package com.github.mapit.backend.implementation;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.mapit.backend.IMapITApp;
import com.github.mapit.backend.ImageInfo;
import com.github.mapit.backend.ImageLoader;
import com.github.mapit.server.Server;

/**
 * Tests the MapITApp class
 * @author Attila
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MapITAppTest {
	    // Object under test.
	    MapITApp app;
	    
	    @Mock
		private ImageLoader loader;
		
	    @Before
	    public void setup()
	    {
	    	app = new MapITApp(loader);
		}
	    
	    /**
	     * 
	     */
	    @Test
	    public void test_getImageCount_ZeroForEmptyList()
	    {	    	    
	    	List<ImageInfo> list = new ArrayList<ImageInfo>();
			when(loader.getImages()).thenReturn(list);
	    	
	    	int count = app.getImageCount();
	    	assertTrue(count == 0);
	    }
	    
	    /**
	     * 
	     */
	    @Test
	    public void test_getImageCount_NonZeroForNonEmptyList()
	    {	    	    
	    	List<ImageInfo> list = new ArrayList<ImageInfo>();
	    	list.add(new Image(2d, 3d));
	    	list.add(new Image(3d, 3d));
	    	list.add(new Image(2d, 4d));
			when(loader.getImages()).thenReturn(list);
	    	
	    	int count = app.getImageCount();
	    	assertTrue(count == 3);
	    }
	    
	    /**
	     * 
	     */
	    @Test
	    public void test_getImage_imageReturned()
	    {	    	    
	    	List<ImageInfo> list = new ArrayList<ImageInfo>();
	    	list.add(new Image(2d, 3d));
	    	list.add(new Image(3d, 3d));
	    	Image image = new Image(2d, 4d);
	    	list.add(image);
			when(loader.getImages()).thenReturn(list);
	    	
	    	ImageInfo imageReturned = app.getImage(2);
	    	assertSame(image, imageReturned);
	    }
	    
	    /**
	     * 
	     */
	    @Test
	    public void test_isLoading_notLoading()
	    {	    	    
	    	when(loader.isLoading()).thenReturn(false);
	    	
	    	boolean isLoading = app.isLoading();
	    	
	    	assertFalse(isLoading);
	    }
	    
	    /**
	     * 
	     */
	    @Test
	    public void test_isLoading_Loading()
	    {	    	    
	    	when(loader.isLoading()).thenReturn(true);
	    	
	    	boolean isLoading = app.isLoading();
	    	
	    	assertTrue(isLoading);
	    }
}
