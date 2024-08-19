package br.ufc.dc.poo.conta.Conta;

import java.util.List;

public interface IRepositorioConta {
	public void inserir(Conta conta);
	public void remover(String numero);
	public Conta procurar(String numero);
	public List<Conta> listar();
	public int tamanho();
	public void render(String numero, double taxa);
	
}
