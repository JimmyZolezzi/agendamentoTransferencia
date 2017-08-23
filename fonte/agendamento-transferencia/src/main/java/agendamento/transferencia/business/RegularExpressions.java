package agendamento.transferencia.business;

/**
 * Classe de expressões regulares para ser utilizadas em validações do sistema
 * 
 * @author ledzo
 *
 */
public class RegularExpressions {

	public final static String VALOR_MONETARIO = "[0-9]+(\\.[0-9]{3})*(,[0-9]{1,2})?";
	public final static String NUMERO_CONTA = "[A-Za-z0-9]{5}-[A-Za-z0-9]{1}";
	public final static String NUMERO = "[0-9]+";
	public final static String NOME_COMPLETO = "([A-Za-záÁÀàãÃâÂéÉèÈêÊíÍìÌîÎóÓòÒõÕôÔúÚùÙûÛ]{2,20} ?)+";

}
