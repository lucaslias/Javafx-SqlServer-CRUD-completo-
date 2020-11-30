package Agenda;

import PacoteLogin.DAOException;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ClienteBoundary implements EventHandler<ActionEvent> {

	private TextField txtCpf = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtEnderecoRua = new TextField();
	private TextField txtEnderecoNum = new TextField();
	private TextField txtEnderecoComp = new TextField();

	private Button btnCadastrar = new Button("cadastrar o cliente");
	private Button btnApagar = new Button("excluir o cliente");

	private ClienteControl control = new ClienteControl();

	public Pane adicionarCliente() {
		vincularCampos();
		GridPane grid = new GridPane();

		grid.add(new Label("cpf: "), 0, 0);
		grid.add(txtCpf, 1, 0);

		grid.add(new Label("nome: "), 0, 1);
		grid.add(txtNome, 1, 1);

		grid.add(new Label("telefone: "), 0, 2);
		grid.add(txtTelefone, 1, 2);

		grid.add(new Label("--------- Endereço --------- "), 0, 3);

		grid.add(new Label("rua:"), 0, 4);
		grid.add(txtEnderecoRua, 1, 4);

		grid.add(new Label("numero: "), 0, 5);
		grid.add(txtEnderecoNum, 1, 5);

		grid.add(new Label("complemento:"), 0, 6);
		grid.add(txtEnderecoComp, 1, 6);

		grid.add(btnCadastrar, 0, 8);
		btnCadastrar.setOnAction(this);

		return grid;
	}

	public Pane excluirCliente() {
		vincularCampos();
		GridPane grid = new GridPane();

		grid.add(new Label("cpf: "), 0, 0);
		grid.add(txtCpf, 1, 0);

		grid.add(btnApagar, 0, 8);
		btnApagar.setOnAction(this);

		return grid;
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == btnCadastrar) {
			try {
				control.addCliente();
				txtCpf.clear();
				txtNome.clear();
				txtTelefone.clear();
				txtEnderecoRua.clear();
				txtEnderecoNum.clear();
				txtEnderecoComp.clear();
			} catch (DAOException e1) {
				Alert a = new Alert(AlertType.ERROR, "Erro ao adicionar o cliente, cpf ja cadastrado");
				a.show();
				e1.printStackTrace();
			}
		} else if (e.getTarget() == btnApagar) {
			try {
				control.rmCliente();
				txtCpf.clear();
			} catch (DAOException e1) {
				Alert a = new Alert(AlertType.ERROR, "Erro ao adicionar o cliente, cpf ja cadastrado");
				a.show();
				e1.printStackTrace();
			}

		}

	}
	
	private void vincularCampos() {
		
		Bindings.bindBidirectional(txtCpf.textProperty(), control.getCpfProperty());
	    Bindings.bindBidirectional(txtNome.textProperty(), control.getNomeProperty());
	    Bindings.bindBidirectional(txtTelefone.textProperty(), control.getTelefoneProperty());
	    Bindings.bindBidirectional(txtEnderecoRua.textProperty(), control.getEnderecoRuaProperty());
	    Bindings.bindBidirectional(txtEnderecoNum.textProperty(), control.getEnderecoNumProperty());
	    Bindings.bindBidirectional(txtEnderecoComp.textProperty(), control.getEnderecoCompProperty());
		
	}
}
