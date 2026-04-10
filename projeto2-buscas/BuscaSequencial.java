public class BuscaSequencial {

    public static int buscar(int[] vetor, int alvo) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == alvo) {
                return i; //Retorna o índice do elemento encontrado
            }
        }
        return -1; //Retorna -1 se o elemento não for encontrado
    }
}