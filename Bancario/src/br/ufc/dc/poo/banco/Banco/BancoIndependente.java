package br.ufc.dc.poo.banco.Banco;

import java.util.Vector;

import br.ufc.dc.poo.conta.Conta.Conta;
import br.ufc.dc.poo.conta.Conta.ContaAbstrata;

import br.ufc.dc.poo.conta.Conta.IRepositorioConta;

public class BancoIndependente implements IBanco {
    private IRepositorioConta repositorio;

    public BancoIndependente(IRepositorioConta repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrar(Conta conta) {
        repositorio.inserir(conta);
    }

    @Override
    public int numeroTotal() {
        return repositorio.tamanho();
    }

    @Override
    public ContaAbstrata procurar(String numero) {
        return repositorio.procurar(numero);
    }

    @Override
    public void creditar(String numero, double valor) throws CIException{
        Conta c = repositorio.procurar(numero);
        if (c != null) {
            c.creditar(valor);
        } 
        else {
        	throw new CIException(numero);
        }
    }

    @Override
    public void debitar(String numero, double valor) throws CIException, SIException {
        ContaAbstrata c = repositorio.procurar(numero);
        if (c != null) {
            if (c.saldo() >= valor) {
                c.debitar(valor);
            } 
            else {
            	throw new SIException(c.saldo(), c.numero());
            }
        } 
        else {
            throw new CIException(numero);
        }
    }

    @Override
    public double saldo(String numero) {
        ContaAbstrata c = repositorio.procurar(numero);
        if (c != null) {
            return c.saldo();
        } 
        else {
            return 0;
        }
    }

    @Override
    public void transferir(String origem, String destino, double valor) {
        ContaAbstrata c = repositorio.procurar(origem);
        ContaAbstrata d = repositorio.procurar(destino);
        if (c != null && d != null) {
            c.debitar(valor);
            d.creditar(valor);
        }
    }

    @Override
    public double saldoTotal() {
        double total = 0;
        for (ContaAbstrata conta : repositorio.listar()) {
            total += conta.saldo();
        }
        return total;
    }

    @Override
    public void render(String numero, double taxa) {
        repositorio.render(numero, taxa);
    }
}
