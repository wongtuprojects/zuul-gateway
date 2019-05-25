package com.example.zuulgateway;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ZuulGatewayApplication.class)
public class ZuulGatewayApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    static ConfigurableApplicationContext customerService;

    @BeforeClass
    public static void startCustomerService() {
        customerService = SpringApplication.run(CustomerService.class, "--server.port=8010");
    }

    @AfterClass
    public static void closeCustomerService() {
        customerService.close();
    }

    @Test
    public void testEndPoint() {
        String resp = restTemplate.getForObject("/cusotmer/getCustomers", String.class);
        assertThat(resp).isEqualTo("All Customers");
    }

    @Configuration
    @EnableAutoConfiguration
    @RestController
    static class CustomerService {
        @RequestMapping("/getCustomers")
        public String getCustomers() {
            return "All Customers";
        }
    }


}
