package kz.redmadrobot.dao.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = "kz.redmadrobot.dao")
@EnableJpaRepositories(basePackages = "kz.redmadrobot.dao",
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class DaoConfig {
}