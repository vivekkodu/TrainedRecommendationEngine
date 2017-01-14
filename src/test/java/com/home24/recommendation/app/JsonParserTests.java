package com.home24.recommendation.app;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by VIVEK VERMA on 1/14/2017.
 */
public class JsonParserTests extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JsonParserTests(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JsonParserTests.class );
    }

    public void testParserOutput() throws FileNotFoundException, InterruptedException {
        Map parsedObject = JsonParser.parseFile("src\\data\\home24-test-data.json");
        assertTrue(20000 == parsedObject.size());
    }
}