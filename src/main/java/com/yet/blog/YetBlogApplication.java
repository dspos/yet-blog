package com.yet.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Ekko
 */
@EnableJpaAuditing
@SpringBootApplication
public class YetBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(YetBlogApplication.class, args);
    }

}
