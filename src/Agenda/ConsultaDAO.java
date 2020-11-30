package Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Singleton.ConnectionSingleton;
import PacoteLogin.DAOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ConsultaDAO implements InterfaceConsultaDAO  {

	@Override
	public String validaCliente(Consulta c) throws SQLException{	
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "SELECT cpf FROM cliente WHERE cpf = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getClienteCpf());
			ResultSet rs = st.executeQuery();
		
			if (rs.next()) {
				con.close();
				return "foi";
			}else {
				con.close();
				return "naoFoi";
			}

	}

	@Override
	public String validaDentista(Consulta c) throws SQLException {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "SELECT id FROM dentista WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, c.getIdDentista());
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {	
				con.close();
				return "foi";
			}
			else {
				con.close();
				return "naoFoi";
			}
			
	
	}
			

	@Override
	public void adicionarCliente(Consulta c) throws DAOException {
		try {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "INSERT INTO consulta (dataHora, procedimento, informações, dentista_id, cliente_cpf, operador_usuario) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
					
			String dataHoraComp = (c.getData() + " " + c.getHora() + ":00" );
			
			System.out.println(dataHoraComp);
			
			st.setString(1, dataHoraComp);
			st.setString(2, c.getProcedimento());
			st.setString(3, c.getInformacoes());
			st.setLong(4, c.getIdDentista());
			st.setString(5, c.getClienteCpf());
			st.setString(6, c.getOperador());
			st.executeUpdate();
			
			con.close();
			Alert a = new Alert(AlertType.CONFIRMATION, "o horario foi agendado");
			a.show();
			
		} catch (SQLException e) {
			Alert a = new Alert(AlertType.ERROR, "o horario está indisponivel");
			a.show();
			throw new DAOException(e);
		}
		
	}
	
	@Override
	public String validaData(Consulta c) throws SQLException {
		Connection con = ConnectionSingleton.getInstance().getConnection();
		String sql = "SELECT dataHora FROM consulta WHERE dataHora = ?";
		
		String dataHoraComp = (c.getData() + " " + c.getHora() + ":00" );
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dataHoraComp);
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {	
			con.close();
			return "foi";
		}
		else {
			con.close();
			return "naoFoi";
		}
		
	}

	@Override
	public void excluirCliente(Consulta c) throws DAOException {
		try {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "DELETE consulta WHERE cliente_cpf = ? AND dataHora = ?" ;
			PreparedStatement st = con.prepareStatement(sql);
			String dataHoraComp = (c.getData() + " " + c.getHora() + ":00:000" );
			st.setString(1, c.getClienteCpf());
			st.setString(2, dataHoraComp);
			System.out.println(c.getClienteCpf() + "->> " + dataHoraComp);
			st.executeUpdate();
			
			Alert a = new Alert(AlertType.CONFIRMATION, "a consulta foi desmarcada");
			a.show();
			con.close();	

		} catch (SQLException e) {
			throw new DAOException(e);
		}

		
	}






}
