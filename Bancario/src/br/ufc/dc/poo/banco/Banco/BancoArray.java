package br.ufc.dc.poo.banco.Banco;

import br.ufc.dc.poo.conta.Conta.ContaAbstrata;
import br.ufc.dc.poo.conta.Conta.ContaEspecial;
import br.ufc.dc.poo.conta.Conta.ContaPoupanca;

public class BancoArray implements IBanco {
	private ContaAbstrata[] contas;
	private int indice = 0;
	
	public BancoArray () {
		contas = new ContaAbstrata[100];
	}
	
	public void cadastrar (ContaAbstrata conta) {
		contas[indice] = conta;
		indice++;
	}
	
	public int numeroTotal() {
		return indice;
	}
	
	public ContaAbstrata procurar (String numero) {
		int i = 0;
		
		for(i = 0; i < indice; i++ ) {
			if(contas[i].numero().equals(numero)) {
				return contas[i];
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
	    
	    public double saldoTotal () {
	    	int i = 0;
	    	double saldoTotal = 0;
	    	for(i = 0; i < indice; i++ ) {
	    		saldoTotal = contas[i].saldo() + saldoTotal;
	    	}
	    	return saldoTotal;
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


