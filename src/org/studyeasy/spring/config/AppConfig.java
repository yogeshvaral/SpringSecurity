package org.studyeasy.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.studyeasy.spring.DAO.AppDAOImple;

@Configuration
public class AppConfig {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_data");
		dataSource.setUsername("root");
		dataSource.setPassword("yogesh5622");
		return dataSource;
	}
	@Bean(name = "DAOBean")
	public AppDAOImple AppDAO() {
		return new AppDAOImple(getDataSource());
	}
}
