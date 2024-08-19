package br.ufc.dc.poo.conta.Conta;

import java.io.Serializable;

public class ContaPoupanca extends Conta implements Serializable{


	private static final long serialVersionUID = 1L;

	public ContaPoupanca(String numero) {
		super(numero);
	}
	
	public void renderJuros(double taxa) {
		creditar(saldo() * taxa);
	}

}
