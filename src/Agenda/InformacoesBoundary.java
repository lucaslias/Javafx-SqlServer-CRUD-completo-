package Agenda;

import PacoteLogin.DAOException;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class InformacoesBoundary implements EventHandler<ActionEvent> {
	
	private TextField txtCpf = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");
	
	private TableView<Informacoes> table = new TableView<>();
	
	private InformacoesControl control = new InformacoesControl();
	
	public Pane pesquisarHorario() {
		vincularCampos();
		BorderPane border = new BorderPane();
		GridPane grid = new GridPane();
		
		grid.add( (new Label("CPF:")), 0, 0);
		grid.add(txtCpf, 1, 0);
		grid.add(btnPesquisar, 2, 0);
		
		border.setTop(grid);
		border.setCenter(table);
		btnPesquisar.setOnAction(this);
		

		return border;
	}
	

	@Override
	public void handle(ActionEvent e) {
		
		if (e.getTarget() == btnPesquisar) {
			try {
				control.pesquisar();
				txtCpf.clear();
				txtCpf.setText(null);
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	private void vincularCampos() {
		Bindings.bindBidirectional(txtCpf.textProperty(), control.getCpfProperty());
		
		TableColumn<Informacoes, String> colDataHora = new TableColumn<>("Data e Hora");
		colDataHora.setMinWidth(120);
		colDataHora.setCellValueFactory( new PropertyValueFactory<Informacoes, String>("dataHora") );
      
		TableColumn<Informacoes, String> colNomeCliente = new TableColumn<>("Nome do cliente");
		colNomeCliente.setMinWidth(130);
		colNomeCliente.setCellValueFactory( new PropertyValueFactory<Informacoes, String>("nomeCliente") );
      
		TableColumn<Informacoes, String> colProcedimento = new TableColumn<>("Procedimento");
		colProcedimento.setMinWidth(140);
		colProcedimento.setCellValueFactory( new PropertyValueFactory<Informacoes, String>("Procedimento") );        
      
		TableColumn<Informacoes, String> colNomeDentista = new TableColumn<>("Nome do dentista");
		colNomeDentista.setMinWidth(110);
		colNomeDentista.setCellValueFactory( new PropertyValueFactory<Informacoes, String>("nomeDentista") );
		
		TableColumn<Informacoes, String> colOperador = new TableColumn<>("Nome do operador");
		colOperador.setMinWidth(130);
		colOperador.setCellValueFactory( new PropertyValueFactory<Informacoes, String>("operador") );
      	
      
		table.getColumns().addAll(colDataHora, colNomeCliente, colProcedimento, colNomeDentista, colOperador);
		table.setItems(control.getLista());
		
		
		
	}

}
