package kz.redmadrobot.testtask.web;

import kz.redmadrobot.testtask.business.config.BusinessConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {TestTaskApplication.class, BusinessConfig.class})
public class TestTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }
}