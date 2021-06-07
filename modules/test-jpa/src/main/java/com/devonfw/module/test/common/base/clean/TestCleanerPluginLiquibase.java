package com.devonfw.module.test.common.base.clean;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import liquibase.Liquibase;
import liquibase.exception.DatabaseException;

/**
 * Implementation of {@link TestCleanerPlugin} base on {@link Liquibase}. It will {@link Liquibase#dropAll() clean} on
 * {@link #cleanup()}. Therefore after {@link #cleanup()} it will drop all database objects.
 */
public class TestCleanerPluginLiquibase implements TestCleanerPlugin {

  @Inject
  private Liquibase liquibase;

  /**
   * The constructor.
   */
  public TestCleanerPluginLiquibase() {

    super();
  }

  /**
   * The constructor.
   *
   * @param liquibase the {@link Liquibase} instance.
   */
  public TestCleanerPluginLiquibase(Liquibase liquibase) {

    super();
    this.liquibase = liquibase;
  }

  @Override
  public void cleanup() throws Exception {
    this.liquibase.dropAll();    
  }

}
