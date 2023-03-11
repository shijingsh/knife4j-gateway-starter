package com.knife4j.doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Knife4jApplication
 * @author jmac
 * @since 2022-08-28
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class Knife4jDoc2Application {

    public static void main(String[] args) {
        SpringApplication.run(Knife4jDoc2Application.class, args);
    }

}
