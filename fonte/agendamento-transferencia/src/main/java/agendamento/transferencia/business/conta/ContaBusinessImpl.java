package agendamento.transferencia.business.conta;

import java.math.BigDecimal;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agendamento.transferencia.business.agendamento.AgendamentoFactory;
import agendamento.transferencia.business.bean.AgendamentoTransferencia;
import agendamento.transferencia.business.bean.Conta;
import agendamento.transferencia.business.bean.RetornoTransacao;
import agendamento.transferencia.business.bean.StatusAgendamento;
import agendamento.transferencia.business.dao.JdbcAgendamentoTransferenciaDao;
import agendamento.transferencia.business.dao.JdbcContaDao;

/**
 * Classe responsavel pelos serviços de Contas, definindos para:
 * 
 * adicionar conta, obter lista de Contas, agendar transferencia, consultar agendamentos
 * buscar conta por numero e buscar conta por id;
 * 
 * */
@Service
public class ContaBusinessImpl implements ContaBusiness {
	private final Logger log = Logger.getLogger(ContaBusinessImpl.class);
	
	@Autowired
	private JdbcContaDao contaDao;
	@Autowired
	private JdbcAgendamentoTransferenciaDao agendamentoDao;
	
	@Autowired
	private AgendamentoFactory agendamentoFactory;


	/**
	 * Agenda uma Transferencia entre contas
	 * @param agendamento
	 * @return RetornoTransacao
	 */
	@Override
	public RetornoTransacao agendarTransferencia(AgendamentoTransferencia agendamento) {
		
		if(agendamento != null && agendamento.getTipo() != null){
			
			try{
				
				AgendamentoTransferencia agendamentoTransferencia = agendamentoFactory.calcularTaxaAgendamento(agendamento);
			
				if(agendamentoTransferencia != null){

					agendamentoTransferencia.setStatus(StatusAgendamento.REALIZADO);
					agendamentoDao.insert(agendamentoTransferencia);
					
					return RetornoTransacao.SUCESSO;
				}

			}catch(Exception e){
				log.error("erro ao agendar transferencia " + e);	
				return RetornoTransacao.ERRO;
			}
		}
		
		return RetornoTransacao.ERRO;
	}

	/**
	 * Adiciona uma conta ao no sistema
	 * 
	 * @param conta
	 * @return RetornoTransacao
	 */
	@Override
	public RetornoTransacao addConta(Conta conta) {
		
		if(conta !=null && conta.getNumero() != null && conta.getDono() != null){
			String numero = conta.getNumero().toUpperCase().trim();
			conta.setNumero(numero);
			String dono = conta.getDono().toUpperCase().trim();
			conta.setDono(dono);
			
			if(conta.getSaldo() == null){
				conta.setSaldo(new BigDecimal(0));
			}
			
			try{
				contaDao.insert(conta);
				
				return RetornoTransacao.SUCESSO;
				
			}catch(Exception e){
				log.error("Erro ao tentar adicionar uma conta" + e);
			}
			
		}
		
		
		return RetornoTransacao.ERRO;
	}

	/**
	 * Obtem as contas cadastradas no sistema
	 * @return List<Conta>
	 */
	@Override
	public List<Conta> obterListaConta() {
		
		try{
			List<Conta> contas = contaDao.findContas();
			
			return contas;
			
		}catch(Exception e){
			log.error("erro ao busca lista de contas " + e);
		}
		
		
		return null;
	}

	/**
	 *  Busca a Conta pelo numero da conta
	 * @param numeroConta
	 * @return Conta
	 */
	@Override
	public Conta buscarContaPorNumero(String numeroConta) {

		try{
			
			return contaDao.findByNumero(numeroConta);
			
		}catch(Exception e){
			log.error("erro ao buscar a conta por numero da conta " + e);
		}

		return null;
	}

	/**
	 * Consulta os agendamentos do sistema
	 * @return List<AgendamentoTransferencia>
	 */
	@Override
	public List<AgendamentoTransferencia> consultaAgendamentos() {

		try{
			return agendamentoDao.agendamentos();
			
		}catch(Exception e){
			log.error("Erro na consulta de agendamento de transferencia " + e);
		}
		return null;
	}


	/**
	 *  Busca a Conta pelo id da conta
	 * @param numeroConta
	 * @return Conta
	 */
	@Override
	public Conta buscarContaPorId(long id) {

		try{
			
			return contaDao.findById(id);
			
		}catch(Exception e){
			log.error("erro ao buscar a conta por id da conta " + e);
		}
		return null;
	}

}
