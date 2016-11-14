package MapIT;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void testHelloWorldResult()
    {
        // Create helloWorld instance
        HelloWorld helloWorld = new HelloWorld();
        
        String result = helloWorld.getResult();
        
        // Assertions
        Assert.assertTrue(result.contains("Hello"));
        Assert.assertTrue(result.contains("World"));
	}
}
