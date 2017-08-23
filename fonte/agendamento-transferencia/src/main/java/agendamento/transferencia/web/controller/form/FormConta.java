package agendamento.transferencia.web.controller.form;

import agendamento.transferencia.business.bean.Conta;

/**
 * Formulario da Conta preenchido na requisição do cadastramento de Conta.
 * 
 * @author ledzo
 *
 */
public class FormConta {
	
	public FormConta(){
		
	}
	
	/**
	 * Construtor do Formulario da Conta
	 * 
	 * @param conta
	 */
	public FormConta(Conta conta){
		this.conta = conta;
	}
	
	private Conta conta;
	private String saldo;
	
	/**
	 * Obtem a Conta
	 * @return Conta
	 */
	public Conta getConta() {
		return conta;
	}

	/**
	 * Atribui a Conta
	 * @param conta
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}


	/**
	 * Obtem o Saldo
	 * @return String
	 */
	public String getSaldo() {
		return saldo;
	}

	/**
	 * Atribui o Saldo
	 * @param saldo
	 */
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

}
