package euler;

import euclides.AlgoritmoEuclides;

/**
 * Computação da Função Totiente de Euler (Phi de Euler).
 */
public class TotienteEuler {

    /**
     * Calcula a quantidade de números coprimos com n menores que n.
     */
    public static int calcularPhi(int n) {
        int resultado = 0;
        for (int i = 1; i <= n; i++) {
            if (AlgoritmoEuclides.calcularMDC(i, n) == 1) {
                resultado++;
            }
        }
        return resultado;
    }

    /**
     * Abordagem otimizada usando a Fórmula do Produto de Euler.
     */
    public static int calcularPhiOtimizado(int n) {
        int resultado = n;
        int temp = n;

        for (int p = 2; p * p <= temp; p++) {
            if (temp % p == 0) {
                while (temp % p == 0) {
                    temp /= p;
                }
                resultado -= resultado / p;
            }
        }
        if (temp > 1) {
            resultado -= resultado / temp;
        }
        return resultado;
    }
}
