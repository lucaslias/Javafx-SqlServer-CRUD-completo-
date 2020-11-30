package PacoteRoot;
import PacoteLogin.DAOException;
import PacoteLogin.Login;


public interface interfaceDAO {
	
	void adicionarDent(Dentista c) throws DAOException;
	void excluirDent(String cpf) throws DAOException;
	void adicionarOper(Login l) throws DAOException;
	void excluirOper(String usuario) throws DAOException;
	

}
