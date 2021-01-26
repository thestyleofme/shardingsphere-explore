package com.github.thestyleofme.example.id;

import java.util.Properties;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

/**
 * description
 *
 * @author thestyleofme 2021/01/26 2:27 下午
 */
@Slf4j
public class MyIdGenerator implements ShardingKeyGenerator {

    private final SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();

    @Override
    public Comparable<?> generateKey() {
        log.debug("use my id ShardingKeyGenerator...");
        return snowflakeShardingKeyGenerator.generateKey();
    }

    @Override
    public String getType() {
        return "MY_ID";
    }

    @Override
    public Properties getProperties() {
        return snowflakeShardingKeyGenerator.getProperties();
    }

    @Override
    public void setProperties(Properties properties) {
        snowflakeShardingKeyGenerator.setProperties(properties);
    }
}
