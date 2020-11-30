package Agenda;

import PacoteLogin.DAOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ClienteControl {
	
	private InterfaceClienteDAO interfAgendaDAO = new ClienteDAO();

	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty telefone = new SimpleStringProperty();
	private StringProperty enderecoRua = new SimpleStringProperty();
	private StringProperty enderecoNum = new SimpleStringProperty();
	private StringProperty enderecoComp = new SimpleStringProperty();
	
	public Cliente getCliente() { 
		Cliente c = new Cliente();
		c.setCpf(this.cpf.get());
		c.setNome(this.nome.get());
		c.setTelefone(this.telefone.get());
		c.setEnderecoRua(this.enderecoRua.get());
		c.setEnderecoNum(this.enderecoNum.get());
		c.setEnderecoComp(this.enderecoComp.get());
		return c;
	}

	public void addCliente() throws DAOException {
		Cliente c = getCliente();
		interfAgendaDAO.adicionarCliente(c);
	}

	public void rmCliente() throws DAOException {
		String txt = this.cpf.get();
		interfAgendaDAO.excluirCliente(txt);	
	}
	
	public StringProperty getCpfProperty() {
		return cpf;
	}

	public StringProperty getNomeProperty() {
		return nome;
	}

	public StringProperty getTelefoneProperty() {
		return telefone;
	}

	public StringProperty getEnderecoRuaProperty() {
		return enderecoRua;
	}

	public StringProperty getEnderecoNumProperty() {
		return enderecoNum;
	}

	public StringProperty getEnderecoCompProperty() {
		return enderecoComp;
	}

}
