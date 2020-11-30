package Agenda;

import java.sql.SQLException;

import PacoteLogin.DAOException;

public interface InterfaceConsultaDAO {
	
	String validaCliente(Consulta c) throws SQLException;
	String validaDentista(Consulta c) throws SQLException;
	void adicionarCliente(Consulta c) throws DAOException;
	void excluirCliente(Consulta c) throws DAOException;
	String validaData(Consulta c) throws SQLException;

}
