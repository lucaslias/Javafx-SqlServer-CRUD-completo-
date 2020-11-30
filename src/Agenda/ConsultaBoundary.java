package Agenda;

import java.time.format.DateTimeFormatter;

import PacoteLogin.DAOException;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;

public class ConsultaBoundary implements EventHandler<ActionEvent> {

	private TextField txtProcedimento = new TextField();
	private TextField txtInformacoes= new TextField();
	private TextField txtIdDentista = new TextField();
	private TextField txtClienteCpf = new TextField();
	private TextField txtHora = new TextField();
	
	private DatePicker datePicker = new DatePicker();
	private String dt;

	
	private String operador1;


	private Button btnCadastrar = new Button("Marcar a consulta");
	private Button btnApagar = new Button("Desmarcar a consulta");

	private ConsultaControl control = new ConsultaControl();

	public Pane adicionarConsulta(String operador) {
		vincularCampos();
		operador1 = operador;
		
		GridPane grid = new GridPane();

		grid.add(new Label("data: "), 0, 0);
		grid.add(datePicker, 1, 0);
		
		grid.add(new Label("hora: "), 2, 0);
		grid.add(txtHora, 3, 0);
	
		grid.add(new Label("procedimento: "), 0, 1);
		grid.add(txtProcedimento, 1, 1);

		grid.add(new Label("informações: "), 0, 2);
		grid.add(txtInformacoes, 1, 2);

		grid.add(new Label("CPF do cliente: "), 0, 5);
		grid.add(txtClienteCpf, 1, 5);

		grid.add(new Label("ID dentista:"), 0, 4);
		grid.add(txtIdDentista, 1, 4);
		
		grid.add(btnCadastrar, 0, 8);
		btnCadastrar.setOnAction(this);

		return grid;
	}

	public Pane excluirConsulta() {
		vincularCampos();
		
		GridPane grid = new GridPane();
		grid.add(new Label("CPF do cliente: "), 0, 0);
		grid.add(txtClienteCpf, 1, 0);
		
		grid.add(new Label("data: "), 0, 1);
		grid.add(datePicker, 1, 1);
		
		grid.add(new Label("hora: "), 0, 2);
		grid.add(txtHora, 1, 2);
		
		grid.add(btnApagar, 0, 8);
		btnApagar.setOnAction(this);
		return grid;
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == btnCadastrar) {
			try {
				dt = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				control.addConsulta(operador1, dt);
				txtProcedimento.clear();
				txtInformacoes.clear();
				txtIdDentista.clear();
				txtClienteCpf.clear();
				txtHora .clear();
			} catch (DAOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getTarget() == btnApagar) {
			try {
				dt = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				control.rmConsulta(dt);
				txtClienteCpf.clear();
				txtHora .clear();
			} catch (DAOException e1) {
				Alert a = new Alert(AlertType.ERROR, "Erro ao desmarcar a consulta, cpf ou data invalida");
				a.show();
				e1.printStackTrace();
			}

		}

	}
	
	private void vincularCampos() {
		StringConverter<? extends Number> converter = new LongStringConverter();
		
		Bindings.bindBidirectional(txtProcedimento.textProperty(), control.getTxtProcedimentoProperty());
	    Bindings.bindBidirectional(txtInformacoes.textProperty(), control.getTxtInformacoesProperty());
	    Bindings.bindBidirectional(txtClienteCpf.textProperty(), control.getTxtClienteCpfProperty());
        Bindings.bindBidirectional(txtIdDentista.textProperty(),control.getTxtIdDentistaProperty(),(StringConverter<Number>)converter);
        Bindings.bindBidirectional(txtHora.textProperty(),control.getTxtHoraProperty(),(StringConverter<Number>)converter);
	}
}
