package arquivos;

import java.io.File;
import java.util.List;

import br.ufc.dc.poo.conta.Conta.ContaAbstrata;
import br.ufc.dc.poo.conta.Conta.ContaEspecial;
import br.ufc.dc.poo.conta.Conta.ContaPoupanca;
import br.ufc.dc.poo.conta.Conta.GravaObj;
import br.ufc.dc.poo.conta.Conta.LeObj;

public class ArquivoTeste {
    public static void main(String[] args) {
        ContaPoupanca teste = new ContaPoupanca("222");
        File diretorio = new File("C:\\Users\\Documentos\\Desktop\\Contas");
        teste.creditar(500);
        ContaEspecial teste2 = new ContaEspecial("333");
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }

        File arquivo = new File(diretorio, "TESTE.lsr");
        
        GravaObj go = new GravaObj();
        go.serializa(teste, arquivo.getPath());
        go.serializa(teste2, arquivo.getPath());
        LeObj<ContaAbstrata> le = new LeObj<>();
        List<ContaAbstrata> l = le.le(arquivo.getPath());
        
        for (ContaAbstrata conta : l) {
            System.out.println(conta);
        }
    }
}
