package agendamento.transferencia.business.bean;

/**
 * Retorno da transacoes realizadas com o banco de dados.
 * 
 * @author ledzo
 *
 */
public enum RetornoTransacao {

	SUCESSO,
	ERRO_SEM_SALDO_DISPONIVEL,
	ERRO_CONTA_JA_CADASTRADA,
	ERRO
}
