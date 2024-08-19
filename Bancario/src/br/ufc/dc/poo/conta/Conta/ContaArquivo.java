package br.ufc.dc.poo.conta.Conta;



import java.io.File;
import java.util.List;

public class ContaArquivo implements IRepositorioConta {
    private File diretorio;
    private File arquivo;
    private GravaObj gravaObj;
    private LeObj leObj;

    public ContaArquivo() {
        this.diretorio = new File("C:\\Users\\Documentos\\Desktop\\Contas");
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
        this.arquivo = new File(diretorio, "Contas.lsr");
        this.gravaObj = new GravaObj();
        this.leObj = new LeObj();
    }

    @Override
    public void inserir(Conta conta) {
        List<Conta> contas = listar();
        contas.add(conta);
        gravaObj.serializa(contas, arquivo.getPath());
    }

    @Override
    public void remover(String numero) {
        List<Conta> contas = listar();
        contas.removeIf(conta -> conta.numero().equals(numero));
        gravaObj.serializa(contas, arquivo.getPath());
    }

    @Override
    public Conta procurar(String numero) {
        List<Conta> contas = listar();
        for (Conta conta : contas) {
            if (conta.numero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public List<Conta> listar() {
        return leObj.le(arquivo.getPath());
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
    }
}
