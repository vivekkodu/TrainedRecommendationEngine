package com.home24.recommendation.app;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        Map inputSkus = JsonParser.parseFile("src\\data\\home24-test-data.json");
        BaseRecommendationSystem recommendationSystem = new SearchBasedRecommendationSystem(inputSkus);
        List<String> recommendations = recommendationSystem.recommend("sku-1" , 5);

        if(recommendations == null){
            System.out.println("No recommendation. No data available for the sku");
            return;
        }

        Collections.reverse(recommendations);
        for (String recommendation: recommendations
             ) {
            System.out.println(recommendation);
        }
    }
}
