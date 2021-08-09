package com.scb.pmkdif.api.config;


import com.scb.pmkdif.api.config.properties.DataSourceProperties;
import com.scb.pmkdif.api.util.KeyDecryptHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;


@Configuration
public class DatasourceConfig {

    private static final Logger log = LoggerFactory.getLogger(DatasourceConfig.class);

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Value("${application.secret-key}")
    private String secretKey;
    @Value("${spring.profiles.active}")
    private String env;

    @Bean
    public DataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource(dataSourceProperties.getUrl());

        log.info("Loading Datasource...");
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUsername(dataSourceProperties.getUsername());
        if(!"dev".equals(env)) {
            dataSource.setPassword(KeyDecryptHandler.decrypt(dataSourceProperties.getPassword(), secretKey));
        } else {
            dataSource.setPassword(dataSourceProperties.getPassword());
        }
        dataSource.setUrl(dataSourceProperties.getUrl());

        return dataSource;
    }
}
