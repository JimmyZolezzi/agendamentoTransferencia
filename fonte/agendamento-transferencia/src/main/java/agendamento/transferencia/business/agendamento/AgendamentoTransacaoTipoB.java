package agendamento.transferencia.business.agendamento;

import java.math.BigDecimal;
import agendamento.transferencia.business.bean.AgendamentoTransferencia;

/**
 * Classe responsável por preparar o agendamento da transação do Tipo B
 * @author ledzo
 *
 */
class AgendamentoTransacaoTipoB implements AgendamentoFactory {

	/**
	 * Calcula a taxa de agendamento do tipo B
	 * 
	 * Operações do tipo B tem uma taxa de: $10 para pedidos com agendamento até 30 dias da data de cadastro $8 para os demais
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
			if(dias <= 30){
				agendamentoTransferencia.setTaxa(new BigDecimal(10));
			}else{
				agendamentoTransferencia.setTaxa(new BigDecimal(8));
			}
			
			return agendamentoTransferencia;
		}
			
		return null;
	}

}
