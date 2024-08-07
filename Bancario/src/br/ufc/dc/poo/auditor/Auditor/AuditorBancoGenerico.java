package br.ufc.dc.poo.auditor.Auditor;


import br.ufc.dc.poo.banco.Banco.IBanco;

public class AuditorBancoGenerico {
	public void auditar(IBanco banco) {
		if(banco.saldoTotal()/ banco.numeroTotal() > 500) {
			System.out.println("Aprovado");
		}
		else {
			System.out.println("Reprovado");
		}
	}
}
