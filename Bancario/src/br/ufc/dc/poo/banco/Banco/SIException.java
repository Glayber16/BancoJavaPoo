package br.ufc.dc.poo.banco.Banco;
import java.lang.Exception;

public class SIException extends Exception {
	private double saldo;
	private String numero;
	
	public SIException (double saldo, String numero) {
		super ("Saldo Insuficiente!");
		this.saldo = saldo;
		this.numero = numero;
	}
	
	public double saldoConta(){
		return saldo;
	}
	
	public String numeroConta(){
		return numero;
	}
}
