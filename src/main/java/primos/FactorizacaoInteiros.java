package primos;

import java.util.ArrayList;
import java.util.List;

/**
 * Algoritmo simples de decomposição em fatores primos.
 */

public class FactorizacaoInteiros {

    /**
     * Decompõe um inteiro composto nos seus fatores primos constituintes.
     */
    public static List<Integer> decompor(int n) {
        List<Integer> fatores = new ArrayList<>();
        if (n <= 1) return fatores;

        // Extrai fatores de 2
        while (n % 2 == 0) {
            fatores.add(2);
            n /= 2;
        }

        // Extrai fatores ímpares
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                fatores.add(i);
                n /= i;
            }
        }

        // Se n ainda for maior que 2, o que restou é primo
        if (n > 2) {
            fatores.add(n);
        }

        return fatores;
    }

}
