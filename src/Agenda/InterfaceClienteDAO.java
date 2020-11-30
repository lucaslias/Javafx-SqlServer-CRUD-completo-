package Agenda;

import PacoteLogin.DAOException;

public interface InterfaceClienteDAO {
	
	void adicionarCliente(Cliente c) throws DAOException;
	void excluirCliente(String cpf) throws DAOException;

}
