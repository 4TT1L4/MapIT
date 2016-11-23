package com.github.mapit.backend.implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.mapit.backend.ImageInfo;


/**
 * Tests the ImageLoaderImpl class.
 * 
 * @author Attila
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageLoaderImplTest {
	// Object under test
	private ImageLoaderImpl loader;
	
	@Mock
	private LoadImagesJob job;
	
	@Before
	public void setUp()
	{
		this.loader = new ImageLoaderImpl(job);
	}

	@Test
	public void test_getImages_returnsTheListElementsSetIntheList()
	{
		// Setup.
		ImageInfo image = new Image(1.3d, 1.2);
		List<ImageInfo> imageList = new ArrayList<ImageInfo>();
		imageList.add(image);
		loader.images = imageList;
		
		// Exercise.
		List<ImageInfo> images = loader.getImages();
		
		// Verify.
		assertTrue(images.contains(image));
	}

	@Test
	public void test_getImages_earlyCallResultsInNotNull()
	{
		// Exercise.
		List<ImageInfo> images = loader.getImages();
		
		// Verify.
		assertNotNull(images);
	}
}
