package Agenda;

import PacoteLogin.DAOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InformacoesControl {
	
	private InterfaceInformacoesDAO interfAgendaDAO = new InformacoesDAO();
	private ObservableList<Informacoes> lista = FXCollections.observableArrayList();
	private StringProperty cpf = new SimpleStringProperty();

	public void pesquisar() throws DAOException {
		String txt = this.cpf.get();
		lista.clear();
		lista.addAll(interfAgendaDAO.pesquisar(txt));

	}

	public StringProperty getCpfProperty() {
		return cpf;
	}

	public ObservableList<Informacoes> getLista() {
		return lista;
	}

}
