public class MergeSort { 
    public static void ordenar(int[] vetor) {
        if (vetor.length < 2) return;

        int meio = vetor.length / 2;

        int[] esquerda = new int[meio]; 
        int[] direita = new int[vetor.length - meio];

        for (int i = 0; i < meio; i++) {
            esquerda[i] = vetor[i];
        }

        for (int i = meio; i < vetor.length; i++) {
            direita[i - meio] = vetor[i];
        }

        ordenar(esquerda);
        ordenar(direita);

        merge(vetor, esquerda, direita);
    }

    private static void merge(int[] vetor, int[] esquerda, int [] direita) {
        int i = 0, j = 0, k = 0;

        while(i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
               vetor[k++] = esquerda[i++];
            } else {
                vetor[k++] = direita[j++];
            }
           
        }

        while (i < esquerda.length) {
            vetor[k++] = esquerda[i++];
        }

        while (j < direita.length) {
            vetor[k++] = direita[j++];
        }

    }
}