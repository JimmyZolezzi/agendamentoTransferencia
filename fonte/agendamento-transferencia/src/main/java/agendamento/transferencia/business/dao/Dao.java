package agendamento.transferencia.business.dao;

import javax.sql.DataSource;

/**
 * Interface dao Determina um metodo para atribuir o data source da classe 
 * e criar o jdbcTemplate
 * 
 * @author ledzo
 *
 */
public interface Dao {

	/**
	 * Atribui um data source para a criação do jdbcTemplate
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource);
	
	
}
