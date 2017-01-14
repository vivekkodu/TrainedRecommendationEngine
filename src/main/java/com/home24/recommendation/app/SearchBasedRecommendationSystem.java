package com.home24.recommendation.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by VIVEK VERMA on 1/14/2017.
 */
public class SearchBasedRecommendationSystem extends BaseRecommendationSystem {
    public SearchBasedRecommendationSystem(Map skuMap) {
        super(skuMap);
    }

    public List<String> recommend(String sku, int numberOfRecommendations)
    {
        if(!this.skuMap.containsKey(sku)){
            return null;
        }

        BinaryMinHeap<SkuDetails> recommendationHeap = new BinaryMinHeap<SkuDetails>(numberOfRecommendations,
                SkuDetails.class);
        SkuDetails inputSkuDetails = new SkuDetails(sku, this.skuMap.get(sku));
        for (String skuKey :
                this.skuMap.keySet()) {
            if(skuKey.equalsIgnoreCase(sku)){
                continue;
            }

            SkuDetails skuDetails = new SkuDetails(skuKey, this.skuMap.get(skuKey));
            skuDetails.findProximity(inputSkuDetails);
            recommendationHeap.insert(skuDetails);
            
        }

        List<String> recommendedSkus = new ArrayList<String>();
        while(recommendationHeap.getMin() != null){
            recommendedSkus.add(recommendationHeap.getMin().name);
            recommendationHeap.removeMin();
        }

        return recommendedSkus;
    }
}
