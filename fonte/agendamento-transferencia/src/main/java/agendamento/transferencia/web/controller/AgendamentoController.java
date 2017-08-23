package agendamento.transferencia.web.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import agendamento.transferencia.business.bean.AgendamentoTransferencia;
import agendamento.transferencia.business.bean.Conta;
import agendamento.transferencia.business.bean.RetornoTransacao;
import agendamento.transferencia.business.bean.TipoTransacao;
import agendamento.transferencia.business.conta.ContaBusiness;
import agendamento.transferencia.web.controller.form.FormAgendamentoTransferencia;
import agendamento.transferencia.web.controller.validator.AgendamentoFormValidator;
import agendamento.transferencia.web.util.Util;

/**
 * Responsável por realizar o Controle de Agendamento
 * Cadastro e consulta de agendamentos
 * 
 * @author ledzo
 *
 */
@Controller
public class AgendamentoController {
	
	@Autowired
	private ContaBusiness contaBusiness;
	@Autowired
	private AgendamentoFormValidator agendamentoFormValidator;
	

	/**
	 * Carrega os dados da pagina de agendamento
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/agendamentos",method = RequestMethod.GET)
	public String carregarPaginaAgendamentos(Model model){

		model.addAttribute("formAgendamentoTransferencia", new FormAgendamentoTransferencia());
		
		popularModel(model);

		return "pages/agendamentos";
	}
	
	/**
	 * Realiza o agendamento
	 * @param formAgendamentoTransferencia
	 * @param model
	 * @param result
	 * @return String
	 */
	@RequestMapping(value = "/agendamentos",method = RequestMethod.POST)
	public String agendar(@ModelAttribute("formAgendamentoTransferencia") FormAgendamentoTransferencia formAgendamentoTransferencia, Model model, BindingResult result){
		agendamentoFormValidator.validate(formAgendamentoTransferencia, result);
		
		if(!result.hasErrors() && formAgendamentoTransferencia != null && formAgendamentoTransferencia.getNumeroContaDestino() != null
				&& formAgendamentoTransferencia.getNumeroContaOrigem() != null && formAgendamentoTransferencia.getTipoTransferencia() != null &&
				formAgendamentoTransferencia.getValor() != null) {
			
			AgendamentoTransferencia agendamentoTransferencia = new AgendamentoTransferencia();
			//contas
			Conta contaOrigem = contaBusiness.buscarContaPorNumero(formAgendamentoTransferencia.getNumeroContaOrigem());
			Conta contaDestino = contaBusiness.buscarContaPorNumero(formAgendamentoTransferencia.getNumeroContaDestino());
			agendamentoTransferencia.setContaOrigem(contaOrigem);
			agendamentoTransferencia.setContaDestino(contaDestino);
			//datas
			Date dataAgendamento = Util.converterDataDdMMyyyy(formAgendamentoTransferencia.getDataAgendamento());
			Date dataCadastro = new Date();
			agendamentoTransferencia.setDataAgendamento(dataAgendamento);
			agendamentoTransferencia.setDataCadastro(dataCadastro);
			//valor
			BigDecimal valoBigDecimal = Util.converterValorFormatoMonetario(formAgendamentoTransferencia.getValor());
			agendamentoTransferencia.setValor(valoBigDecimal);
			agendamentoTransferencia.setTipo(TipoTransacao.valueOf(formAgendamentoTransferencia.getTipoTransferencia()));

			RetornoTransacao retornoTransacao = contaBusiness.agendarTransferencia(agendamentoTransferencia);
			
			if(retornoTransacao.equals(RetornoTransacao.SUCESSO)){
				model.addAttribute("formAgendamentoTransferencia", new FormAgendamentoTransferencia());
				model.addAttribute("resultado",retornoTransacao);
				model.addAttribute("mensagem", "Agendamento realizado com sucesso!");
				
			}else{
				model.addAttribute("resultado",retornoTransacao);
				model.addAttribute("mensagem", "Desculpe, ocorreu ao fazer o agendamento.");
			}
		
		}
		
		popularModel(model);
	
		return "pages/agendamentos";

	}
	
	/**
	 * Popula os dados do formulario de agendamento no objeto de modelo
	 * @param model
	 */
	public void popularModel(Model model){
		
		List<AgendamentoTransferencia> agendamentos = contaBusiness.consultaAgendamentos();
		model.addAttribute("agendamentos", agendamentos);
		model.addAttribute("tipoTransacoes", TipoTransacao.values());
		List<Conta> contas = contaBusiness.obterListaConta();
		model.addAttribute("contas", contas);
	}
}
