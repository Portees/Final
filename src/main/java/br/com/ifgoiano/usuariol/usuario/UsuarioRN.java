package br.com.ifgoiano.usuariol.usuario;

import java.util.List;
import java.util.Locale;

import br.com.ifgoiano.usuariol.categoria.CategoriaRN;
import br.com.ifgoiano.usuariol.util.DAOFactory;
import br.com.ifgoiano.usuariol.util.RNException;
import br.com.ifgoiano.usuariol.util.UtilException;
import br.com.ifgoiano.usuariol.web.util.EmailUtil;
import br.com.ifgoiano.usuariol.web.util.GmailUtil;
import br.com.ifgoiano.usuariol.web.util.MensagemUtil;

public class UsuarioRN {
	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			usuario.getPermissao().add("ROLE_USUARIO");
			this.usuarioDAO.salvar(usuario);
			CategoriaRN categoriaRN = new CategoriaRN();
			categoriaRN.salvaEstruturaPadrao(usuario);
		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void enviarEmailPosCadastramento(Usuario usuario) throws RNException {
		// Enviando um e-mail conforme o idioma do usuario
		String[] info = usuario.getIdioma().split("_");
		Locale locale = new Locale(info[0], info[1]);
		String titulo = MensagemUtil.getMensagem(locale, "email_titulo");
		String mensagem = MensagemUtil.getMensagem(locale, "email_mensagem", usuario.getNome(), usuario.getLogin(),
				usuario.getSenha());
		try {
			GmailUtil emailUtil = new GmailUtil();
			emailUtil.enviarEmail("ifgoianotestemail@gmail.com", usuario.getEmail(), titulo, mensagem);
		} catch (UtilException e) {
			throw new RNException(e);
		}
	}

	public void excluir(Usuario usuario) {
		CategoriaRN categoriaRN = new CategoriaRN();
		categoriaRN.excluir(usuario);
		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
}
