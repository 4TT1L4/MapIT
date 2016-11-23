package com.github.mapit.backend.implementation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * Tests the Image class.
 * 
 * @author Attila
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageTest {
    private static final double LONGITUDE = 1.234d;
	private static final double LATITUDE = 3.213d;

	@Test
    public void test_Image_ContentIsStored()
    {
    	Image image = new Image(LATITUDE, LONGITUDE);
    	assertEquals(LONGITUDE, image.getLongitude(), 0.001);
    	assertEquals(LONGITUDE, image.getLongitude(), 0.001);
	}
}
