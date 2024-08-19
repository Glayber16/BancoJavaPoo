package br.ufc.dc.poo.conta.Conta;

import java.io.Serializable;

public abstract class ContaAbstrata implements Serializable {
	private static final long serialVersionUID = 1L;
	public String numero;
	protected double saldo;
	
	public ContaAbstrata(String numero) {
		this.numero = numero;
		saldo = 0;
	}
	
	public void creditar (double valor) {
		saldo = saldo + valor;
	}
	public void debitar (double valor) {
		saldo = saldo - valor;
	}
	
	
	public String numero () {
		return numero;
	}
	public double saldo () {
		return saldo;
	}
}
