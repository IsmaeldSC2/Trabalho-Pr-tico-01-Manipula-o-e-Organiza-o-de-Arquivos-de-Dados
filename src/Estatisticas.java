// Estatisticas.java
import java.util.List;

public class Estatisticas {

    /**
     * Imprime o relatório final da simulação.
     */
    public static void imprimir(List<Bloco> blocos, int tamanhoBloco) {
        int totalBlocos = blocos.size();
        int bytesUsados = 0;
        int blocksParciais = 0;

        for (Bloco b : blocos) {
            bytesUsados += b.getUsado();

            // Um bloco é "parcialmente utilizado" se não está
            // nem 100% cheio nem 0% vazio.
            if (b.getUsado() > 0 && b.getUsado() < tamanhoBloco) {
                blocksParciais++;
            }
        }

        // Calcula a eficiência total
        double espacoTotalAlocado = (double) totalBlocos * tamanhoBloco;
        double eficiencia = (bytesUsados * 100.0) / espacoTotalAlocado;

        System.out.println("\n--- ESTATÍSTICAS DE ARMAZENAMENTO ---");
        System.out.println("Total de blocos utilizados: " + totalBlocos);
        System.out.printf("Eficiência total (dados/espaço total): %.2f%%%n", eficiencia);
        System.out.println("Blocos parcialmente utilizados: " + blocksParciais);

        System.out.println("\n--- MAPA DE OCUPAÇÃO ---");
        for (int i = 0; i < blocos.size(); i++) {
            // Usa o toString() do Bloco
            System.out.println("Bloco " + (i + 1) + ": " + blocos.get(i).toString());
        }
    }
}