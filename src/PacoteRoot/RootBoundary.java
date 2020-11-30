package PacoteRoot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import PacoteLogin.DAOException;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class RootBoundary implements EventHandler<ActionEvent> {

	MenuItem mnuAdicionarDent = new MenuItem("adicionar");
	MenuItem mnuExcluirDent = new MenuItem("excluir");
	
	MenuItem mnuAdicionarOper = new MenuItem("adicionar");
	MenuItem mnuExcluirOper = new MenuItem("excluir");
	
	MenuItem mnuSair = new MenuItem("sair");
	
	BorderPane Principal = new BorderPane();
	
	Button btnRemoverDent = new Button("Remover");
    Button btnGravarDent = new Button("Gravar");
    
	Button btnRemoverOper = new Button("Remover");
    Button btnGravarOper = new Button("Gravar");
    
	TextField txtCpf = new TextField();
	
	TextField txtNome = new TextField();
	TextField txtTelefone = new TextField();
	TextField txtEspecialidade = new TextField();
	
	TextField txtUsuario = new TextField();
	TextField txtSenha = new TextField();
    
    private RootControl control = new RootControl();
	
	public Pane gerarTela() {
		
		MenuBar mnuBar = new MenuBar();
		
		Menu mnuDentista = new Menu("Dentista");
		Menu mnuOperador = new Menu("Operador");
		Menu mnuSistema = new Menu("Sistema");
		
		mnuDentista.getItems().addAll(mnuAdicionarDent, mnuExcluirDent);
		mnuBar.getMenus().addAll(mnuDentista);
		
		mnuOperador.getItems().addAll(mnuAdicionarOper, mnuExcluirOper);
		mnuBar.getMenus().addAll(mnuOperador);
		
		mnuSistema.getItems().addAll(mnuSair);
		mnuBar.getMenus().addAll(mnuSistema);
		
		mnuAdicionarDent.setOnAction(this);
		mnuExcluirDent.setOnAction(this);
		
		mnuAdicionarOper.setOnAction(this);
		mnuExcluirOper.setOnAction(this);
		
		mnuSair.setOnAction(this);
		
		Principal.setTop(mnuBar);
		
		Image image;
		try {
			image = new Image ( new FileInputStream ("..\\ProjetoDentista\\img\\imagemHome.jpeg" ) );
			ImageView imageView = new ImageView ( image );
			imageView.setFitWidth(500);
			imageView.setFitHeight(400);
			Principal.setCenter(imageView);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return Principal;
		
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == mnuAdicionarDent) { 
			telaAdicionarDent();
			
		} else if (e.getTarget() == mnuExcluirDent) { 
			telaRemoverDent();
			
		} else if (e.getTarget() == mnuAdicionarOper) { 
			telaAdicionarOper();
			
		} else if (e.getTarget() == mnuExcluirOper) { 
			telaRemoverOper();
			
		} else if (e.getTarget() == btnRemoverDent) {
			try {
				control.excluirDent();
				txtCpf.clear();
			} catch (DAOException e1) {
				Alert a = new Alert(AlertType.ERROR, "Erro ao exluir o dentista");
				a.show();
				e1.printStackTrace();
			}
			
		} else if (e.getTarget() == btnGravarDent) { 
			try {
				control.adicionarDent();
				txtCpf.clear();
				txtNome.clear();
				txtTelefone.clear();
				txtEspecialidade.clear();
			} catch (DAOException e1) {
				Alert a = new Alert(AlertType.ERROR, "Erro ao adicionar o dentista, cpf ja cadastrado");
				a.show();
				e1.printStackTrace();
			}
			
		} else if (e.getTarget() == btnGravarOper) { 
			try {
				control.adicionarOper();
				txtUsuario.clear();
				txtSenha.clear();
			} catch (DAOException e1) {
				Alert a = new Alert(AlertType.ERROR, "Erro ao adicionar o operadorr");
				a.show();
				e1.printStackTrace();
			}
		} 
		
		else if (e.getTarget() == btnRemoverOper) { 
			try {
				control.removerOper();
				txtUsuario.clear();
			} catch (DAOException e1) {
				Alert a = new Alert(AlertType.ERROR, "Erro ao remover o operadorr");
				a.show();
				e1.printStackTrace();
			}
		} else if (e.getTarget() == mnuSair) { 
			System.exit(0);
		}

	}

	private void telaRemoverDent() {
		vincularCampos();
        GridPane grid = new GridPane();
        

        grid.add(new Label("Digite o cpf do dentista"), 0, 0);
        grid.add(txtCpf, 1, 0);

        grid.add(btnRemoverDent, 0, 5);
        btnRemoverDent.setOnAction(this);
        
        Principal.setCenter(grid);

	}

	private void telaAdicionarDent() {
		vincularCampos();
        GridPane grid = new GridPane();
        
        grid.add(new Label("cpf: "), 0, 0);
        grid.add(txtCpf, 1, 0);
        grid.add(new Label("Nome: "), 0, 1);
        grid.add(txtNome, 1, 1);
        grid.add(new Label("Telefone: "), 0, 2);
        grid.add(txtTelefone, 1, 2);
        grid.add(new Label("Especialidade: "), 0, 3);
        grid.add(txtEspecialidade, 1, 3);
        
        grid.add(btnGravarDent, 0, 5);
        btnGravarDent.setOnAction(this);
        
        Principal.setCenter(grid);

	}
	
	private void telaAdicionarOper() {
		vincularCampos();
		
        GridPane grid = new GridPane();
        grid.add(new Label("Usuario: "), 0, 0);
        grid.add(txtUsuario, 1, 0);
        grid.add(new Label("Senha: "), 0, 1);
        grid.add(txtSenha, 1, 1);
        grid.add(btnGravarOper, 0, 5);
        btnGravarOper.setOnAction(this);
        Principal.setCenter(grid);
		
	}

	private void telaRemoverOper() {
		vincularCampos();
		
        GridPane grid = new GridPane();
        grid.add(new Label("Digite o usuario do operador"), 0, 0);
        grid.add(txtUsuario, 1, 0);
        grid.add(btnRemoverOper, 0, 5);
        btnRemoverOper.setOnAction(this);  
        Principal.setCenter(grid);
	}

	private void vincularCampos() {
		
	    Bindings.bindBidirectional(txtCpf.textProperty(), control.getCpfProperty());
	    Bindings.bindBidirectional(txtNome.textProperty(), control.getNomeProperty());
	    Bindings.bindBidirectional(txtTelefone.textProperty(), control.getTelefoneProperty());
	    Bindings.bindBidirectional(txtEspecialidade.textProperty(), control.getEspecialidadeProperty());
	    Bindings.bindBidirectional(txtUsuario.textProperty(), control.getUsuarioProperty());
	    Bindings.bindBidirectional(txtSenha.textProperty(), control.getSenhaProperty());
		
	}
	
}
