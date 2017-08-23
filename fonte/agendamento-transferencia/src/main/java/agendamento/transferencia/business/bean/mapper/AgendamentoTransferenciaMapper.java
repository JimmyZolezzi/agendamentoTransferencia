package agendamento.transferencia.business.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import agendamento.transferencia.business.bean.AgendamentoTransferencia;
import agendamento.transferencia.business.bean.Conta;
import agendamento.transferencia.business.bean.StatusAgendamento;
import agendamento.transferencia.business.bean.TipoTransacao;
import agendamento.transferencia.business.dao.JdbcContaDao;

/**
 * Classe responsável por mapear os dados do Agendamento vindos do banco de dados para o objeto
 * AgendamentoTransferencia
 * 
 * @author ledzo
 *
 */
@Component
public class AgendamentoTransferenciaMapper implements RowMapper<AgendamentoTransferencia> {
	
	@Autowired
	private JdbcContaDao contaDao;

	/**
	 * Mapeia o resultados de uma consulta do banco para o objeto de AgendamentoTransferencia
	 */
	@Override
	public AgendamentoTransferencia mapRow(ResultSet rs, int rowNum) throws SQLException {

		AgendamentoTransferencia agendamentoTransferencia = new AgendamentoTransferencia();
		agendamentoTransferencia.setId(rs.getLong("id"));
		long idContaOrigem = rs.getLong("id_conta_origem");
		Conta contaOrigem =  contaDao.findById(idContaOrigem);;
		agendamentoTransferencia.setContaOrigem(contaOrigem);
		long idContaDestino = rs.getLong("id_conta_destino");
		Conta contaDestino = contaDao.findById(idContaDestino);
		agendamentoTransferencia.setContaDestino(contaDestino);
		agendamentoTransferencia.setTaxa(rs.getBigDecimal("taxa"));
		agendamentoTransferencia.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));
		agendamentoTransferencia.setValor(rs.getBigDecimal("valor"));
		agendamentoTransferencia.setDataCadastro(rs.getDate("data_cadastro"));
		agendamentoTransferencia.setDataAgendamento(rs.getDate("data_agendamento"));
		agendamentoTransferencia.setStatus(StatusAgendamento.valueOf(rs.getString("status_agendamento")));
		
		return agendamentoTransferencia;
	}

}
