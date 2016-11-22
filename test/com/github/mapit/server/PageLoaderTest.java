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
 * Tests the PageLoader class.
 * 
 * @author Attila
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PageLoaderTest {
	// Object under test.
	PageLoader loader = new PageLoader(); 
    
    /**
     * Makes sure, that the getIndex method return some kind of HTML code.
     */
    @Test
    public void test_getIndex_returnsNonEmptyHTML()
    {
    	String content = loader.getIndex();

    	assertTrue(!content.isEmpty());
    	assertTrue(content.contains("<html>"));
    }    
}
