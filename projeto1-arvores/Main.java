public class Main {
    public static void main(String[] args) {

        int[] valores = {10, 20, 30, 40, 50, 25};

        BST bst = new BST();
        AVL avl = new AVL();
        RubroNegra rn = new RubroNegra();

        for (int v : valores) {
            bst.inserir(v);
            avl.inserir(v);
            rn.inserir(v);
        }

        System.out.println("Altura BST: " + bst.altura());
        System.out.println("Altura AVL: " + avl.altura());
        System.out.println("Altura Rubro-Negra: " + rn.altura());

      
        int[] tamanhos = {5, 10, 20};
        int repeticoes = 30;

        for (int n : tamanhos) {

            long[] tempos = new long[repeticoes];

            for (int i = 0; i < repeticoes; i++) {

                CaixeiroViajante cxv = new CaixeiroViajante(n);

                long inicio = System.nanoTime();
                cxv.resolver();
                long fim = System.nanoTime();

                tempos[i] = (fim - inicio);
            }

            double media = media(tempos);
            double desvio = desvioPadrao(tempos);

            System.out.println("\n==============================");
            System.out.println("CXV com " + n + " cidades");
            System.out.println("Média: " + media);
            System.out.println("Desvio padrão: " + desvio);
        }
    }

    public static double media(long[] tempos) {
        double soma = 0;
        for (long t : tempos) soma += t;
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