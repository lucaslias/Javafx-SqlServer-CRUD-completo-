package Agenda;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class AgendaBoundary implements EventHandler<ActionEvent> {

	MenuItem mnuAdicionarConsult = new MenuItem("Marcar consulta");
	MenuItem mnuExcluirConsult = new MenuItem("excluir uma consulta");
	
	MenuItem mnuInformacoesDent = new MenuItem("Informacoes sobre os dentistas");
	MenuItem mnuTodosHorarios = new MenuItem("Todos os horarios cadastrados");
	
	MenuItem mnuAdicionarCliente = new MenuItem("Adicionar cliente");
	MenuItem mnuExcluirCliente = new MenuItem("Excluir cliente");
	
	MenuItem mnuSair = new MenuItem("sair");
	
	Button btnRemoverConsult = new Button("Desagendar Consulta");
    Button btnGravarConsult = new Button("Agendar Consulta");
    
	Button btnRemoverCliente = new Button("Remover Cadastro");
    Button btnGravarCliente = new Button("Cadastrar Cliente");
    
    
	BorderPane Principal = new BorderPane();

	String operador1;
	TextField txtCpf = new TextField();
	TextField txtNome = new TextField();
	TextField txtTelefone = new TextField();
	TextField txtEspecialidade = new TextField();
	TextField txtUsuario = new TextField();
	TextField txtSenha = new TextField();
	
	public Pane gerarTela(String operador){
		
		operador1 = operador;
		
		MenuBar mnuBar = new MenuBar();
		
		Menu mnuConsulta = new Menu("Consulta");
		Menu mnuCliente = new Menu("Cliente");
		Menu mnuInformacoes = new Menu("Informações");
		Menu mnuSistema = new Menu("Sistema");
	
		mnuInformacoes.getItems().addAll(mnuTodosHorarios, mnuInformacoesDent);
		mnuBar.getMenus().addAll(mnuInformacoes);
		
		mnuConsulta.getItems().addAll(mnuAdicionarConsult, mnuExcluirConsult);
		mnuBar.getMenus().addAll(mnuConsulta);
		
		mnuCliente.getItems().addAll(mnuAdicionarCliente, mnuExcluirCliente);
		mnuBar.getMenus().addAll(mnuCliente);
		
		mnuSistema.getItems().addAll(mnuSair);
		mnuBar.getMenus().addAll(mnuSistema);
		
		mnuTodosHorarios.setOnAction(this);
		mnuInformacoesDent.setOnAction(this);
		mnuAdicionarConsult.setOnAction(this);
		mnuExcluirConsult.setOnAction(this);
		mnuAdicionarCliente.setOnAction(this);
		mnuExcluirCliente.setOnAction(this);
		mnuSair.setOnAction(this);
		
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
		
		Principal.setTop(mnuBar);
	
		return Principal;
		
	}

	@Override
	public void handle(ActionEvent e) {
		
		if (e.getTarget() == mnuTodosHorarios) { 
			Principal.setCenter(new InformacoesBoundary().pesquisarHorario());
			
		} else if (e.getTarget() == mnuInformacoesDent) { 
			Principal.setCenter(new InfoDentBoundary().InfosDent());
			
		} else if (e.getTarget() == mnuAdicionarConsult) { 
			Principal.setCenter(new ConsultaBoundary().adicionarConsulta(operador1));
			
		} else if (e.getTarget() == mnuExcluirConsult) { 
			Principal.setCenter(new ConsultaBoundary().excluirConsulta());
			
		} else if (e.getTarget() == mnuAdicionarCliente) { 
			Principal.setCenter(new ClienteBoundary().adicionarCliente());
		
		} else if (e.getTarget() == mnuExcluirCliente) { 
			Principal.setCenter(new ClienteBoundary().excluirCliente());
		
		} else if (e.getTarget() == mnuSair) { 
			System.exit(0);
		}

	}

	
}