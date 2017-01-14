package com.home24.recommendation.app;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by VIVEK VERMA on 1/14/2017.
 */
public abstract class BaseRecommendationSystem {
    protected Map<String, Map<String, String>> skuMap;

    public BaseRecommendationSystem(Map skuMap){
        this.skuMap = skuMap;
    }

    public abstract List<String> recomend(String sku, int numberOfRecommendations);

}
