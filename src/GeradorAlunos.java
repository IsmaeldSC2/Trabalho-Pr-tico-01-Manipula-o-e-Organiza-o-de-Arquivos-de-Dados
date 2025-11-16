// GeradorAlunos.java
import java.util.Random;

public class GeradorAlunos {

    private static Random random = new Random();

    // Método auxiliar para gerar strings aleatórias
    private static String gerarStringAleatoria(int tamanhoMax) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
        // Gera um tamanho aleatório, mas realista (ex: entre 10 e tamanhoMax)
        int tamanho = Math.max(10, random.nextInt(tamanhoMax + 1));

        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(alfabeto.charAt(random.nextInt(alfabeto.length())));
        }
        return sb.toString();
    }

    public static Aluno gerarAluno() {
        int matricula = 100000000 + random.nextInt(900000000);
        String nome = gerarStringAleatoria(50); // Tamanho máximo 50
        String cpf = String.valueOf(10000000000L + random.nextLong(90000000000L));
        String curso = gerarStringAleatoria(30); // Tamanho máximo 30
        String mae = gerarStringAleatoria(30);   // Tamanho máximo 30
        String pai = gerarStringAleatoria(30);   // Tamanho máximo 30
        int ano = 2015 + random.nextInt(10);
        float ca = random.nextFloat() * 100;

        // Usa os nomes de campos da sua classe Aluno
        return new Aluno(matricula, nome, cpf, curso, mae, pai, ano, ca);
    }
}