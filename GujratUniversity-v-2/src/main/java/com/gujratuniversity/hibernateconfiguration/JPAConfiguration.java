package com.gujratuniversity.hibernateconfiguration;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.gujratuniversity.domain.Candidate;
import com.gujratuniversity.domain.EntranceExam;
import com.gujratuniversity.domain.Institute;

public class JPAConfiguration {
	
	
	
	public EntityManager createEntityManager(String dbUrl, String dbUser, String dbPassword) {

		Properties props = new Properties();
		props.put("hibernate.connection.url", dbUrl);
		props.put("hibernate.connection.username", dbUser);
		/*if (StringUtils.hasText(dbPassword)) {
			props.put("hibernate.connection.password", dbPassword);
		}*/
		
		props.put("hibernate.connection.password", "");
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
		props.put("hibernate.temp.use_jdbc_metadata_defaults", false);
		props.put("hibernate.show_sql", true);
		props.put("hibernate.format_sql", true);
		// At first time of program run
		props.put("hibernate.hbm2ddl.auto", "create-drop");
	
		//once tables are auto generated
//		props.put("hibernate.hbm2ddl.auto", "update");
		PersistenceUnitInfo persistenceUnitInfo = new PersistenceUnitInfo() {

			@Override
			public Properties getProperties() {
				return props;
			}

			@Override
			public List<String> getManagedClassNames() {
				return Arrays.asList(Candidate.class.getName(), 
									 EntranceExam.class.getName(), 
									 Institute.class.getName()
						);
			}

			@Override
			public String getPersistenceUnitName() {
				return "TestUnit";
			}

			@Override
			public String getPersistenceProviderClassName() {
				return HibernatePersistenceProvider.class.getName();
			}

			@Override
			public PersistenceUnitTransactionType getTransactionType() {
				return null;
			}

			@Override
			public DataSource getJtaDataSource() {
				return null;
			}

			@Override
			public DataSource getNonJtaDataSource() {
				return null;
			}

			@Override
			public List<String> getMappingFileNames() {
				return null;
			}

			@Override
			public List<URL> getJarFileUrls() {
				return null;
			}

			@Override
			public URL getPersistenceUnitRootUrl() {
				return null;
			}

			@Override
			public boolean excludeUnlistedClasses() {
				return false;
			}

			@Override
			public SharedCacheMode getSharedCacheMode() {
				return null;
			}

			@Override
			public ValidationMode getValidationMode() {
				return null;
			}

			@Override
			public String getPersistenceXMLSchemaVersion() {
				return null;
			}

			@Override
			public ClassLoader getClassLoader() {
				return null;
			}

			@Override
			public void addTransformer(ClassTransformer transformer) {

			}

			@Override
			public ClassLoader getNewTempClassLoader() {
				return null;
			}
		};

		HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();

		EntityManagerFactory entityManagerFactory = hibernatePersistenceProvider
				.createContainerEntityManagerFactory(persistenceUnitInfo, Collections.EMPTY_MAP);

		return entityManagerFactory.createEntityManager();

	}

}
