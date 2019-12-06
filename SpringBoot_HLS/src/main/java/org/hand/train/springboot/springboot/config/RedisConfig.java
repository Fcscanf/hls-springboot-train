package org.hand.train.springboot.springboot.config;

import org.hand.train.springboot.springboot.bean.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * RedisConfig
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant 19:20 2019/12/5
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, UserInfo> redisUserTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, UserInfo> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<UserInfo> serializer = new Jackson2JsonRedisSerializer<UserInfo>(UserInfo.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    /**
     * 配置主缓存管理@Primary，使用时默认用主缓存，其他的相应配置也可以在类@CacheConfig 方法@Cacheable引入
     * @author Fcant 19:44 2019/12/5
     */
    @Primary
    @Bean
    public RedisCacheManager userCacheManager(RedisTemplate<Object, UserInfo> redisEmpTemplate) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisEmpTemplate.getConnectionFactory());
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisEmpTemplate.getValueSerializer()));
        return new RedisCacheManager(redisCacheWriter,redisCacheConfiguration);
    }

    @Bean
    public RedisCacheManager usersCacheManager(RedisTemplate<Object, UserInfo> redisEmpTemplate) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisEmpTemplate.getConnectionFactory());
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisEmpTemplate.getValueSerializer()));
        return new RedisCacheManager(redisCacheWriter,redisCacheConfiguration);
    }

}