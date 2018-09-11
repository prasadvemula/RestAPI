package com.myretail.data.respository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.myretail")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    public String getKeyspaceName(){
        return "Product";
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        final CassandraClusterFactoryBean clusterBean = new CassandraClusterFactoryBean();
        clusterBean.setContactPoints("localhost");
        clusterBean.setPort(9042);
        return clusterBean;
    }

    @Override
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}
