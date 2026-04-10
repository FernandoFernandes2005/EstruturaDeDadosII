public class AVL {

    class No {
        int valor, altura;
        No esquerda, direita;

        No(int valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }

    private No raiz;

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) return new No(valor);

        if (valor < atual.valor)
            atual.esquerda = inserirRec(atual.esquerda, valor);
        else if (valor > atual.valor)
            atual.direita = inserirRec(atual.direita, valor);

        atual.altura = 1 + Math.max(altura(atual.esquerda), altura(atual.direita));

        int balance = fatorBalanceamento(atual);

        // Rotação direita
        if (balance > 1 && valor < atual.esquerda.valor)
            return rotacaoDireita(atual);

        // Rotação esquerda
        if (balance < -1 && valor > atual.direita.valor)
            return rotacaoEsquerda(atual);

        // Esquerda -> direita
        if (balance > 1 && valor > atual.esquerda.valor) {
            atual.esquerda = rotacaoEsquerda(atual.esquerda);
            return rotacaoDireita(atual);
        }

        // Direita -> esquerda
        if (balance < -1 && valor < atual.direita.valor) {
            atual.direita = rotacaoDireita(atual.direita);
            return rotacaoEsquerda(atual);
        }

        return atual;
    }

    private int altura(No n) {
        return (n == null) ? 0 : n.altura;
    }

    private int fatorBalanceamento(No n) {
        return (n == null) ? 0 : altura(n.esquerda) - altura(n.direita);
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));

        return y;
    }

    public int altura() {
        return altura(raiz);
    }
}