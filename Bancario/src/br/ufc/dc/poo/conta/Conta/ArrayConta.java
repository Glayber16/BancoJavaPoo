package br.ufc.dc.poo.conta.Conta;

public class ArrayConta implements IRepositorioConta{
	private ContaAbstrata[] contas;
	private int indice = 0;
	
	public ArrayConta() {
		contas = new ContaAbstrata[indice];
	}
	
	public void inserir(ContaAbstrata conta) {
		
		
	}

	@Override
	public void remover(String numero) {
		// TODO Auto-generated method stub
		
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
	public ContaAbstrata[] listar() {
		int n = tamanho();
		ContaAbstrata c;
		for(int i = 0; i < n; i++) {
			
		}
		
		
	}

	@Override
	public int tamanho() {
		
		return 0;
	}

}
