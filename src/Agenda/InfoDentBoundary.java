package Agenda;

import PacoteLogin.DAOException;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class InfoDentBoundary{
	
	private TableView<InfoDent> table = new TableView<>();
	
	private InfoDentControl control = new InfoDentControl();
	
	public Pane InfosDent() {
		vincularCampos();
		
		BorderPane border = new BorderPane();
		
		try {
			control.pesquisar();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		border.setCenter(table);

		return border;
	}
	

	private void vincularCampos() {
		
		TableColumn<InfoDent, Integer> colIdDentista = new TableColumn<>("Id dentista");
		colIdDentista.setMinWidth(120);
		colIdDentista.setCellValueFactory( new PropertyValueFactory<InfoDent, Integer>("idDentista") );
		
		TableColumn<InfoDent, String> colCpfDentista = new TableColumn<>("Cpf");
		colCpfDentista.setMinWidth(130);
		colCpfDentista.setCellValueFactory( new PropertyValueFactory<InfoDent, String>("cpfDent") );	
      
		TableColumn<InfoDent, String> colNomeDentista = new TableColumn<>("nome");
		colNomeDentista.setMinWidth(140);
		colNomeDentista.setCellValueFactory( new PropertyValueFactory<InfoDent, String>("nomeDent") );      
      
		TableColumn<InfoDent, String> colTelefoneDentista = new TableColumn<>("telefone");
		colTelefoneDentista.setMinWidth(110);
		colTelefoneDentista.setCellValueFactory( new PropertyValueFactory<InfoDent, String>("telefoneDentista") );
		
		TableColumn<InfoDent, String> colEspecDentista = new TableColumn<>("especialidade");
		colEspecDentista.setMinWidth(130);
		colEspecDentista.setCellValueFactory( new PropertyValueFactory<InfoDent, String>("especialidadeDentista") );
      	
		table.getColumns().addAll(colIdDentista, colCpfDentista, colNomeDentista, colTelefoneDentista, colEspecDentista);
		table.setItems(control.getLista());
		
	}

}
