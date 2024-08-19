package br.ufc.dc.poo.conta.Conta;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class LeObj {

    List<Conta> lista = new ArrayList<Conta>();
    FileInputStream leitor;
    ObjectInputStream reader;

    public List<Conta> le(String arq) {
        try {
            leitor = new FileInputStream(arq);
            reader = new ObjectInputStream(leitor);
            lista = (ArrayList<Conta>) reader.readObject();
        } 
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } 
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return lista;
        
    }
}
