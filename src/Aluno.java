// Aluno.java
import java.nio.charset.StandardCharsets;

public class Aluno {

    // Seus campos (com os nomes que você usou)
    int matricula;
    String nome;
    String cpf;
    String curso;
    String filiacaoMae; // Corrigido
    String filiacaoPai; // Corrigido
    int anoIngresso;
    float ca;

    // Construtor (com os nomes que você usou)
    public Aluno(int matricula, String nome, String cpf, String curso, String filiacaoMae, String filiacaoPai, int anoIngresso, float ca) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
        this.filiacaoMae = filiacaoMae;
        this.filiacaoPai = filiacaoPai;
        this.anoIngresso = anoIngresso;
        this.ca = ca;
    }

    /**
     * CORRIGIDO: Calcula o tamanho REAL (variável) deste registro.
     * Números (int/float) têm tamanho fixo em bytes.
     */
    public int getTamanhoVariavel() {
        int tamInt = 4;    // int ocupa 4 bytes
        int tamFloat = 4;  // float ocupa 4 bytes
        int bytes = 0;

        // Adiciona o tamanho real das strings em bytes
        bytes += nome.getBytes(StandardCharsets.UTF_8).length;
        bytes += cpf.getBytes(StandardCharsets.UTF_8).length;
        bytes += curso.getBytes(StandardCharsets.UTF_8).length;
        bytes += filiacaoMae.getBytes(StandardCharsets.UTF_8).length;
        bytes += filiacaoPai.getBytes(StandardCharsets.UTF_8).length;

        // Adiciona o tamanho fixo dos campos numéricos
        bytes += tamInt; // matricula
        bytes += tamInt; // anoIngresso
        bytes += tamFloat; // ca

        return bytes;
    }

    /**
     * NOVO: Calcula o tamanho MÁXIMO que um registro pode ter.
     * Usado para a estratégia de TAMANHO FIXO.
     */
    public static int getTamanhoFixoMaximo() {
        int tamInt = 4;
        int tamFloat = 4;

        // Tamanhos MÁXIMOS das strings (de acordo com o PDF)
        int tamNome = 50;
        int tamCpf = 11;
        int tamCurso = 30;
        int tamMae = 30;
        int tamPai = 30;

        return tamInt +   // matricula
                tamNome +
                tamCpf +
                tamCurso +
                tamMae +
                tamPai +
                tamInt +   // anoIngresso
                tamFloat;  // ca

        // Total = 4 + 50 + 11 + 30 + 30 + 30 + 4 + 4 = 163 bytes
    }
}