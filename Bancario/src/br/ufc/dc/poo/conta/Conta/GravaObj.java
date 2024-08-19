package br.ufc.dc.poo.conta.Conta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GravaObj {

    public void serializa(List<Conta> lista, String arq) {
        try {
        	FileOutputStream escritor = new FileOutputStream(new File(arq));
            ObjectOutputStream gravador = new ObjectOutputStream(escritor);
            gravador.writeObject(lista);
            gravador.flush();
            gravador.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
