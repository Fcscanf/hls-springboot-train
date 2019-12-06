package org.hand.train.springboot.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * SpringbootApplication
 *
 * encoding:UTF-8
 * @author Fcant 15:53 2019/12/5
 */
@EnableCaching
@SpringBootApplication
@MapperScan("org.hand.train.springboot.springboot.mapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
