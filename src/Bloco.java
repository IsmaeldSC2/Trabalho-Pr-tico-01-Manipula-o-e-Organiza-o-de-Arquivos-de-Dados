// Bloco.java
public class Bloco {
    private int tamanhoMaximo;
    private int usado;
    private StringBuilder dados; // Apenas para simulação

    public Bloco(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.usado = 0;
        this.dados = new StringBuilder();
    }

    public int getUsado() {
        return usado;
    }

    public int getLivre() {
        return tamanhoMaximo - usado;
    }

    public boolean estaCheio() {
        return usado == tamanhoMaximo;
    }

    /**
     * Verifica se um registro cabe INTEIRAMENTE no espaço livre.
     */
    public boolean cabeInteiro(int tamanhoRegistro) {
        return (usado + tamanhoRegistro) <= tamanhoMaximo;
    }

    /**
     * Grava um registro que PODE ser quebrado (com espalhamento).
     * Retorna o número de bytes que foram gravados.
     */
    public int escreverFragmento(int tamanhoNecessario) {
        int espacoLivre = getLivre();
        int gravado = Math.min(espacoLivre, tamanhoNecessario);

        this.usado += gravado;
        this.dados.append("R".repeat(gravado)); // Simulação
        return gravado;
    }

    /**
     * ***MÉTODO ADICIONADO***
     * Grava um registro INTEIRO (sem espalhamento).
     * Assume que 'cabeInteiro' já foi verificado.
     */
    public void escreverInteiro(int tamanhoRegistro) {
        this.usado += tamanhoRegistro;
        this.dados.append("#".repeat(tamanhoRegistro)); // Simulação
    }

    @Override
    public String toString() {
        double pct = (usado * 100.0) / tamanhoMaximo;
        // Formata para: "512 bytes (100.0% cheio)"
        return String.format("%d bytes (%.1f%% cheio)", usado, pct);
    }
}