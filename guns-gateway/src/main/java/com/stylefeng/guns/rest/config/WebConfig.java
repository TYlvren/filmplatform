package com.stylefeng.guns.rest.config;

import com.stylefeng.guns.rest.config.properties.RestProperties;
import com.stylefeng.guns.rest.modular.auth.filter.AuthFilter;
import com.stylefeng.guns.rest.modular.auth.security.DataSecurityAction;
import com.stylefeng.guns.rest.modular.auth.security.impl.Base64SecurityAction;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * web配置
 *
 * @author fengshuonan
 * @date 2017-08-23 15:48
 */
@Configuration
public class WebConfig {

    @Bean
    @ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "auth-open", havingValue = "true", matchIfMissing = true)
    public AuthFilter jwtAuthenticationTokenFilter() {
        return new AuthFilter();
    }

    @Bean
    public DataSecurityAction dataSecurityAction() {
        return new Base64SecurityAction();
    }

    /**
     * JedisPool
     * @return
     */
    @Bean
    public JedisPool jedisPool(){
        return new JedisPool();
    }

    /**
     * Jedis，索引为1的数据库，多例模式调用
     * @param jedisPool
     * @return
     */
    @Bean
    @Scope("prototype")
    public Jedis jedis(JedisPool jedisPool){
        Jedis resource = jedisPool.getResource();
        resource.select(1);
        return resource;
    }
}
