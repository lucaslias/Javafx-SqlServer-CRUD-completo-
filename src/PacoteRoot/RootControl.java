package PacoteRoot;
import PacoteLogin.DAOException;
import PacoteLogin.Login;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class RootControl {
	
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty telefone = new SimpleStringProperty();
	private StringProperty especialidade = new SimpleStringProperty();
	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty senha = new SimpleStringProperty();
	
	private interfaceDAO rootDAO = new RootDAO();
	
	public Dentista getDentista() { 
		Dentista c = new Dentista();
		c.setCpf(this.cpf.get());
		c.setNome(this.nome.get());
		c.setTelefone(this.telefone.get());
		c.setEspecialidade(this.especialidade.get());
		return c;
	}
	
	public Login getLogin() { 
		Login l = new Login();
		l.setUsuario(this.usuario.get());
		l.setSenha(this.senha.get());
		return l;
	}
	
	public void adicionarDent() throws DAOException {
		Dentista c = getDentista();
		rootDAO.adicionarDent(c);
	}

	public void excluirDent() throws DAOException {
		System.out.println(cpf.getValue());
		String txt = this.cpf.get();
		rootDAO.excluirDent(txt);

	}
	
	public void adicionarOper() throws DAOException {
		Login l = getLogin();
		rootDAO.adicionarOper(l);
	}
	
	public void removerOper() throws DAOException {
		String txt = this.usuario.get();
		rootDAO.excluirOper(txt);	
	}
	
	

	public StringProperty getNomeProperty() {
		return nome;
	}
	
	public StringProperty getCpfProperty() {
		return cpf;
	}
	
	public StringProperty getTelefoneProperty() {
		return telefone;
	}

	public StringProperty getEspecialidadeProperty() {
		return especialidade;
	}

	public StringProperty getUsuarioProperty() {
		return usuario;
	}


	public StringProperty getSenhaProperty() {
		return senha;
	}







	






	




}
