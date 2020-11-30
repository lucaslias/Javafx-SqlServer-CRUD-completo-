package PacoteLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Singleton.ConnectionSingleton;

public class LoginDAO {
	

	public String ValidaLogin(Login c) throws DAOException {
		try {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "SELECT senha FROM operador WHERE usuario = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getUsuario());
			ResultSet rs = st.executeQuery();

			if (rs.next()) {		
				if(rs.getString("senha").equals(c.getSenha())){
						return "foi";
				}
				else {
					return "naoFoi";
				}
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return null;
		
		
	}
}
