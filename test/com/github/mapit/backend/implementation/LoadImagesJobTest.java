package com.github.mapit.backend.implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.mapit.backend.ImageInfo;

/**
 * Tests the LoadImagesJob class.
 * 
 * @author Attila
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LoadImagesJobTest {
	// Object under test.
	LoadImagesJob job;
	
	@Mock
	private ImageLoaderImpl imageLoaderImpl;
	
	@Before
	public void setUp()
	{
		job = new LoadImagesJob(imageLoaderImpl);
		imageLoaderImpl.images = new ArrayList<ImageInfo>();
	}
	
	@Test
	public void test_run_loadsTheImageInformation()
	{
		job.run();
		assertTrue(imageLoaderImpl.images.size() > 0);
	}
}
