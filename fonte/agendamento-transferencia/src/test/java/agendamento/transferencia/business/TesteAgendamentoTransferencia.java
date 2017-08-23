package agendamento.transferencia.business;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import agendamento.transferencia.business.agendamento.AgendamentoFactory;
import agendamento.transferencia.business.agendamento.AgendamentoFactoryImpl;
import agendamento.transferencia.business.bean.AgendamentoTransferencia;
import agendamento.transferencia.business.bean.TipoTransacao;
import agendamento.transferencia.web.util.Util;

/**
 * Testa as funcionalidades do Agendamento Transferencia
 * @author ledzo
 *
 */
public class TesteAgendamentoTransferencia {

	/**
	 * Testa para o calculo da Taxa do tipo A de transferencia do Agendamento.
	 */
	@Test
	public void agendamentoTipoATest(){
		
		AgendamentoTransferencia agendamentoTransferenciaTipoA = new AgendamentoTransferencia();
		agendamentoTransferenciaTipoA.setValor(new BigDecimal(1000));
		agendamentoTransferenciaTipoA.setTipo(TipoTransacao.A);
		AgendamentoFactory agendamentoFactory = new AgendamentoFactoryImpl();
		agendamentoTransferenciaTipoA = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoA);
		BigDecimal valorTaxa = agendamentoTransferenciaTipoA.getTaxa();
		Assert.assertEquals(32, valorTaxa.doubleValue(), 0.00001);
	}
	
	/**
	 * Testa para o calculo da Taxa do tipo B de transferencia do Agendamento.
	 */
	@Test
	public void agendamentoTipoBTest(){
		
		AgendamentoTransferencia agendamentoTransferenciaTipoB = new AgendamentoTransferencia();
		agendamentoTransferenciaTipoB.setValor(new BigDecimal(1000));
		Date dataCadastro = Util.converterDataDdMMyyyy("23/08/2017");
		Date dataAgendamento = Util.converterDataDdMMyyyy("22/09/2017");
		agendamentoTransferenciaTipoB.setTipo(TipoTransacao.B);
		agendamentoTransferenciaTipoB.setDataCadastro(dataCadastro);
		agendamentoTransferenciaTipoB.setDataAgendamento(dataAgendamento);
		AgendamentoFactory agendamentoFactory = new AgendamentoFactoryImpl();
		agendamentoTransferenciaTipoB = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoB);
		BigDecimal valorTaxa = agendamentoTransferenciaTipoB.getTaxa();
		//Até 30 dias da data de cadastro
		Assert.assertEquals(10, valorTaxa.doubleValue(), 0.00001);
		//Acima de 30 dias
		dataAgendamento = Util.converterDataDdMMyyyy("23/09/2017");
		agendamentoTransferenciaTipoB.setDataAgendamento(dataAgendamento);
		agendamentoTransferenciaTipoB = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoB);
		valorTaxa = agendamentoTransferenciaTipoB.getTaxa();
		Assert.assertEquals(8, valorTaxa.doubleValue(), 0.00001);
	}
	
	/**
	 * Testa para o calculo da Taxa do tipo C de transferencia do Agendamento.
	 */
	@Test
	public void agendamentoTipoCTest(){
		
		AgendamentoTransferencia agendamentoTransferenciaTipoC = new AgendamentoTransferencia();
		agendamentoTransferenciaTipoC.setValor(new BigDecimal(1000));
		Date dataCadastro = Util.converterDataDdMMyyyy("23/08/2017");
		Date dataAgendamento = Util.converterDataDdMMyyyy("23/09/2017");
		agendamentoTransferenciaTipoC.setTipo(TipoTransacao.C);
		agendamentoTransferenciaTipoC.setDataCadastro(dataCadastro);
		agendamentoTransferenciaTipoC.setDataAgendamento(dataAgendamento);
		AgendamentoFactory agendamentoFactory = new AgendamentoFactoryImpl();
		agendamentoTransferenciaTipoC = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoC);
		BigDecimal valorTaxa = agendamentoTransferenciaTipoC.getTaxa();
		//Acima 30 dias da data de cadastro
		Assert.assertEquals(12, valorTaxa.doubleValue(), 0.00001);
		//Até 30 dias
		dataAgendamento = Util.converterDataDdMMyyyy("22/09/2017");
		agendamentoTransferenciaTipoC.setDataAgendamento(dataAgendamento);
		agendamentoTransferenciaTipoC = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoC);
		valorTaxa = agendamentoTransferenciaTipoC.getTaxa();
		Assert.assertEquals(21, valorTaxa.doubleValue(), 0.00001);
		//Até 25 dias
		dataAgendamento = Util.converterDataDdMMyyyy("17/09/2017");
		agendamentoTransferenciaTipoC.setDataAgendamento(dataAgendamento);
		agendamentoTransferenciaTipoC = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoC);
		valorTaxa = agendamentoTransferenciaTipoC.getTaxa();
		Assert.assertEquals(43, valorTaxa.doubleValue(), 0.00001);
		//Até 20 dias
		dataAgendamento = Util.converterDataDdMMyyyy("12/09/2017");
		agendamentoTransferenciaTipoC.setDataAgendamento(dataAgendamento);
		agendamentoTransferenciaTipoC = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoC);
		valorTaxa = agendamentoTransferenciaTipoC.getTaxa();
		Assert.assertEquals(54, valorTaxa.doubleValue(), 0.00001);
		//Até 15 dias
		dataAgendamento = Util.converterDataDdMMyyyy("7/09/2017");
		agendamentoTransferenciaTipoC.setDataAgendamento(dataAgendamento);
		agendamentoTransferenciaTipoC = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoC);
		valorTaxa = agendamentoTransferenciaTipoC.getTaxa();
		Assert.assertEquals(67, valorTaxa.doubleValue(), 0.00001);
		//Até 10 dias
		dataAgendamento = Util.converterDataDdMMyyyy("2/09/2017");
		agendamentoTransferenciaTipoC.setDataAgendamento(dataAgendamento);
		agendamentoTransferenciaTipoC = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoC);
		valorTaxa = agendamentoTransferenciaTipoC.getTaxa();
		Assert.assertEquals(74, valorTaxa.doubleValue(), 0.00001);
		//Até 5 dias
		dataAgendamento = Util.converterDataDdMMyyyy("28/08/2017");
		agendamentoTransferenciaTipoC.setDataAgendamento(dataAgendamento);
		agendamentoTransferenciaTipoC = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoC);
		valorTaxa = agendamentoTransferenciaTipoC.getTaxa();
		Assert.assertEquals(83, valorTaxa.doubleValue(), 0.00001);
		
	}
	
	/**
	 * Testa para o calculo da Taxa do tipo D de transferencia do Agendamento.
	 */
	@Test
	public void agendamentoTipoDTest(){
		AgendamentoFactory agendamentoFactory = new AgendamentoFactoryImpl();
		
		AgendamentoTransferencia agendamentoTransferenciaTipoD = new AgendamentoTransferencia();
		//Valores até 25000 tipo segue o tipo A
		agendamentoTransferenciaTipoD.setValor(new BigDecimal(25000));
		Date dataCadastro = Util.converterDataDdMMyyyy("23/08/2017");
		Date dataAgendamento = Util.converterDataDdMMyyyy("23/09/2017");
		agendamentoTransferenciaTipoD.setDataAgendamento(dataAgendamento);
		agendamentoTransferenciaTipoD.setDataCadastro(dataCadastro);
		agendamentoTransferenciaTipoD.setTipo(TipoTransacao.D);
		agendamentoTransferenciaTipoD = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoD);
		BigDecimal valorTaxa = agendamentoTransferenciaTipoD.getTaxa();
		Assert.assertEquals(752, valorTaxa.doubleValue(), 0.00001);
		//Valores  25001 até 120.000  tipo segue o tipo B
		agendamentoTransferenciaTipoD.setValor(new BigDecimal(25001));
		agendamentoTransferenciaTipoD = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoD);
		valorTaxa = agendamentoTransferenciaTipoD.getTaxa();
		Assert.assertEquals(8, valorTaxa.doubleValue(), 0.00001);
		//Valores acima 120.000  tipo segue o tipo C
		agendamentoTransferenciaTipoD.setValor(new BigDecimal(120001));
		agendamentoTransferenciaTipoD = agendamentoFactory.calcularTaxaAgendamento(agendamentoTransferenciaTipoD);
		valorTaxa = agendamentoTransferenciaTipoD.getTaxa();
		Assert.assertEquals(1440.012, valorTaxa.doubleValue(), 0.00001);
	}
	
}
