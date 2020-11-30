package Agenda;

import java.util.List;

import PacoteLogin.DAOException;

public interface InterfaceInfoDentDAO {
	
	List<InfoDent> tabelaDent() throws DAOException;


}
