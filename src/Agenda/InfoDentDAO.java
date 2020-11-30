package Agenda;
import Singleton.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PacoteLogin.DAOException;

public class InfoDentDAO implements InterfaceInfoDentDAO {

	@Override
	public List<InfoDent> tabelaDent() throws DAOException {
		List<InfoDent> lista = new ArrayList<>();
		
		try {
	
			Connection con = ConnectionSingleton.getInstance().getConnection();
			PreparedStatement st = null;
			String sql = "select * from dentista";	
			st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) { 
				InfoDent c = new InfoDent();
					c.setIdDentista(rs.getString("id"));
					c.setCpfDent(rs.getString("cpf"));
					c.setNomeDent(rs.getString("nome"));
					c.setTelefoneDentista(rs.getString("telefone"));
					c.setEspecialidadeDentista(rs.getString("especialidade"));
				lista.add(c);
			}
			con.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return lista;
	}


}
