public class BST {

    class No {
        int valor;
        No esquerda, direita;

        No(int valor) {
            this.valor = valor;
        }
    }

    private No raiz;

    // Inserir
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) return new No(valor);

        if (valor < atual.valor)
            atual.esquerda = inserirRec(atual.esquerda, valor);
        else if (valor > atual.valor)
            atual.direita = inserirRec(atual.direita, valor);

        return atual;
    }

    // Buscar
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No atual, int valor) {
        if (atual == null) return false;

        if (valor == atual.valor) return true;

        if (valor < atual.valor)
            return buscarRec(atual.esquerda, valor);
        else
            return buscarRec(atual.direita, valor);
    }

    // Altura
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(No atual) {
        if (atual == null) return -1;

        int esq = alturaRec(atual.esquerda);
        int dir = alturaRec(atual.direita);

        return 1 + Math.max(esq, dir);
    }

    // Remoção
    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private No removerRec(No atual, int valor) {
        if (atual == null) return null;

        if (valor < atual.valor) {
            atual.esquerda = removerRec(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = removerRec(atual.direita, valor);
        } else {
            // Sem filho
            if (atual.esquerda == null && atual.direita == null)
                return null;

            // Um filho
            if (atual.esquerda == null)
                return atual.direita;

            if (atual.direita == null)
                return atual.esquerda;

            // Dois filhos
            int menorValor = menorValor(atual.direita);
            atual.valor = menorValor;
            atual.direita = removerRec(atual.direita, menorValor);
        }

        return atual;
    }

    private int menorValor(No atual) {
        while (atual.esquerda != null)
            atual = atual.esquerda;

        return atual.valor;
    }
}