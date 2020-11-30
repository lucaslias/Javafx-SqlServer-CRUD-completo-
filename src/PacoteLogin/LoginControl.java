package PacoteLogin;
import Agenda.AgendaBoundary;
import PacoteRoot.RootBoundary;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;


public class LoginControl {
	
	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty senha = new SimpleStringProperty();

	
	private LoginDAO LoginDAO = new LoginDAO();
	
	
	public Login getLogin() { 
		Login c = new Login();
		c.setUsuario(this.usuario.get());
		c.setSenha(this.senha.get());
		return c;
	}
	
	public void logar(BorderPane panePrincipal) throws DAOException {
		Login c = getLogin();
		String operador = c.getUsuario();
		String valida = LoginDAO.ValidaLogin(c);
		
		if (valida.equals("foi")) {
			if (c.getUsuario().equals("root")){
				panePrincipal.setCenter(new RootBoundary().gerarTela());
			}
			else {			
				panePrincipal.setCenter(new AgendaBoundary().gerarTela(operador));
			}
		}
		else {
			Alert a = new Alert(AlertType.ERROR, "senha invalida");
			a.show();
		}
	}
	
	public StringProperty getUsuarioProperty() {
		return usuario;
	}
	public StringProperty getSenhaProperty() {
		return senha;
	}
	
}
