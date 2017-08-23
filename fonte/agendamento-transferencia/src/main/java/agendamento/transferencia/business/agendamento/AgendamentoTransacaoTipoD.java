package agendamento.transferencia.business.agendamento;

import java.math.BigDecimal;

import agendamento.transferencia.business.bean.AgendamentoTransferencia;
import agendamento.transferencia.business.bean.TipoTransacao;

/**
 * Classe que prepara o agendamento com a transação tipo D
 * 
 * @author ledzo
 *
 */
class AgendamentoTransacaoTipoD implements AgendamentoFactory {

	/**
	 * Calcula a taxa de agendamento do tipo D
	 * 
	 * Valores até $25.000 seguem a taxação tipo A
	 * Valores de $25.001 até $120.000 seguem a taxação tipo B
	 * Valores maiores que $120.000 seguem a taxação tipo C
	 * 
	 * @param agendamentoTransferencia
	 * @return AgendamentoTransferencia
	 */
	@Override
	public AgendamentoTransferencia calcularTaxaAgendamento(AgendamentoTransferencia agendamentoTransferencia) {

		if(agendamentoTransferencia != null && TipoTransacao.D.equals(agendamentoTransferencia.getTipo()) 
				&& agendamentoTransferencia.getDataCadastro() != null && agendamentoTransferencia.getDataAgendamento() != null &&
				agendamentoTransferencia.getValor() != null){
			
			BigDecimal valorTransacao = agendamentoTransferencia.getValor();
			
			if(valorTransacao.doubleValue() <= 25000){
				return new AgendamentoTransacaoTipoA().calcularTaxaAgendamento(agendamentoTransferencia);
			}
			
			if(valorTransacao.doubleValue() <= 120000){
				return new AgendamentoTransacaoTipoB().calcularTaxaAgendamento(agendamentoTransferencia);
			}
			
			return new AgendamentoTransacaoTipoC().calcularTaxaAgendamento(agendamentoTransferencia);

		}
		
		return null;
	}

}
