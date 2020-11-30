package Agenda;

import java.util.List;

import PacoteLogin.DAOException;

public interface InterfaceInformacoesDAO {

	List<Informacoes> pesquisar(String nome) throws DAOException;

}
