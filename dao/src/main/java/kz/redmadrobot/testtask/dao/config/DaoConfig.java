package kz.redmadrobot.testtask.dao.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan("kz.redmadrobot.testtask.dao")
@EntityScan(basePackages = "kz.redmadrobot.testtask.dao")
@EnableJpaRepositories(basePackages = "kz.redmadrobot.testtask.dao")
public class DaoConfig {
}