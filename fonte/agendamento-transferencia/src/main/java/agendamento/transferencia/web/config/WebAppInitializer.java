package agendamento.transferencia.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Inicializa as configurações do Spring no contexto da aplicação
 * @author ledzo
 *
 */
public class WebAppInitializer  implements WebApplicationInitializer {
	
	    public void onStartup(ServletContext container) {
	    	
	    	
	    	//Cria o Contexto da Aplicacao 
	        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

	        container.addListener(new ContextLoaderListener(rootContext));
	        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	        ctx.register(SpringWebConfig.class);
	        ctx.setServletContext(container);
	        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
	        
	        //dispatcher
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");
	      
	       
	    }
	    

}
