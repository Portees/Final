package br.com.ifgoiano.usuariol.bolsa.acao;

import java.util.List;

import br.com.ifgoiano.usuariol.usuario.Usuario;

public interface AcaoDAO {
	public void salvar(Acao acao);

	public void excluir(Acao acao);

	public List<Acao> listar(Usuario usuario);
}
