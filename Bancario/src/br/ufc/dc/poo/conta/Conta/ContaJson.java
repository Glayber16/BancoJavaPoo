package br.ufc.dc.poo.conta.Conta;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ContaJson implements IRepositorioConta {
    private File diretorio;
    private File arquivo;
    private Gson gson;
    private List<Conta> contas;

    public ContaJson() {
        gson = new Gson();
        contas = new ArrayList<>();
        this.diretorio = new File("C:\\Users\\Documentos\\Desktop\\Contas");
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
        this.arquivo = new File(diretorio, "Contas.json");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(Conta conta) {
        List<Conta> contas = listar();
        contas.add(conta);
        if(procurar(conta.numero) == null) {
	        try (FileWriter writer = new FileWriter(arquivo)) {
	            gson.toJson(contas, writer);
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
        }
        else {
        	System.out.println("Conta já está no json");
        }
    }

    @Override
    public void remover(String numero) {
        List<Conta> contas = listar();
        contas.removeIf(conta -> conta.numero().equals(numero));
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(contas, writer);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Conta procurar(String numero) {
        List<Conta> contas = listar();
        return contas.stream()
                     .filter(conta -> conta.numero().equals(numero))
                     .findFirst()
                     .orElse(null);
    }

    @Override
    public List<Conta> listar() {
        try (FileReader reader = new FileReader(arquivo)) {
            Type type = new TypeToken<ArrayList<Conta>>(){}.getType();
            return gson.fromJson(reader, type);
        } 
        catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public int tamanho() {
        return listar().size();
    }

    @Override
    public void render(String numero, double taxa) {
        Conta c = procurar(numero);
        if (c instanceof ContaPoupanca) {
            ((ContaPoupanca) c).renderJuros(taxa);
        }
        if (c instanceof ContaEspecial) {
            ((ContaEspecial) c).renderBonus();
        }
        inserir(c); 
    }
}

