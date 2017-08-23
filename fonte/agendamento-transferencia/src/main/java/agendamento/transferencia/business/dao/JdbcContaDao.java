package agendamento.transferencia.business.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 import agendamento.transferencia.business.bean.Conta;

 /**
  * Classe de acesso aos dados referente a Conta
  * @author ledzo
  *
  */
@Repository
public class JdbcContaDao implements Dao {
	
	private JdbcTemplate jdbcTemplate;

	/**
	 * Atribui um data source para a criação do jdbcTemplate
	 * 
	 * @param dataSource
	 */
	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Busca  uma conta por ID
	 * 
	 * @param id
	 * @return Conta
	 */
	public Conta findById(long id){
		String sql = "select * from conta where id = ?";
		Conta conta = jdbcTemplate.queryForObject(sql,new Object[] { id },new BeanPropertyRowMapper<>(Conta.class));
		
		return conta;
	}
	/**
	 * Busca uma conta por numero
	 * 
	 * @param numero
	 * @return Conta
	 */
	public Conta findByNumero(String numero){
		String sql = "select * from conta where numero = ?";
		Conta conta = jdbcTemplate.queryForObject(sql,new Object[] { numero },new BeanPropertyRowMapper<>(Conta.class));
		
		return conta;
	}
	
	/**
	 * Busca lista de Contas cadastradas
	 * @return
	 */
	public List<Conta> findContas(){
		
		String sql = "select * from conta";
		List<Conta> contas = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Conta.class));
		
		return contas;
	}
	/**
	 * Inclui uma conta no banco de dados
	 * @param conta
	 */
	public void insert(Conta conta){

		String sql = "INSERT INTO conta (numero, dono, saldo) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {conta.getNumero(), conta.getDono(), conta.getSaldo()});

	}

}
