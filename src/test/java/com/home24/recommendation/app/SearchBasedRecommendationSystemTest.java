package com.home24.recommendation.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created by VIVEK VERMA on 1/14/2017.
 */
public class SearchBasedRecommendationSystemTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SearchBasedRecommendationSystemTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SearchBasedRecommendationSystemTest.class );
    }

    public void testRecommendations() throws FileNotFoundException {
        Map inputSkus = JsonParser.parseFile("src\\data\\testData1.json");
        BaseRecommendationSystem recommendationSystem = new SearchBasedRecommendationSystem(inputSkus);
        List<String> recommendations = recommendationSystem.recommend("sku-1" , 5);
        assertEquals(recommendations.get(0), "sku-8");  // "att-j" matches
        assertEquals(recommendations.get(1), "sku-9");  // "att-e" matches
        assertEquals(recommendations.get(2), "sku-5");  // "att-c" matches
        assertEquals(recommendations.get(3), "sku-6");  // "att-f", "att-g" matches
        assertEquals(recommendations.get(4), "sku-10"); // "att-b", "att-h" matches

        recommendations = recommendationSystem.recommend("sku-1" , 3);
        assertEquals(recommendations.get(0), "sku-5");
        assertEquals(recommendations.get(1), "sku-6");
        assertEquals(recommendations.get(2), "sku-10");

        recommendations = recommendationSystem.recommend("sku-1" , 6);
        assertEquals(recommendations.size(), 6); // Only 5 matches in input data, last one is filled as it was expecting 6 matches
        assertEquals(recommendations.get(5), "sku-10");

        recommendations = recommendationSystem.recommend("sku-3" , 7);
        assertEquals(recommendations.get(0), "sku-5");
        assertEquals(recommendations.get(1), "sku-11");
        assertEquals(recommendations.get(2), "sku-8");
        assertEquals(recommendations.get(3), "sku-7");
        assertEquals(recommendations.get(4), "sku-9");
        assertEquals(recommendations.get(5), "sku-10");
        assertEquals(recommendations.get(6), "sku-12");

        inputSkus = JsonParser.parseFile("src\\data\\testData2.json");
        recommendationSystem = new SearchBasedRecommendationSystem(inputSkus);
        recommendations = recommendationSystem.recommend("sku-1" , 5);
        assertEquals(recommendations.get(0), "sku-15347");
        assertEquals(recommendations.get(1), "sku-2883");
        assertEquals(recommendations.get(2), "sku-5349");
        assertEquals(recommendations.get(3), "sku-10078");
        assertEquals(recommendations.get(4), "sku-6276");

    }
}
