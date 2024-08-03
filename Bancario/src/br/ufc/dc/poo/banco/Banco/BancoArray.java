package br.ufc.dc.poo.banco.Banco;

import contas.Conta;
import contas.ContaAbstrata;
import contas.ContaEspecial;
import contas.ContaPoupanca;

public class BancoArray {
	private Conta[] contas;
	private int indice = 0;
	
	public BancoArray () {
		contas = new Conta[100];
	}
	
	public void cadastrar (Conta conta) {
		contas[indice] = conta;
		indice++;
	}
	
	private Conta procurar (String numero) {
		int i = 0;
		
		for(i = 0; i < indice; i++ ) {
			if(contas[i].numero().equals(numero)) {
				return contas[i];
			}
			
		}
		return null;
	}
	
	public void creditar (String numero, double valor) {
		Conta c = procurar(numero);
		if(c != null) {
			c.creditar(valor);
		}
		else {
			System.out.println("Conta não encontrada");
		}
		
	}
	
	public void debitar (String numero, double valor) {
		Conta c = procurar(numero);
		if(c != null) {
			c.debitar(valor);
		}
		else {
			System.out.println("Conta não encontrada");
		}
		
	}
	
	public double saldo (String numero) {
		Conta c = procurar(numero);
		if (c != null) {
			return c.saldo();
		}
		else {
			return 0;
		}
		
	}
	
	public void transferir (String origem, String destino, double valor) {
		Conta c = procurar(origem);
		Conta d = procurar (destino);
		if(c != null && d != null) {
			c.debitar(valor);
			d.creditar(valor);
		}
		else {
			System.out.println("Alguma das contas não foi encontrada");
		}
	}
	
	public void render(String numero, double taxa) {
		ContaAbstrata c = procurar(numero);
		if(c instanceof ContaPoupanca) {
			((ContaPoupanca) c).renderJuros(taxa);
		}
		if(c instanceof ContaEspecial) {
			((ContaEspecial) c).renderBonus();
		}
	}
}
