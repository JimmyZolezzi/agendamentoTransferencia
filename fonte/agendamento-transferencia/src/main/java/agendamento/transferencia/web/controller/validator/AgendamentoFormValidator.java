package agendamento.transferencia.web.controller.validator;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import agendamento.transferencia.business.RegularExpressions;
import agendamento.transferencia.web.controller.form.FormAgendamentoTransferencia;
import agendamento.transferencia.web.util.Util;

/**
 * Validação do formulario de Agendamento
 * @author ledzo
 *
 */
@Component
public class AgendamentoFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return FormAgendamentoTransferencia.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		FormAgendamentoTransferencia formAgendamentoTransferencia = (FormAgendamentoTransferencia) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numeroContaOrigem", "NotEmpty.formAgendamento.numeroContaOrigem");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numeroContaDestino", "NotEmpty.formAgendamento.numeroContaDestino");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataAgendamento", "NotEmpty.formAgendamento.dataAgendamento");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valor", "NotEmpty.formAgendamento.valor");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipoTransferencia", "NotEmpty.formAgendamento.tipoTransferencia");
		
		if(formAgendamentoTransferencia != null){
			
			
			String valor = formAgendamentoTransferencia.getValor();
			//Valida o valor monetario
			if(valor != null && !valor.equals("") 
					&& !valor.matches(RegularExpressions.VALOR_MONETARIO)){
				//Valor Monetário no formato inválido
				errors.rejectValue("valor", "InvalidFormat.formAgendamento.valor");
			}else{
				if(!valor.isEmpty()){
					BigDecimal valorMonetario = Util.converterValorFormatoMonetario(valor);
					if(valorMonetario == null || valorMonetario.doubleValue() == 0){
						//Valor menor que zero
						errors.rejectValue("valor", "InvalidValue.formAgendamento.valorMaiorZero");
					}
				}
			}
			
			if(valor != null && valor.length() > 14){
				//Tamanho do valor ultrapassa o maximo permitido
				errors.rejectValue("valor", "InvalidSize.formAgendamento.valor");
			}
			String numeroContaOrigem = formAgendamentoTransferencia.getNumeroContaOrigem();
			String numerContaDestino = formAgendamentoTransferencia.getNumeroContaDestino();
			if(numeroContaOrigem != null && !numeroContaOrigem.equals("") && numerContaDestino != null && numeroContaOrigem.equals(numerContaDestino)){
				errors.rejectValue("numeroContaDestino", "contaDestinoIgualOrigem.formAgendamento.numeroContaDestino");
			}
			String dataAgendamentoString = formAgendamentoTransferencia.getDataAgendamento();
			Date dataAgendamento = Util.converterDataDdMMyyyy(dataAgendamentoString);
			if(dataAgendamentoString != null && !dataAgendamentoString.equals("")){
				if(dataAgendamento == null){
					//data no formato inválido
					errors.rejectValue("dataAgendamento", "invalidDate.formAgendamento.dataAgendamento");
				}else{
					Date dateAtual = new Date();
					if(dataAgendamento.getTime() <= dateAtual.getTime()){
						//data de agendamento menor que a atual
						errors.rejectValue("dataAgendamento", "invalidDate.formAgendamento.dataAgendamentoMenorQueAtual");
					}
				}
			}
		}
	}

}
