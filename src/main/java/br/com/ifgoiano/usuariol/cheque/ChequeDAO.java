package br.com.ifgoiano.usuariol.cheque;

import java.util.List;

import br.com.ifgoiano.usuariol.conta.Conta;

public interface ChequeDAO {

	public void salvar(Cheque cheque);

	public void excluir(Cheque cheque);

	public Cheque carregar(ChequeId chequeId);

	public List<Cheque> listar(Conta conta);
}
