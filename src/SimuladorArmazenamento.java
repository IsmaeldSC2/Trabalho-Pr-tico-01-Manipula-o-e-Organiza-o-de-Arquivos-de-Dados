// SimuladorArmazenamento.java
import java.util.ArrayList;
import java.util.List;

public class SimuladorArmazenamento {

    private ArrayList<Bloco> blocos;
    private int tamanhoBloco;

    public SimuladorArmazenamento(int tamanhoBloco) {
        this.tamanhoBloco = tamanhoBloco;
        this.blocos = new ArrayList<>();
        this.blocos.add(new Bloco(tamanhoBloco)); // Começa com 1 bloco
    }

    private Bloco blocoAtual() {
        return blocos.get(blocos.size() - 1);
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }

    /**
     * 1. ARMAZENAMENTO TAMANHO FIXO (CORRIGIDO)
     */
    public void armazenarRegistroFixo(int tamanhoFixo) {
        Bloco bloco = blocoAtual();

        if (!bloco.cabeInteiro(tamanhoFixo)) {
            // Cria novo Bloco
            blocos.add(new Bloco(tamanhoBloco));
            bloco = blocoAtual();
        }

        // FALTOU ISSO:
        bloco.escreverInteiro(tamanhoFixo);
    }

    /**
     * 2a. VARIÁVEL SEM ESPALHAMENTO (CORRIGIDO)
     */
    public void armazenarVariavelSemEspalhar(int tamanhoReg) {
        Bloco bloco = blocoAtual();
        if (!bloco.cabeInteiro(tamanhoReg)) {
            blocos.add(new Bloco(tamanhoBloco));
            bloco = blocoAtual();
        }

        // CORREÇÃO: Usar escreverInteiro, não fragmento
        bloco.escreverInteiro(tamanhoReg);
    }

    /**
     * 2b. VARIÁVEL COM ESPALHAMENTO (Estava OK)
     */
    public void armazenarVariavelComEspalhar(int tamanhoReal) {
        int restante = tamanhoReal;
        while (restante > 0) {
            Bloco bloco = blocoAtual();
            int gravado = bloco.escreverFragmento(restante);
            restante -= gravado;
            if (restante > 0) {
                blocos.add(new Bloco(tamanhoBloco));
            }
        }
    }
}