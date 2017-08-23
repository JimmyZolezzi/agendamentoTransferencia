package agendamento.transferencia.business.agendamento;

import java.math.BigDecimal;

import agendamento.transferencia.business.bean.AgendamentoTransferencia;

/**
 * Classe que prepara o agendamento com a transação tipo C
 * 
 * @author ledzo
 *
 */
class AgendamentoTransacaoTipoC implements AgendamentoFactory  {

	/**
	 * Calcula a taxa de agendamento do tipo C
	 * 
	 * 	Maior que 30 dias da data de cadastro - 1.2% 
	 *  até 30 dias da data de cadastro - 2.1% 
	 *  até 25 dias da data de cadastro - 4.3% 
	 *  até 20 dias da data de cadastro - 5.4% 
	 *  até 15 dias da data de cadastro - 6.7% 
	 *  até 10 dias da data de cadastro - 7.4% 
	 *  até 5 dias da data de cadastro - 8.3%
	 *
	 * @param agendamentoTransferencia
	 * @return AgendamentoTransferencia
	 */
	@Override
	public AgendamentoTransferencia calcularTaxaAgendamento(AgendamentoTransferencia agendamentoTransferencia) {

		if(agendamentoTransferencia != null && agendamentoTransferencia.getDataCadastro() != null && agendamentoTransferencia.getDataAgendamento() != null &&
				agendamentoTransferencia.getValor() != null){
			
			long dataAgendamento = agendamentoTransferencia.getDataAgendamento().getTime();
			long dataCadastro = agendamentoTransferencia.getDataCadastro().getTime();
			long diferencaDatas = dataAgendamento - dataCadastro;
			long dias = diferencaDatas/(24*60*60*1000);
			boolean taxaCalculada = false;
			BigDecimal taxa = new BigDecimal(0);
			if(dias <= 5){
				taxa = agendamentoTransferencia.getValor().multiply(new BigDecimal(0.083));
				taxaCalculada = true;
			}
			if(dias <= 10 && !taxaCalculada){
				taxa = agendamentoTransferencia.getValor().multiply(new BigDecimal(0.074));
				taxaCalculada = true;
			}
			if(dias <= 15 && !taxaCalculada){
				taxa = agendamentoTransferencia.getValor().multiply(new BigDecimal(0.067));
				taxaCalculada = true;
			}
			if(dias <= 20 && !taxaCalculada){
				taxa = agendamentoTransferencia.getValor().multiply(new BigDecimal(0.054));
				taxaCalculada = true;
			}
			if(dias <= 25 && !taxaCalculada){
				taxa = agendamentoTransferencia.getValor().multiply(new BigDecimal(0.043));
				
				taxaCalculada = true;
			}
			if(dias <= 30 && !taxaCalculada){
				taxa = agendamentoTransferencia.getValor().multiply(new BigDecimal(0.021));
				taxaCalculada = true;
			}
			if(!taxaCalculada){
				taxa = agendamentoTransferencia.getValor().multiply(new BigDecimal(0.012));
				taxaCalculada = true;
			}
			agendamentoTransferencia.setTaxa(taxa);
			
			return agendamentoTransferencia;
		}
		
		return null;
	}

}
