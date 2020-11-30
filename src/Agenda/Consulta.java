package Agenda;

public class Consulta {
	
	private String data;
	private long hora;
	private String procedimento;
	private String informacoes;
	private long idDentista;
	private String clienteCpf;
	private String operador;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getHora() {
		return hora;
	}
	public void setHora(long hora) {
		this.hora = hora;
	}
	public String getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	public  long getIdDentista() {
		return idDentista;
	}
	public void setIdDentista(long l) {
		this.idDentista = l;
	}
	public String getClienteCpf() {
		return clienteCpf;
	}
	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}

	

}
