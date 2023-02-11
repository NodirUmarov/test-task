package kz.redmadrobot.testtask.dao.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaAuditing
@ComponentScan("kz.redmadrobot.testtask.dao")
@EntityScan(basePackages = "kz.redmadrobot.testtask.dao")
@EnableJpaRepositories(basePackages = "kz.redmadrobot.testtask.dao", repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class DaoConfig {
}