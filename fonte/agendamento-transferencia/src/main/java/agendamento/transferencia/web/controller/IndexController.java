package agendamento.transferencia.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controle principal
 * 
 * @author ledzo
 *
 */
@Controller
public class IndexController {
	
	/**
	 * Abre pagina home do sistema
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public ModelAndView handleRequest(Model model) {

		return new ModelAndView("home");
	}

}
