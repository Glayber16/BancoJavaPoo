package br.ufc.dc.poo.conta.Conta;

import java.util.Arrays;
import java.util.List;

public class ArrayConta implements IRepositorioConta{
	private ContaAbstrata[] contas;
	private int indice = 0;
	
	public ArrayConta() {
		contas = new ContaAbstrata[100];
	}
	
	public void inserir(ContaAbstrata conta) {
		contas[indice] = conta;
		indice++;
		
	}

	@Override
	public void remover(String numero) {
		for(int i = 0; i < indice; i++ ) {
			if(contas[i].numero().equals(numero)) {
				for(; i<indice-1; i++) {
					contas[i] = contas[i+1];
				}
				indice--;
			}
		
		}
		
	}

	@Override
	public ContaAbstrata procurar(String numero) {
		int i = 0;
		for(i = 0; i < indice; i++ ) {
			if(contas[i].numero().equals(numero)) {
				return contas[i];
			}
		}
		return null;
	}

	@Override
	public List<ContaAbstrata> listar() {
		ContaAbstrata[] listaContas = new ContaAbstrata[indice];
		    
		for (int i = 0; i < indice; i++) {
			listaContas[i] = contas[i];
		}
		    
		return Arrays.asList(listaContas);
	}

	@Override
	public int tamanho() {
		
		return indice;
	}

	@Override
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
