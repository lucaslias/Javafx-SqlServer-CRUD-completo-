package Agenda;
import Singleton.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PacoteLogin.DAOException;

public class InformacoesDAO implements InterfaceInformacoesDAO {

	@Override
	public List<Informacoes> pesquisar(String txt) throws DAOException {
		List<Informacoes> lista = new ArrayList<>();
		
		try {
			
			Connection con = ConnectionSingleton.getInstance().getConnection();
			PreparedStatement st = null;
			
			if (txt != null) {	
				String sql = "SELECT consulta.dataHora, cliente.nome, consulta.procedimento, dentista.nome as nomeDent, consulta.operador_usuario\r\n"
						+ "FROM consulta INNER JOIN dentista\r\n"
						+ "ON consulta.dentista_id = dentista.id\r\n"
						+ "INNER JOIN cliente\r\n"
						+ "ON consulta.cliente_cpf = cliente.cpf\r\n"
						+ "where cliente.cpf = ? ";	
				st = con.prepareStatement(sql);
				st.setString(1, txt);
			
			} else {
				String sql = "SELECT consulta.dataHora, cliente.nome, consulta.procedimento, dentista.nome as nomeDent, consulta.operador_usuario\r\n"
						+ "FROM consulta INNER JOIN dentista\r\n"
						+ "ON consulta.dentista_id = dentista.id\r\n"
						+ "INNER JOIN cliente\r\n"
						+ "ON consulta.cliente_cpf = cliente.cpf";	
				
				st = con.prepareStatement(sql);
			}
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) { 
				Informacoes c = new Informacoes();
					c.setDataHora(rs.getString("dataHora"));
					c.setNomeCliente(rs.getString("nome"));
					c.setProcedimento(rs.getString("procedimento"));
					c.setNomeDentista(rs.getString("nomeDent"));
					c.setOperador(rs.getString("operador_usuario"));		
				lista.add(c);
			}
			con.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return lista;
	}

}
