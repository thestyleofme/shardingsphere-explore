package com.github.thestyleofme.example.hint;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-02-04 10:44
 * @since 1.0.0
 */
public class MyHintShardingAlgorithm implements HintShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> collection,
                                         HintShardingValue<Long> hintShardingValue) {
        ArrayList<String> result = new ArrayList<>();
        for (Long value : hintShardingValue.getValues()) {
            if (value % 2 == 0) {
                result.add("master");
            } else {
                result.add("slave0");
            }
        }
        return result;
    }
}
