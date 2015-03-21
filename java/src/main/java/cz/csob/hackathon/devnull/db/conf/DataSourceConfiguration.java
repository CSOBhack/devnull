package cz.csob.hackathon.devnull.db.conf;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfiguration {

	private static final Logger LOGGER = LogManager.getLogger(DataSourceConfiguration.class);

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		LOGGER.info("Initializing dataSource using HikariCP - JDBC URL = " + System.getProperty("spring.datasource.url"));

		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl(System.getProperty("spring.datasource.url"));
		config.setUsername(System.getProperty("spring.datasource.username"));
		config.setPassword(System.getProperty("spring.datasource.password"));
		config.setMaximumPoolSize(20);
		config.setIdleTimeout(30000L);
		config.setInitializationFailFast(true);

		return new HikariDataSource(config);
	}
}
