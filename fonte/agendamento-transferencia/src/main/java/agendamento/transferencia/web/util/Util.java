package agendamento.transferencia.web.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import agendamento.transferencia.business.RegularExpressions;

/**
 *  Utilidades do sistema
 * @author ledzo
 *
 */
public class Util {

	/**
	 * Converte a data no formato dd/mm/aaaa em Date
	 * @param data
	 * @return
	 */
	public static Date converterDataDdMMyyyy(String data){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			return sdf.parse(data);
			
		}catch(Exception e){
			
		}

		return null;
	}
	
	/**
	 * Converte o valor monetario em String para Big Decimal
	 * @param valor
	 * @return BigDecimal
	 */
	public static BigDecimal converterValorFormatoMonetario(String valor){
		try{
		
			if(valor != null && valor.matches(RegularExpressions.VALOR_MONETARIO)){
				valor = valor.replaceAll("\\.","").replace(",",".");
				return new BigDecimal(valor);
			}
		
		}catch(Exception e){
			
		}
		return null;
	}
	
}
