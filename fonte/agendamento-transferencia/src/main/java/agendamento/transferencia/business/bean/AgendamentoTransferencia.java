package agendamento.transferencia.business.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Define o objeto de Agendamento de Transferencia
 * @author ledzo
 *
 */
public class AgendamentoTransferencia implements Serializable{
	
	private static final long serialVersionUID = 9200744148825005957L;
	private long id;
	private Conta contaOrigem;
	private Conta contaDestino;
	private BigDecimal taxa;
	private Date dataCadastro;
	private Date dataAgendamento;
	private TipoTransacao tipo;
	private BigDecimal valor;
	private StatusAgendamento status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Conta getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public Conta getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}
	public BigDecimal getTaxa() {
		return taxa;
	}
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public TipoTransacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public StatusAgendamento getStatus() {
		return status;
	}
	public void setStatus(StatusAgendamento status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contaDestino == null) ? 0 : contaDestino.hashCode());
		result = prime * result + ((contaOrigem == null) ? 0 : contaOrigem.hashCode());
		result = prime * result + ((dataAgendamento == null) ? 0 : dataAgendamento.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((taxa == null) ? 0 : taxa.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendamentoTransferencia other = (AgendamentoTransferencia) obj;
		if (contaDestino == null) {
			if (other.contaDestino != null)
				return false;
		} else if (!contaDestino.equals(other.contaDestino))
			return false;
		if (contaOrigem == null) {
			if (other.contaOrigem != null)
				return false;
		} else if (!contaOrigem.equals(other.contaOrigem))
			return false;
		if (dataAgendamento == null) {
			if (other.dataAgendamento != null)
				return false;
		} else if (!dataAgendamento.equals(other.dataAgendamento))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		if (taxa == null) {
			if (other.taxa != null)
				return false;
		} else if (!taxa.equals(other.taxa))
			return false;
		if (tipo != other.tipo)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
}
