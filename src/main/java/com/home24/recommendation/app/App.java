package com.home24.recommendation.app;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {

        if(args.length < 2){
            System.out.println("Please provide path to the data file and sku name for which recommendation needs to be generated");
            System.out.println("[Path to the json training data][input sku]");
        }

        // Parse the data file and create json object out of it
        //Map inputSkus = JsonParser.parseFile("src\\data\\home24-test-data.json");
        Map inputSkus = JsonParser.parseFile(args[0]);

        // Initialize recommendation engine
        BaseRecommendationSystem recommendationSystem = new SearchBasedRecommendationSystem(inputSkus);

        // Get recommendation
        //List<String> recommendations = recommendationSystem.recommend("sku-1" , 5);
        List<String> recommendations = recommendationSystem.recommend(args[1]    , 5);

        // No recommendation processed as input is not part of training data
        if(recommendations == null){
            System.out.println("No recommendation. No data available for the sku");
            return;
        }

        // Recommendation is provided in reverse order(Least to Most recommended). Correct the order.
        Collections.reverse(recommendations);
        for (String recommendation: recommendations) {
            System.out.println(recommendation);
        }
    }
}
