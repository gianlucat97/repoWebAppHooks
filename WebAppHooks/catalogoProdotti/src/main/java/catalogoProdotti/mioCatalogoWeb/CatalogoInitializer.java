package catalogoProdotti.mioCatalogoWeb;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CatalogoInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {CatalogoConfig.class};
		//ritorna la classe che contiene le nostre Configurazioni
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};		//in questo modo la servlet servirà tutte le richieste in ingresso
		//ovvero tutto passa prima da questa Servlet
	}

	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		DispatcherServlet ds = new DispatcherServlet(servletAppContext);
		ds.setThrowExceptionIfNoHandlerFound(true);
		return ds;
	}
	
	

}
