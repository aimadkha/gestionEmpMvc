package com.code.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.code.services","com.code.dao"})
public class AppRootCofig {

}
