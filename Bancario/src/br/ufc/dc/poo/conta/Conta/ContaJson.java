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
        boolean contaExiste = false;

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).numero().equals(conta.numero())) {
                contas.set(i, conta);
                contaExiste = true;
                break;
            }
        }

        if (!contaExiste) {
            contas.add(conta);
        }

       
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(contas, writer);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(String numero) {
    	List<Conta> contas = listar();
        
        if (contas != null) {
            contas.removeIf(conta -> conta != null && conta.numero().equals(numero));
            try {
            	FileWriter gravador = new FileWriter(arquivo);
                gson.toJson(contas, gravador);
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
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
    	List<Conta> listaContas = new ArrayList<>();
        try {
        	FileReader leitor = new FileReader(arquivo);
            Type tipo = new TypeToken<ArrayList<Conta>>(){}.getType();
            listaContas = gson.fromJson(leitor, tipo);  
            if (listaContas == null) {
                listaContas = new ArrayList<>();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
            
        }
        return listaContas;
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

