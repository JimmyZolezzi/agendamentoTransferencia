package agendamento.transferencia.web.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import agendamento.transferencia.business.RegularExpressions;
import agendamento.transferencia.business.bean.Conta;
import agendamento.transferencia.business.conta.ContaBusiness;
import agendamento.transferencia.web.controller.form.FormConta;

/**
 * Classe de validação do Formulario de Conta
 * @author ledzo
 *
 */
@Component
public class ContaFormValidator implements Validator {
	
	@Autowired
	private ContaBusiness contaBusiness;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return FormConta.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		FormConta formConta = (FormConta) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "conta.numero", "NotEmpty.formConta.numero");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "conta.dono", "NotEmpty.formConta.dono");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "saldo", "NotEmpty.formConta.saldo");
		
		if(formConta != null){
			String numeroConta = formConta.getConta().getNumero();
			if(numeroConta != null && !numeroConta.equals("")){
				//valida conta no formato XXXXX-XX
				if(!numeroConta.matches(RegularExpressions.NUMERO_CONTA)){
					
					errors.rejectValue("conta.numero", "InvalidFormat.formConta.numero");
				}else{
					//Verifica conta já cadastrada
					Conta conta = contaBusiness.buscarContaPorNumero(numeroConta);
					if(conta != null){
						errors.rejectValue("conta.numero", "InvalidAccountformConta.numero.cadastrado");
					}
				}
			}
			
			String saldo = formConta.getSaldo();
			if(saldo != null && !saldo.equals("") 
					&& !formConta.getSaldo().matches(RegularExpressions.VALOR_MONETARIO)){
				errors.rejectValue("saldo", "InvalidFormat.formConta.saldo");
			}
			if(saldo != null && saldo.length() > 14){
				errors.rejectValue("saldo", "InvalidSize.formConta.saldo");
			}
			
			String dono = formConta.getConta().getDono();
			if(dono != null && !dono.equals("") && !dono.matches(RegularExpressions.NOME_COMPLETO)){
				errors.rejectValue("conta.dono", "InvalidFormat.formConta.dono");
			}
			if(dono != null && !dono.equals("") && dono.length() > 45){
				errors.rejectValue("conta.dono", "InvalidSize.formConta.dono");
			}
		}
		
		
	}
	
}
