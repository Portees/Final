package br.com.ifgoiano.usuariol.lancamento;

import java.util.Date;
import java.util.List;

import br.com.ifgoiano.usuariol.conta.Conta;

public interface LancamentoDAO {

	public void salvar(Lancamento lancamento);

	public void excluir(Lancamento lancamento);

	public Lancamento carregar(Integer lancamento);

	public List<Lancamento> listar(Conta conta, Date dataInicio, Date dataFim);

	public float saldo(Conta conta, Date data);
}
