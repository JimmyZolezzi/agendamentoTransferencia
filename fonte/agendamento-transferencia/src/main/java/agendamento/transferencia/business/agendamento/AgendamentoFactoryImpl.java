package agendamento.transferencia.business.agendamento;

import org.springframework.stereotype.Service;

import agendamento.transferencia.business.bean.AgendamentoTransferencia;
import agendamento.transferencia.business.bean.TipoTransacao;

/**
 * Classe responsável por calcular a taxa conforme o Tipo de transferência
 * 
 * @author ledzo
 *
 */
@Service
public class AgendamentoFactoryImpl implements AgendamentoFactory {

	/**
	 * Calcula a taxa de agendamento conforme o tipo de Tansferência podendo ser:
	 * A,B,C,D
	 * 
	 * @param agendamentoTransferencia
	 * @return AgendamentoTransferencia
	 */
	@Override
	public AgendamentoTransferencia calcularTaxaAgendamento(AgendamentoTransferencia agendamentoTransferencia) {

		if(agendamentoTransferencia != null && agendamentoTransferencia.getTipo() !=null){
			TipoTransacao tipoTransacao = agendamentoTransferencia.getTipo();
			switch(tipoTransacao){
				case A:
					
					return new AgendamentoTransacaoTipoA().calcularTaxaAgendamento(agendamentoTransferencia);
				case B:
					
					return new AgendamentoTransacaoTipoB().calcularTaxaAgendamento(agendamentoTransferencia);
				case C:
					
					return new AgendamentoTransacaoTipoC().calcularTaxaAgendamento(agendamentoTransferencia);
				case D:
					
					return new AgendamentoTransacaoTipoD().calcularTaxaAgendamento(agendamentoTransferencia);
				default:
					
					return null;
			}
			
		}
		
		return null;
	}

}
