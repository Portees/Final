package br.com.ifgoiano.usuariol.util;

import br.com.ifgoiano.usuariol.categoria.CategoriaDAO;
import br.com.ifgoiano.usuariol.categoria.CategoriaDAOHibernate;
import br.com.ifgoiano.usuariol.cheque.ChequeDAO;
import br.com.ifgoiano.usuariol.cheque.ChequeDAOHibernate;
import br.com.ifgoiano.usuariol.conta.ContaDAO;
import br.com.ifgoiano.usuariol.conta.ContaDAOHibernate;
import br.com.ifgoiano.usuariol.lancamento.LancamentoDAO;
import br.com.ifgoiano.usuariol.lancamento.LancamentoDAOHibernate;
import br.com.ifgoiano.usuariol.usuario.UsuarioDAO;
import br.com.ifgoiano.usuariol.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

	public static ContaDAO criarContaDAO() {
		ContaDAOHibernate contaDAO = new ContaDAOHibernate();
		contaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return contaDAO;
	}

	public static CategoriaDAO criarCategoriaDAO() {
		CategoriaDAOHibernate categoriaDAO = new CategoriaDAOHibernate();
		categoriaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return categoriaDAO;
	}

    public static LancamentoDAO criarLancamentoDAO() {
		LancamentoDAOHibernate lancamentoDAO = new LancamentoDAOHibernate();
		lancamentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return lancamentoDAO;
	}

public static ChequeDAO criarChequeDAO() {
		ChequeDAOHibernate chequeDAO = new ChequeDAOHibernate();
		chequeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return chequeDAO;
	}
}
