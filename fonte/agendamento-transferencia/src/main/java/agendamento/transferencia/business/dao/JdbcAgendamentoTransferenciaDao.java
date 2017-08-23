package agendamento.transferencia.business.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import agendamento.transferencia.business.bean.AgendamentoTransferencia;
import agendamento.transferencia.business.bean.mapper.AgendamentoTransferenciaMapper;

/**
 * 
 * @author ledzo
 * Classe de acesso aos dados referente ao Agendamento de Transferência
 */
@Repository
public class JdbcAgendamentoTransferenciaDao implements Dao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private AgendamentoTransferenciaMapper agendamentoTransferenciaMapper;
	
	
	/**
	 * Atribui um data source para a criação do jdbcTemplate
	 * 
	 * @param dataSource
	 */
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Insere no banco de dados o agendamento de transferência
	 * 
	 * @param agendamentoTransferencia
	 */
	public void insert(AgendamentoTransferencia agendamentoTransferencia){

		if(agendamentoTransferencia != null && agendamentoTransferencia.getContaDestino() != null && agendamentoTransferencia.getContaOrigem() != null &&
				agendamentoTransferencia.getValor() != null && agendamentoTransferencia.getStatus() != null && agendamentoTransferencia.getTaxa() != null){
			
			String sql = "INSERT INTO agendamento_transferencia (id_conta_origem, id_conta_destino, taxa, data_agendamento, tipo, valor, status_agendamento, data_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, new Object[] {agendamentoTransferencia.getContaOrigem().getId(), agendamentoTransferencia.getContaDestino().getId(), agendamentoTransferencia.getTaxa(),
					agendamentoTransferencia.getDataAgendamento(), agendamentoTransferencia.getTipo().name(), agendamentoTransferencia.getValor() ,agendamentoTransferencia.getStatus().name(), agendamentoTransferencia.getDataCadastro()});
			
		}

	}
	
	/**
	 * Consulta lista de agendamentos
	 * @return
	 */
	public List<AgendamentoTransferencia> agendamentos(){

		String sql = "select * from agendamento_transferencia";
		List<AgendamentoTransferencia> agendamentos = jdbcTemplate.query(sql,agendamentoTransferenciaMapper);

		return agendamentos;
	}

}
