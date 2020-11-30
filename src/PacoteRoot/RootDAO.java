package PacoteRoot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import PacoteLogin.DAOException;
import PacoteLogin.Login;
import Singleton.ConnectionSingleton;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootDAO implements interfaceDAO{

	@Override
	public void adicionarDent(Dentista c) throws DAOException {
		try {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "INSERT INTO dentista (cpf, nome, telefone, especialidade) "
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getCpf());
			st.setString(2, c.getNome());
			st.setString(3, c.getTelefone());
			st.setString(4, c.getEspecialidade());
			st.executeUpdate();
			con.close();
			Alert a = new Alert(AlertType.CONFIRMATION, "o dentista foi adicionado");
			a.show();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
		

	@Override
	public void excluirDent(String cpf) throws DAOException {
		try {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "DELETE dentista WHERE cpf = ? " ;
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cpf);
			st.executeUpdate();
			con.close();	
			Alert a = new Alert(AlertType.CONFIRMATION, "o dentista foi removido");
			a.show();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}



	@Override
	public void adicionarOper(Login l) throws DAOException {
		try {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "INSERT INTO operador (usuario,senha) "
					+ "VALUES (?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, l.getUsuario());
			st.setString(2, l.getSenha());
;
			st.executeUpdate();
			con.close();
			Alert a = new Alert(AlertType.CONFIRMATION, "o operador foi adicionado");
			a.show();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}



	@Override
	public void excluirOper(String usuario) throws DAOException {
		try {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "delete from operador where usuario = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, usuario);
			st.executeUpdate();
			con.close();	
			Alert a = new Alert(AlertType.CONFIRMATION, "o usuario foi removido");
			a.show();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}
		
}
	

	

