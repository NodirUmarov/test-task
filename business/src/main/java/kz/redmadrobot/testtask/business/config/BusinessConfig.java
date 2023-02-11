package kz.redmadrobot.testtask.business.config;

import kz.redmadrobot.testtask.dao.config.DaoConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "kz.redmadrobot.testtask.business", basePackageClasses = DaoConfig.class)
public class BusinessConfig {
}