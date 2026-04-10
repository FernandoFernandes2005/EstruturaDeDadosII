public class RubroNegra {

    private static final boolean VERMELHO = true;
    private static final boolean PRETO = false;

    class No {
        int valor;
        No esquerda, direita;
        boolean cor;

        No(int valor, boolean cor) {
            this.valor = valor;
            this.cor = cor;
        }
    }

    private No raiz;

    private boolean eVermelho(No no) {
        return no != null && no.cor == VERMELHO;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
        raiz.cor = PRETO;
    }

    private No inserirRec(No h, int valor) {
        if (h == null) return new No(valor, VERMELHO);

        if (valor < h.valor)
            h.esquerda = inserirRec(h.esquerda, valor);
        else if (valor > h.valor)
            h.direita = inserirRec(h.direita, valor);

        if (eVermelho(h.direita) && !eVermelho(h.esquerda))
            h = rotacaoEsquerda(h);

        if (eVermelho(h.esquerda) && eVermelho(h.esquerda.esquerda))
            h = rotacaoDireita(h);

        if (eVermelho(h.esquerda) && eVermelho(h.direita))
            inverterCores(h);

        return h;
    }

    private No rotacaoEsquerda(No h) {
        No x = h.direita;
        h.direita = x.esquerda;
        x.esquerda = h;
        x.cor = h.cor;
        h.cor = VERMELHO;
        return x;
    }

    private No rotacaoDireita(No h) {
        No x = h.esquerda;
        h.esquerda = x.direita;
        x.direita = h;
        x.cor = h.cor;
        h.cor = VERMELHO;
        return x;
    }

    private void inverterCores(No h) {
        h.cor = VERMELHO;
        h.esquerda.cor = PRETO;
        h.direita.cor = PRETO;
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(No no) {
        if (no == null) return -1;
        return 1 + Math.max(alturaRec(no.esquerda), alturaRec(no.direita));
    }
}