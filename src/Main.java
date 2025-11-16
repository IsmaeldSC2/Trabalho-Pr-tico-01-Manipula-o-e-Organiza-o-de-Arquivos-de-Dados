// Main.java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- 1. Definição dos parâmetros ---
        System.out.print("Quantos registros deseja gerar? ");
        int n = sc.nextInt();

        System.out.print("Tamanho do bloco (em bytes): ");
        int tamBloco = sc.nextInt();

        System.out.println("\n1 - Tamanho fixo");
        System.out.println("2 - Tamanho variável");
        System.out.print("Modo de armazenamento: ");
        int modo = sc.nextInt();

        int variacao = 0;
        if (modo == 2) {
            System.out.println("  1 - Sem espalhamento");
            System.out.println("  2 - Com espalhamento");
            System.out.print("Escolha a variação: ");
            variacao = sc.nextInt();
        }

        // --- 2. Geração dos dados ---
        System.out.println("Gerando " + n + " alunos...");
        ArrayList<Aluno> alunos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            alunos.add(GeradorAlunos.gerarAluno());
        }

        // --- 3. Simulação de escrita ---
        SimuladorArmazenamento sim = new SimuladorArmazenamento(tamBloco);

        // CORREÇÃO: Calcula o tamanho fixo 1 vez, baseado na classe Aluno
        int tamanhoFixo = Aluno.getTamanhoFixoMaximo();
        // System.out.println("Tamanho fixo calculado: " + tamanhoFixo + " bytes");

        System.out.println("Simulando armazenamento...");

        for (Aluno a : alunos) {
            if (modo == 1) {
                // Modo 1: Tamanho Fixo
                sim.armazenarRegistroFixo(tamanhoFixo);
            } else {
                // Modo 2: Tamanho Variável
                int tamanhoReal = a.getTamanhoVariavel();

                if (variacao == 1) {
                    sim.armazenarVariavelSemEspalhar(tamanhoReal);
                } else {
                    sim.armazenarVariavelComEspalhar(tamanhoReal);
                }
            }
        }

        System.out.println("Simulação concluída.");

        // --- 4. Exibição dos resultados ---
        Estatisticas.imprimir(sim.getBlocos(), tamBloco);

        sc.close();
    }
}