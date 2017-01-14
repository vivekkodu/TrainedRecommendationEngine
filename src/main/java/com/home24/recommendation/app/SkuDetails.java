package com.home24.recommendation.app;

import java.util.Map;

/**
 * Created by VIVEK VERMA on 1/14/2017.
 */
public class SkuDetails implements Comparable<SkuDetails> {
    String name;
    Map<String, String> properties;
    long proximitySequence;
    int matchCount = 0;

    SkuDetails(String name, Map<String, String> properties){
        this.name = name;
        this.properties = properties;
    }

    public void findProximity(SkuDetails baseSku){
        this.proximitySequence = 0;
        this.matchCount = 0;
        for (String property: properties.keySet()) {
            if(this.properties.get(property).equals(baseSku.properties.get(property))){
                this.matchCount++;
                this.proximitySequence <<= 1;
                this.proximitySequence |= 1;
            }else{
                this.proximitySequence <<=1;
            }
        }
    }

    public int compareTo(SkuDetails comparatorSku) {
        if(this.matchCount == comparatorSku.matchCount){
            if(this.proximitySequence < comparatorSku.proximitySequence){
                return -1;
            }else{
                return 1;
            }
        }else{
            return this.matchCount - comparatorSku.matchCount;
        }
    }
}
