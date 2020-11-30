package Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Singleton.ConnectionSingleton;
import PacoteLogin.DAOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ClienteDAO implements InterfaceClienteDAO {

	@Override
	public void adicionarCliente(Cliente c) throws DAOException {
		try {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "INSERT INTO cliente (cpf, nome, telefone, enderecoRua, enderecoNum, enderecoComp) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getCpf());
			st.setString(2, c.getNome());
			st.setString(3, c.getTelefone());
			st.setString(4, c.getEnderecoRua());
			st.setString(5, c.getEnderecoNum());
			st.setString(6, c.getEnderecoComp());
			st.executeUpdate();
			con.close();
			Alert a = new Alert(AlertType.CONFIRMATION, "o cliente foi adicionado");
			a.show();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	


	@Override
	public void excluirCliente(String cpf) throws DAOException {
		try {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "DELETE cliente WHERE cpf = ? " ;
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cpf);
			st.executeUpdate();
			con.close();	
			Alert a = new Alert(AlertType.CONFIRMATION, "o cliente foi removido");
			a.show();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

}
