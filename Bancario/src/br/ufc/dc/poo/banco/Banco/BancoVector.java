package br.ufc.dc.poo.banco.Banco;
import contas.Conta;

import contas.ContaEspecial;

import contas.ContaPoupanca;

import java.util.Vector;
public class BancoVector {
	private Vector<Conta> vetorBanco;
	
	public BancoVector() {
		vetorBanco = new Vector<Conta>();
	}
	
	public void addConta(Conta conta) {
		vetorBanco.add(conta);
	}
	
	private Conta procurar(String numero) {
        for (Conta conta : vetorBanco) {
            if (conta.numero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public void creditar(String numero, double valor) {
        Conta c = procurar(numero);
        if (c != null) {
            c.debitar(valor);
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public void debitar(String numero, double valor) {
        Conta c = procurar(numero);
        if (c != null) {
            c.debitar(valor);
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public double saldo(String numero) {
        Conta c = procurar(numero);
        if (c != null) {
            return c.saldo();
        } else {
            return 0;
        }
    }

    public void transferir(String origem, String destino, double valor) {
        Conta c = procurar(origem);
        Conta d = procurar(destino);
        if (c != null && d != null) {
            c.debitar(valor);
            d.creditar(valor);
        } else {
            System.out.println("Alguma das contas não foi encontrada");
        }
    }
    public void render(String numero, double taxa) {
		Conta c = procurar(numero);
		if(c instanceof ContaPoupanca) {
			((ContaPoupanca) c).renderJuros(taxa);
		}
		if(c instanceof ContaEspecial) {
			((ContaEspecial) c).renderBonus();
		}
	}
    
}

