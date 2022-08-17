package com.geekbrains.geekmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableCaching
@EnableRedisRepositories
public class GeekMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekMarketApplication.class, args);
    }

}
