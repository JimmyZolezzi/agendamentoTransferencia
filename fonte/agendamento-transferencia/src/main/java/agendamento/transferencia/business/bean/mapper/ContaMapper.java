package agendamento.transferencia.business.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import agendamento.transferencia.business.bean.Conta;

/**
 * Classe responsável por mapear os dados da Conta vindos do banco de dados para o objeto de
 * Conta
 * @author ledzo
 *
 */
public class ContaMapper implements RowMapper<Conta> {

	/**
	 * Mapeia o resultados de uma consulta do banco para o objeto de Conta
	 */
	@Override
	public Conta mapRow(ResultSet rs, int rowNum) throws SQLException {

		Conta conta = new Conta();
		conta.setId(rs.getLong("id"));
		conta.setDono(rs.getString("dono"));
		conta.setNumero(rs.getString("numero"));
		conta.setSaldo(rs.getBigDecimal("conta"));
		
		return conta;
	}

}
