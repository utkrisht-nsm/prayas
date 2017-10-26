package com.prayas.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.prayas.repository")
public class CassandraConfiguration extends AbstractCassandraConfiguration {

  @Value("${cassandra.contactpoints}")
  private String contactPoints;

  @Value("${cassandra.port}")
  private int cassandraPort;

  @Value("${cassandra.keyspace}")
  private String keyspaceName;

  @Value("${cassandra.basepackage}")
  private String basePackage;

  @Override
  protected String getKeyspaceName() {
    return keyspaceName;
  }

  @Override
  protected String getContactPoints() {
    return contactPoints;
  }

  @Override
  protected int getPort() {
    return cassandraPort;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.CREATE_IF_NOT_EXISTS;
  }

  @Override
  public String[] getEntityBasePackages() {
    return new String[] {basePackage};
  }

  @Override
  protected List<String> getStartupScripts() {

    String script = "CREATE KEYSPACE IF NOT EXISTS " + keyspaceName + " "
      + "WITH durable_writes = true "
      + "AND replication = { 'replication_factor' : 1, 'class' : 'SimpleStrategy' };";

    return Arrays.asList(script);
  }

  @Override
  protected List<String> getShutdownScripts() {
    return Arrays.asList("DROP KEYSPACE " + keyspaceName + ";");
  }


}
