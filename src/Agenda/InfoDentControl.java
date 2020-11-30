package Agenda;

import PacoteLogin.DAOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InfoDentControl {
	
	private InterfaceInfoDentDAO interfDentDAO = new InfoDentDAO();
	private ObservableList<InfoDent> lista = FXCollections.observableArrayList();
	private StringProperty cpf = new SimpleStringProperty();

	public void pesquisar() throws DAOException {
		lista.clear();
		lista.addAll(interfDentDAO.tabelaDent());
	}
	
	public ObservableList<InfoDent> getLista() {
		return lista;
	}



}
