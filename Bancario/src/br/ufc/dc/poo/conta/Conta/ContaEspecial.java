package br.ufc.dc.poo.conta.Conta;

import java.io.Serializable;

public class ContaEspecial extends Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private double bonus;
	public ContaEspecial(String numero) {
		super(numero);
		bonus = 0;
	}
	
	public void renderBonus() {
		super.creditar(bonus);
		bonus = 0;
	}
	
	public void creditar(double valor) {
		bonus = bonus + (valor * 0.01);
		super.creditar(valor);
	}

}
