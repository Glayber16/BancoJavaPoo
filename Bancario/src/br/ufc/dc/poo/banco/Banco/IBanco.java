package br.ufc.dc.poo.banco.Banco;

import br.ufc.dc.poo.conta.Conta.ContaAbstrata;

public interface IBanco {
	public double saldoTotal();
	public int numeroTotal();
	public void cadastrar(ContaAbstrata conta);
	public ContaAbstrata procurar(String numero);
	public void creditar(String numero, double valor);
	public void debitar(String numero, double valor);
	public double saldo(String numero);
	public void transferir(String origem, String destino, double valor);
}
