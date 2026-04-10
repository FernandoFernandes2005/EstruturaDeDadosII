import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

       int[] tamanhos = {1000, 10000, 100000};
       Random rand = new Random();

       for (int tamanho : tamanhos) {
            int[] vetor = new int[tamanho];

            for (int i = 0; i < tamanho; i++) {
                vetor[i] = rand.nextInt(1000000);
        }


        ArvoreBST arvore = new ArvoreBST();
            for (int i = 0; i < tamanho; i++) {
                arvore.inserir(vetor[i]);
            }

        Arrays.sort(vetor);

        int repeticoes = 30;
        long[] temposSeq = new long[repeticoes];
        long[] temposBin = new long[repeticoes];
        long[] temposBST = new long[repeticoes];


      
       for (int i = 0; i < repeticoes; i++) {

            int alvo = vetor[rand.nextInt(tamanho)];

            // Busca Sequencial
            long inicio = System.nanoTime();

            for (int j = 0; j < 100; j++) {
                BuscaSequencial.buscar(vetor, alvo);
            }
            long fim = System.nanoTime();
            temposSeq[i] = (fim - inicio);

             // Busca Binária
            inicio = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                BuscaBinaria.buscar(vetor, alvo);
            }
            fim = System.nanoTime();
            temposBin[i] = (fim - inicio);

             // Busca na Árvore BST
            inicio = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                arvore.buscar(alvo);
            }
            fim = System.nanoTime();
            temposBST[i] = (fim - inicio);

         }


         double mediaSeq = media(temposSeq);
         double mediaBin = media(temposBin);
         double mediaBST = media(temposBST);

         double dpSeq = desvioPadrao(temposSeq);
         double dpBin = desvioPadrao(temposBin);
         double dpBST = desvioPadrao(temposBST);

         System.out.println("\n================================");
         System.out.println("Tamanho do vetor: " + tamanho);
         System.out.println("--------------------------------");

         System.out.println("Sequencial -> Média: " + mediaSeq + " | Desvio: " + dpSeq);
         System.out.println("Binária -> Média: " + mediaBin + " | Desvio: " + dpBin);
         System.out.println("Árvore BST -> Média: " + mediaBST + " | Desvio: " + dpBST);

        }
    }

    public static double media(long[] tempos) {
        double soma = 0;
        for(long t : tempos) {
            soma += t;
        }
        return soma / tempos.length;
    }

    public static double desvioPadrao(long[] tempos) {
        double media = media(tempos);
        double soma = 0;

        for (long t : tempos) {
            soma += Math.pow(t - media, 2);
        }
        return Math.sqrt(soma / tempos.length);
    }
}