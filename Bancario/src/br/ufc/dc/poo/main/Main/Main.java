package br.ufc.dc.poo.main.Main;

import com.google.gson.*;

import br.ufc.dc.poo.auditor.Auditor.AuditorBancoGenerico;
import br.ufc.dc.poo.banco.Banco.BancoArray;
import br.ufc.dc.poo.banco.Banco.BancoIndependente;
import br.ufc.dc.poo.banco.Banco.BancoVector;
import br.ufc.dc.poo.banco.Banco.CIException;
import br.ufc.dc.poo.conta.Conta.ArrayConta;
import br.ufc.dc.poo.conta.Conta.Conta;
import br.ufc.dc.poo.conta.Conta.ContaArquivo;
import br.ufc.dc.poo.conta.Conta.ContaEspecial;
import br.ufc.dc.poo.conta.Conta.ContaJson;
import br.ufc.dc.poo.conta.Conta.ContaPoupanca;
import br.ufc.dc.poo.conta.Conta.VectorConta;

public class Main {

	public static void main(String[] args) throws CIException {
		// TODO Auto-generated method stub
		Conta c;
		c = new ContaEspecial("222");
		c.creditar(300);
		ContaEspecial d;
		d = new ContaEspecial("333");
		d.creditar(240);
		d.renderBonus();
		ContaPoupanca a;
		a = new ContaPoupanca("555");
		a.creditar(200);
		a.renderJuros(0.5);
		Conta e;
		e = new ContaPoupanca("444");
		e.creditar(100);
		VectorConta contas = new VectorConta();
		contas.inserir(a);
		contas.inserir(c);
		contas.inserir(e);
		contas.inserir(d);
		BancoIndependente nu = new BancoIndependente(contas);
		System.out.println("poupanca" + " " + nu.saldo("555"));
		System.out.println("poupanca" + " " + nu.saldo("444"));
		System.out.println("especial" + " " + nu.saldo("333"));
		
		AuditorBancoGenerico auditor = new AuditorBancoGenerico();
		auditor.auditar(nu);
		System.out.println(nu.numeroTotal());
		nu.creditar("444", 50);
		System.out.println("poupanca" + " " + nu.saldo("444"));
		nu.creditar("333", 50);
		nu.render("333", 0);
		nu.render("444", 0.5);
		System.out.println("poupanca" + " " + nu.saldo("444"));
		System.out.println("especial" + " " + nu.saldo("333"));
		ContaJson teste2 = new ContaJson();	
		teste2.inserir(a);
		teste2.inserir(c);
		BancoIndependente bb = new BancoIndependente(teste2);
		bb.creditar("555", 200);
		bb.creditar("222", 100);
		bb.creditar("555", 300);
		bb.creditar("555", 50);
		
		
	}

}
