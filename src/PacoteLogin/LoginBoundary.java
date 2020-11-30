package PacoteLogin;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginBoundary extends Application implements EventHandler<ActionEvent> {
	
	private TextField txtUsuario = new TextField();
	private TextField txtSenha = new TextField();
	private Button btnEntrar = new Button("Entrar");

	private LoginControl control = new LoginControl();
	
	private BorderPane panePrincipal = new BorderPane();
	
	
	public void start(Stage stage) throws Exception { 
		
		Scene scn = new Scene(panePrincipal, 640, 480);
        GridPane paneCampos = new GridPane();
        paneCampos.add(new Label("ID"), 0, 0);
        paneCampos.add(txtUsuario, 1, 0);
        paneCampos.add(new Label("senha"), 0, 1);
        paneCampos.add(txtSenha, 1, 1);
        
        paneCampos.add(btnEntrar, 1, 2);
        btnEntrar.setOnAction(this);
        
    	vincularCampos();
        paneCampos.setAlignment(Pos.CENTER);
        panePrincipal.setCenter(paneCampos);
        
		stage.setScene(scn);
		stage.setTitle("Agenda Dentista");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(LoginBoundary.class,args);
	}

	
	public void vincularCampos() { 
        Bindings.bindBidirectional(txtUsuario.textProperty(), control.getUsuarioProperty());
        Bindings.bindBidirectional(txtSenha.textProperty(), control.getSenhaProperty());
  
	}

	@Override
	public void handle(ActionEvent e) {
		if (btnEntrar == e.getTarget()) {		
				try {
					control.logar(panePrincipal);
				} catch (Exception e1) {
					Alert a = new Alert(AlertType.ERROR, "usuario não encontrado");
					a.show();
					e1.printStackTrace();
				}
					
		} 
	}
}