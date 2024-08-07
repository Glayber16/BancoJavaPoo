package br.ufc.dc.poo.banco.Banco;
import java.util.Vector;

import br.ufc.dc.poo.conta.Conta.Conta;
import br.ufc.dc.poo.conta.Conta.ContaAbstrata;
import br.ufc.dc.poo.conta.Conta.ContaEspecial;
import br.ufc.dc.poo.conta.Conta.ContaPoupanca;
public class BancoVector implements IBanco{
	private Vector<ContaAbstrata> vetorBanco;
	
	public BancoVector() {
		vetorBanco = new Vector<ContaAbstrata>();
	}
	
	public void cadastrar(ContaAbstrata conta) {
		vetorBanco.add(conta);
	}
	public int numeroTotal() {
		return vetorBanco.size();
	}
	public ContaAbstrata procurar(String numero) {
        for (ContaAbstrata conta : vetorBanco) {
            if (conta.numero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public void creditar(String numero, double valor) {
        ContaAbstrata c = procurar(numero);
        if (c != null) {
            c.debitar(valor);
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public void debitar(String numero, double valor) {
        ContaAbstrata c = procurar(numero);
        if (c != null) {
            c.debitar(valor);
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public double saldo(String numero) {
    	ContaAbstrata c = procurar(numero);
        if (c != null) {
            return c.saldo();
        } else {
            return 0;
        }
    }

    public void transferir(String origem, String destino, double valor) {
        ContaAbstrata c = procurar(origem);
        ContaAbstrata d = procurar(destino);
        if (c != null && d != null) {
            c.debitar(valor);
            d.creditar(valor);
        } else {
            System.out.println("Alguma das contas não foi encontrada");
        }
    }
    public double saldoTotal() {
    	double total = 0;
    	for (ContaAbstrata conta : vetorBanco) {
    		total = conta.saldo() + total;
    	}
    	return total;
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

