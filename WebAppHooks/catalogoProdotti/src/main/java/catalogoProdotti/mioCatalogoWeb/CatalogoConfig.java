package catalogoProdotti.mioCatalogoWeb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import catalogoProdotti.mioCatalogoWeb.dao.ProdottoDAO;
import catalogoProdotti.mioCatalogoWeb.dao.ProdottoDAOimpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="catalogoProdotti.mioCatalogoWeb.controller")
@PropertySource("classpath:catalogoProdottiDB.properties")
@EnableTransactionManagement
public class CatalogoConfig {

	@Autowired
	private Environment env;
	
	
	
	
	
	
	
	
	//Adesso andiamo a mettere il Bean per la configurazione di FreeMarker
	//ed il Bean per l'accesso al DB
	
	//per freemarker
	@Bean
	public FreeMarkerViewResolver getFreeMarkerResolver() {
		
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setPrefix("");
		resolver.setSuffix(".ftl"); //ovvero l'estensione dei file che andiamo a creare
		
		return resolver;
	}
	
	
	@Bean
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		
		FreeMarkerConfigurer config = new FreeMarkerConfigurer();
		config.setTemplateLoaderPath("/WEB-INF/view/");	//dove andiamo a mettere i nostri file .ftl
		
		return config;
	}
	
	
	//CONFIG DATABASE
	//creiamo il datasource
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getRequiredProperty("catalogoProdottiDB.db.driver"));
		ds.setUrl(env.getRequiredProperty("catalogoProdottiDB.db.url"));
		ds.setUsername(env.getRequiredProperty("catalogoProdottiDB.db.username"));
		ds.setPassword(env.getRequiredProperty("catalogoProdottiDB.db.password"));
		//Questi valori verranno inseriti in un file esterno di Properties
		//per ragioni di sicurezza informatica
		
		return ds;
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setJpaVendorAdapter(adapter);
		bean.setPackagesToScan(getClass().getPackage().getName());
		
		return bean;
	}
	
	
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		return new JpaTransactionManager(getEntityManagerFactory().getObject());
	}
	
	@Bean
	public ProdottoDAO getProdottoDAO() {
		return new ProdottoDAOimpl();
	}
	
	
}
