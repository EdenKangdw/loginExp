package com.example.demo.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // spring boo는 이 어노테이션이 달린 java파일을 설정파일로 인식한다. 
@PropertySource("classpath:/application.properties") // 사용할 properties 파일 경로 지정
public class DBconf {
	

		@Autowired
		private ApplicationContext applicationContext;

		@Bean
		@ConfigurationProperties(prefix = "spring.datasource.hikari") // 이 접두로 시작하는 모든 설정파일을 가져와서 적용한다. 
		public HikariConfig hikariConfig() {
			return new HikariConfig();
		}

		@Bean
		public DataSource dataSource() {
			return new HikariDataSource(hikariConfig());
		}

		@Bean
		public SqlSessionFactory sqlSessionFactory() throws Exception {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			factoryBean.setDataSource(dataSource());
			// mapper.xml 인식 
			factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
			return factoryBean.getObject();
		}

		@Bean
		public SqlSessionTemplate sqlSession() throws Exception {
			return new SqlSessionTemplate(sqlSessionFactory());
		}

	

}
