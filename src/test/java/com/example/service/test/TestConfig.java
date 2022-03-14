package com.example.service.test;

import com.example.service.GraphService;
import com.example.service.impl.GraphServiceImpl;
import org.springframework.context.annotation.Bean;

public class TestConfig {

    @Bean
    public GraphService graphService() {
        return new GraphServiceImpl();
    }
}
