package br.ufc.dc.poo.conta.Conta;

import java.util.List;
import java.util.Vector;

public class VectorConta implements IRepositorioConta{
	private Vector<Conta> vetorConta;

	
	 public VectorConta() {
	        vetorConta = new Vector<>();
	    }

	public void inserir(Conta conta) {
		vetorConta.add(conta);
		
	}

	@Override
	public void remover(String numero) {
		 for (int i = 0; i < vetorConta.size(); i++) {
		        if (vetorConta.get(i).numero().equals(numero)) {
		            vetorConta.remove(i);
		            break;
	            }
	        }
		
	}

	@Override
	public Conta procurar(String numero) {
		for (Conta conta : vetorConta) {
            if (conta.numero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }


	@Override
	public List<Conta> listar() {
		
		return vetorConta;
	}

	@Override
	public int tamanho() {
		
		return vetorConta.size();
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
