package com.example.zuulgateway.config;

import com.example.zuulgateway.filters.ErrorFilter;
import com.example.zuulgateway.filters.PostFilter;
import com.example.zuulgateway.filters.PreFilter;
import com.example.zuulgateway.filters.RouteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfiguration {

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
}
