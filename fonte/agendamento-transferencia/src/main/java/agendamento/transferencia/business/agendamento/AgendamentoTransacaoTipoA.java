package agendamento.transferencia.business.agendamento;

import java.math.BigDecimal;

import agendamento.transferencia.business.bean.AgendamentoTransferencia;

/**
 * Classe responsável por preparar as transações do Tipo A
 * @author ledzo
 *
 */
class AgendamentoTransacaoTipoA implements AgendamentoFactory{

	/**
	 * Calcula a taxa de agendamento do tipo A
	 * Operações do tipo A tem uma taxa de $2 mais 3% do valor da transferência.
	 * @param agendamentoTransferencia
	 * @return AgendamentoTransferencia
	 */
	@Override
	public AgendamentoTransferencia calcularTaxaAgendamento(AgendamentoTransferencia agendamentoTransferencia) {

		if(agendamentoTransferencia != null && agendamentoTransferencia.getValor() != null){
		
			BigDecimal valorTransferencia = agendamentoTransferencia.getValor();
			BigDecimal valorTaxa = valorTransferencia.multiply(new BigDecimal(0.03)).add(new BigDecimal(2));
			agendamentoTransferencia.setTaxa(valorTaxa);
			
			return agendamentoTransferencia;
			
		}
		return null;
	}

}
