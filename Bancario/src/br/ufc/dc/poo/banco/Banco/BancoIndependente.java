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
            repositorio.inserir(c);
        } 
        else {
        	throw new CIException(numero);
        }
    }

    @Override
    public void debitar(String numero, double valor) throws CIException, SIException {
        Conta c = repositorio.procurar(numero);
        if (c != null) {
            if (c.saldo() >= valor) {
                c.debitar(valor);
                repositorio.inserir(c);
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
        Conta c = repositorio.procurar(numero);
        if (c != null) {
            return c.saldo();
        } 
        else {
            return 0;
        }
    }

    @Override
    public void transferir(String origem, String destino, double valor) {
        Conta c = repositorio.procurar(origem);
        Conta d = repositorio.procurar(destino);
        if (c != null && d != null) {
            c.debitar(valor);
            d.creditar(valor);
            repositorio.inserir(c);
            repositorio.inserir(d);
        }
    }

    @Override
    public double saldoTotal() {
        double total = 0;
        for (Conta conta : repositorio.listar()) {
            total += conta.saldo();
        }
        return total;
    }

    @Override
    public void render(String numero, double taxa) {
        repositorio.render(numero, taxa);
    }
}
