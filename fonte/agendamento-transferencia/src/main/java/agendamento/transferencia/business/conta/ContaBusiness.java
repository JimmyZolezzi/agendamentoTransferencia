package agendamento.transferencia.business.conta;

import java.util.List;

import org.springframework.stereotype.Service;

import agendamento.transferencia.business.bean.AgendamentoTransferencia;
import agendamento.transferencia.business.bean.Conta;
import agendamento.transferencia.business.bean.RetornoTransacao;

/**
 * Inteface de Serviços da Conta
 * Define:
 * Métodos para adicionar conta, obter lista de Contas, agendar transferencia, consultar agendamentos
 * buscar conta por numero e buscar conta por id;
 * 
 * @author ledzo
 *
 */
@Service
public interface ContaBusiness {

	/**
	 * Adiciona uma conta ao no sistema
	 * 
	 * @param conta
	 * @return RetornoTransacao
	 */
	public RetornoTransacao addConta(Conta conta);
	/**
	 * Obtem as contas cadastradas no sistema
	 * @return List<Conta>
	 */
	public List<Conta> obterListaConta();
	/**
	 * Agenda uma Transferencia entre contas
	 * @param agendamento
	 * @return RetornoTransacao
	 */
	public RetornoTransacao agendarTransferencia(AgendamentoTransferencia agendamento);
	/**
	 * Consulta os agendamentos do sistema
	 * @return List<AgendamentoTransferencia>
	 */
	public List<AgendamentoTransferencia> consultaAgendamentos();
	/**
	 *  Busca a Conta pelo numero da conta
	 * @param numeroConta
	 * @return Conta
	 */
	public Conta buscarContaPorNumero(String numeroConta);
	/**
	 *  Busca a Conta pelo id da conta
	 * @param numeroConta
	 * @return Conta
	 */
	public Conta buscarContaPorId(long id);
}
