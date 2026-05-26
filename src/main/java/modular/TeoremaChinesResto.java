package modular;

import euclides.AlgoritmoEuclides;

/**
 * Resolução de sistemas de congruências lineares pelo Teorema Chinês do Resto.
 */
public class TeoremaChinesResto {

    /**
     * Resolve o sistema x ≡ num[i] (mod rem[i]).
     * Nota: assume que todos os pares do módulo são coprimos entre si.
     */
    public static int resolver(int[] num, int[] rem) {
        int prod = 1;
        for (int i = 0; i < rem.length; i++) {
            prod *= rem[i];
        }

        int resultado = 0;

        for (int i = 0; i < rem.length; i++) {
            int pp = prod / rem[i];
            int inv = AlgoritmoEuclides.calcularInversoModular(pp, rem[i]);

            if (inv == -1) {
                return -1; // Não foi possível resolver, módulos não são coprimos
            }

            resultado += num[i] * inv * pp;
        }

        return resultado % prod;
    }
}

