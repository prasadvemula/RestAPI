package com.myretail.data.respository.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.myretail")
@PropertySource(value = {"classpath:cassandra.properties"})
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Autowired
    private Environment environment;

    @Override
    public String getKeyspaceName(){
        return environment.getProperty("cassandra.keyspace");
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        final CassandraClusterFactoryBean clusterBean = new CassandraClusterFactoryBean();
        clusterBean.setContactPoints(environment.getProperty("cassandra.contactpoints"));
        clusterBean.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
        return clusterBean;
    }

    @Override
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}
