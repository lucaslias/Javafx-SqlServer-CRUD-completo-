package Agenda;

import java.sql.SQLException;

import PacoteLogin.DAOException;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class ConsultaControl {
	
	private InterfaceConsultaDAO interfConsultaDAO = new ConsultaDAO();
	
	private StringProperty txtProcedimento = new SimpleStringProperty();
	private StringProperty txtInformacoes = new SimpleStringProperty();
	private StringProperty txtClienteCpf = new SimpleStringProperty();
	private LongProperty txtIdDentista = new SimpleLongProperty();
	private LongProperty txtHora = new SimpleLongProperty();
	String date1;
	String operador1;

	public Consulta getConsulta() { 
		Consulta c = new Consulta();
		c.setData(this.date1);
		c.setHora(this.txtHora.get());
		c.setProcedimento(this.txtProcedimento.get());
		c.setInformacoes(this.txtInformacoes.get());
		c.setIdDentista(this.txtIdDentista.get());
		c.setClienteCpf	(this.txtClienteCpf.get());
		c.setOperador(operador1);		
		return c;
	}

	public void addConsulta(String operador, String dt) throws DAOException {
		date1 = dt;
		operador1 = operador;
		Consulta c = getConsulta();
		
		try {
			
			if( (interfConsultaDAO.validaDentista(c).equals("foi") )) {
				
					if ( (interfConsultaDAO.validaCliente(c).equals("foi")	) ) {
						
						interfConsultaDAO.adicionarCliente(c);
					} 
					else {
						Alert a = new Alert(AlertType.ERROR, "cpf invalido");
						a.show();
					}
			
			}
			else {
				Alert a = new Alert(AlertType.ERROR, "dentista invalido");
				a.show();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		
	}

	public void rmConsulta(String dt) throws DAOException{
		try {
			
			date1 = dt;
			Consulta c = getConsulta();
			
			if( (interfConsultaDAO.validaData(c).equals("foi") )) {
				
					if ( (interfConsultaDAO.validaCliente(c).equals("foi")	) ) {
						
						interfConsultaDAO.excluirCliente(c);
					} 
					else {
						Alert a = new Alert(AlertType.ERROR, "não foi possivel encontrar o cliente");
						a.show();
					}
			
			}
			else {
				Alert a = new Alert(AlertType.ERROR, "a data não foi encontrada");
				a.show();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public StringProperty getTxtProcedimentoProperty() {
		return txtProcedimento;
	}

	public StringProperty getTxtInformacoesProperty() {
		return txtInformacoes;
	}

	public StringProperty getTxtClienteCpfProperty() {
		return txtClienteCpf;
	}

	public LongProperty getTxtIdDentistaProperty() {
		return txtIdDentista;
	}
	
	public LongProperty getTxtHoraProperty() {
		return txtHora;
	}
	

	




}
