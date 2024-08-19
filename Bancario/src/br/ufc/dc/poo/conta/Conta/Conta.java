package br.ufc.dc.poo.conta.Conta;

import java.io.Serializable;

public class Conta extends ContaAbstrata implements Serializable{

	private static final long serialVersionUID = 1L;

	public Conta(String numero) {
		super(numero);
	}
	
	public void debitar (double valor) {
		saldo = saldo - valor;
	}

}
