package com.huwang.traffic_portal.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.assertj.core.util.Strings;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

import static java.sql.Connection.TRANSACTION_READ_COMMITTED;

@SpringBootApplication
@ComponentScan(basePackages ={"com.huwang.traffic_portal"})
public class DatabaseConfig {

	private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);
	private final static String MODEL_PACKAGE = "com.huwang.traffic_portal.entity";

	@Value("${traffic.portal.database.host}")
	private String host;

	@Value("${traffic.portal.database.dbInst}")
	private String dbInst;

	@Value("${traffic.portal.database.username}")
	private String username;

	@Value("${traffic.portal.database.password}")
	private String password;

	@Value("${traffic.portal.database.driver:com.mysql.jdbc.Driver}")
	protected String driverClassName;

	@Value("${traffic.portal.database.poolPreparedStatements:true}")
	protected boolean poolPreparedStatements;

	@Value("${traffic.portal.database.validationQuery:SELECT 1}")
	protected String validationQuery;

	@Value("${traffic.portal.database.connections.initialSize:5}")
	private int initialSize;

	@Value("${traffic.portal.database.connections.maxActive:5}")
	private int maxActive;

	@Value("${traffic.portal.database.connections.minIdle:2}")
	private int minIdle;

	@Value("${traffic.portal.database.connections.maxIdle:10}")
	protected int maxIdle;

	@Value("${traffic.portal.database.connections.maxWait:500}")
	protected long maxWait;

	@Value("${traffic.portal.database.connections.minEvictableIdleTimeMillis:18000000}")
	protected long minEvictableIdleTimeMillis;

	@Value("${traffic.portal.database.connections.timeBetweenEvictionRunsMillis:18000000}")
	protected long timeBetweenEvictionRunsMillis;

	@Value("${traffic.portal.database.connections.numTestsPerEvictionRun:3}")
	protected int numTestsPerEvictionRun;

	@Value("${traffic.portal.database.connections.testOnBorrow:true}")
	protected boolean testOnBorrow;

	@Value("${traffic.portal.database.connections.testWhileIdle:true}")
	protected boolean testWhileIdle;

	@Value("${traffic.portal.database.connections.testOnReturn:true}")
	protected boolean testOnReturn;

	@Bean(destroyMethod = "destroy", name = "SessionFactory")
	@Qualifier(value = "SessionFactory")
	public FactoryBean<SessionFactory> SessionFactory() {
		return getSessionFactory(dataSource(), MODEL_PACKAGE);
	}
/*
	@Bean(name = "TransactionManager")
	@Qualifier(value = "TransactionManager")
	public PlatformTransactionManager transactionManager() throws Exception {
		return getTransactionManager(SessionFactory().getObject(), 3000);
	}
*/
	@Bean(destroyMethod = "close", name = "DataSource")
	@Primary
	public DataSource dataSource() {
		LOG.info("Connect database:{}:{}:{}", host, dbInst, username);
		return getDataSource(getConnectUrl(), username, password);
	}

	public PlatformTransactionManager getTransactionManager(@Qualifier("SessionFactory") SessionFactory sessionFactory, int txTimeout) throws Exception {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		transactionManager.setDefaultTimeout(txTimeout);
		return transactionManager;
	}

	private String getConnectUrl() {
		if (Strings.isNullOrEmpty(host) || Strings.isNullOrEmpty(dbInst) || Strings.isNullOrEmpty(username)
				|| Strings.isNullOrEmpty(password)) {
			LOG.error("{}-{}-{}-{}", host, dbInst, username, password);
			throw new IllegalArgumentException("Invalid parameter");
		}

		return new StringBuilder().append("jdbc:mysql://").append(host).append("/").append(dbInst).append("?")
				.append("useUnicode=true&characterEncoding=utf8&autoReconnect=true").toString();
	}

	public DataSource getDataSource(String dburl, String username, String password) {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setUrl(dburl);
		datasource.setUsername(username);
		datasource.setPassword(password);

		datasource.setDriverClassName(driverClassName);
		datasource.setValidationQuery(validationQuery);
		datasource.setPoolPreparedStatements(poolPreparedStatements);

		datasource.setInitialSize(initialSize);
		datasource.setMaxActive(maxActive);
		datasource.setMinIdle(minIdle);
		datasource.setMaxIdle(maxIdle);
		datasource.setMaxWait(maxWait);
		datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		datasource.setNumTestsPerEvictionRun(numTestsPerEvictionRun);

		datasource.setTestOnBorrow(testOnBorrow);
		datasource.setTestWhileIdle(testWhileIdle);
		datasource.setTestOnReturn(testOnReturn);

		datasource.setDefaultTransactionIsolation(TRANSACTION_READ_COMMITTED);
		return datasource;
	}


	public FactoryBean<SessionFactory> getSessionFactory(@Qualifier("DataSource") DataSource dataSource,
														 String... scanPackages) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan(scanPackages);
		sessionFactoryBean.setHibernateProperties(getDBProperties());

		return sessionFactoryBean;
	}

	public Properties getDBProperties() {
		Properties props = new Properties();
		props.put("hibernate.show_sql", false);
		props.put("hibernate.generate_statistics", false);
		props.put("hibernate.connection.isolation", TRANSACTION_READ_COMMITTED);
		props.put("hibernate.use_sql_comments", true);

		props.put("hibernate.connection.CharSet", "utf8");
		props.put("hibernate.connection.characterEncoding", "utf8");
		props.put("hibernate.connection.useUnicode", false);
		props.put("hibernate.autoReconnect", true);

		props.put("hibernate.cache.use_second_level_cache", false);
		props.put("hibernate.cache.use_query_cache", false);

		return props;
	}
}
