import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] tamanhos = {1000, 5000, 10000};
        Random rand = new Random();

        for (int tamanho : tamanhos) {
            int[] vetorBase = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                vetorBase[i] = rand.nextInt(100000);
            }

            System.out.println("\n===========================================");
            System.out.println("Tamanho: " + tamanho);


            // Melhor Caso
            int[] melhor = Arrays.copyOf(vetorBase, tamanho);
            Arrays.sort(melhor);

            testeCaso("Melhor Caso", melhor);

            // Caso Médio
            int[] medio = Arrays.copyOf(vetorBase, tamanho);
            testeCaso("Caso Médio", medio);

            // Pior Caso
            int[] pior = Arrays.copyOf(vetorBase, tamanho);
            Arrays.sort(pior);
            inverter(pior);

            testeCaso("Pior Caso", pior);
        }
    }

    public static void testeCaso(String nome, int[] vetorOriginal) {
        int[] vetorBubble = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
        int[] vetorMerge = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

        long inicio, fim;

        System.out.println("\n[" + nome + "]");
        // Bubble Sort

        inicio = System.nanoTime();
        BubbleSort.ordenar(vetorBubble);
        fim = System.nanoTime();
        System.out.println("Bubble Sort: " + (fim - inicio) + " ns");

        // Merge Sort
        inicio = System.nanoTime();
        MergeSort.ordenar(vetorMerge);
        fim = System.nanoTime();
        System.out.println("Merge Sort: " + (fim - inicio) + " ns");
     }

     public static void inverter(int[] vetor) {
        for (int i = 0; i < vetor.length / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[vetor.length - 1 - i];
            vetor[vetor.length - 1 - i] = temp;
        }
     }
}