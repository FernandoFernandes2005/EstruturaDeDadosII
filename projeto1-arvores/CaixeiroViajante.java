import java.util.Random;

public class CaixeiroViajante {

    private int[][] matriz;
    private int n;

    public CaixeiroViajante(int n) {
        this.n = n;
        this.matriz = new int[n][n];
        gerarDistancias();
    }

    private void gerarDistancias() {
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    int valor = rand.nextInt(100) + 1;
                    matriz[i][j] = valor;
                    matriz[j][i] = valor;
                }
            }
        }
    }

    public int resolver() {
        boolean[] visitado = new boolean[n];
        int atual = 0;
        int custoTotal = 0;

        visitado[0] = true;

        for (int i = 0; i < n - 1; i++) {

            int proximo = -1;
            int menorDist = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visitado[j] && matriz[atual][j] < menorDist) {
                    menorDist = matriz[atual][j];
                    proximo = j;
                }
            }

            visitado[proximo] = true;
            custoTotal += menorDist;
            atual = proximo;
        }

        custoTotal += matriz[atual][0];

        return custoTotal;
    }
}