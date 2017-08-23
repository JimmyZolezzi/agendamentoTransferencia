package agendamento.transferencia.web.controller.form;

/**
 * Formulario de agendamento de transferência preenchido na requisição do agendamento
 * 
 * @author ledzo
 *
 */
public class FormAgendamentoTransferencia {
	
	private String numeroContaOrigem;
	private String numeroContaDestino;
	private String dataAgendamento;
	private String valor;
	private String tipoTransferencia;

	/**
	 * Obtem o numero da conta de origem
	 * @return String
	 */
	public String getNumeroContaOrigem() {
		return numeroContaOrigem;
	}
	/**
	 * Atribui o numero da Conta de Origem
	 * 
	 * @param numeroContaOrigem
	 */
	public void setNumeroContaOrigem(String numeroContaOrigem) {
		this.numeroContaOrigem = numeroContaOrigem;
	}
	/**
	 * Obtem o numero da Conta de Destino
	 * @return String
	 */
	public String getNumeroContaDestino() {
		return numeroContaDestino;
	}
	/**
	 *  Atribui o numero da Conta de Destino
	 * @param numeroContaDestino
	 */
	public void setNumeroContaDestino(String numeroContaDestino) {
		this.numeroContaDestino = numeroContaDestino;
	}
	/**
	 * Obtem a data de agendamento
	 * @return
	 */
	public String getDataAgendamento() {
		return dataAgendamento;
	}
	/**
	 * Atribui a data de agendamento
	 * 
	 * @param dataAgendamento
	 */
	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	/**
	 * Obterm o valor do agendamento
	 * @return
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * Atribui o valor do Agendamento
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	/**
	 * Obtem o Tipo de Transferência
	 * @return
	 */
	public String getTipoTransferencia() {
		return tipoTransferencia;
	}
	/**
	 * Atribui o Tipo de Transferência
	 * @param tipoTransferencia
	 */
	public void setTipoTransferencia(String tipoTransferencia) {
		this.tipoTransferencia = tipoTransferencia;
	}
	

}
