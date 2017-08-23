package agendamento.transferencia.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import agendamento.transferencia.business.bean.Conta;
import agendamento.transferencia.business.bean.RetornoTransacao;
import agendamento.transferencia.business.conta.ContaBusiness;
import agendamento.transferencia.web.controller.form.FormConta;
import agendamento.transferencia.web.controller.validator.ContaFormValidator;
import agendamento.transferencia.web.util.Util;

@Controller
public class ContaController {

	@Autowired
	private ContaBusiness contaBusiness;
	@Autowired
	private ContaFormValidator contaFormValidator;
	
	@RequestMapping(value = "/contas",method = RequestMethod.GET)
	public String carregarPaginaConta(Model model){

		model.addAttribute("formConta", new FormConta(new Conta()));
		populateModelContas(model);
		
		return "pages/contas";
	}
	
	@RequestMapping(value = "/contas",method = RequestMethod.POST)
	public String cadastrarConta(@ModelAttribute("formConta") FormConta formConta, Model model, BindingResult result){
		
		contaFormValidator.validate(formConta, result);
		
		if(!result.hasErrors() && formConta != null && formConta.getConta() != null){
			
			BigDecimal saldoBigDecimal = Util.converterValorFormatoMonetario(formConta.getSaldo());
			formConta.getConta().setSaldo(saldoBigDecimal);
			RetornoTransacao retornoTransacao = contaBusiness.addConta(formConta.getConta());
			if(retornoTransacao.equals(RetornoTransacao.SUCESSO)){
				formConta = new FormConta(new Conta());
				model.addAttribute("formConta", formConta);
				model.addAttribute("resultado",retornoTransacao);
				model.addAttribute("mensagem", "Conta cadastrada com sucesso!");
				
			}else{
				model.addAttribute("resultado",retornoTransacao);
				model.addAttribute("mensagem", "Desculpe, ocorreu um erro ao cadastrar a conta! ");
			}
		}
		populateModelContas(model);
		
		return "pages/contas";
	}
	
	private void populateModelContas(Model model){

		List<Conta> contas = contaBusiness.obterListaConta();
		model.addAttribute("contas", contas);
	}
}
