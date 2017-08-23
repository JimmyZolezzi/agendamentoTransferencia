package agendamento.transferencia.business.agendamento;
/**
 * 
 * @author ledzo
 *
 */
import agendamento.transferencia.business.bean.AgendamentoTransferencia;

/**
 * Interface que o método de calculo de taxa do agendamento
 * @author ledzo
 *
 */
public interface AgendamentoFactory{
	
	/**
	 * Calcula a taxa de agendamento conforme o tipo de Tansferência podendo ser:
	 * A,B,C,D
	 * 
	 * @param agendamentoTransferencia
	 * @return AgendamentoTransferencia
	 */
	public AgendamentoTransferencia calcularTaxaAgendamento(AgendamentoTransferencia agendamentoTransferencia);
	
}
