package modular;

/**
 * Operações matemáticas sob aritmética modular e testes de congruência.
 */
public class Congruencia {

    /**
     * Verifica se dois números 'a' e 'b' são congruentes módulo 'm'.
     */
    public static boolean saoCongruentes(int a, int b, int m) {
        if (m <= 0) return false;
        return (a - b) % m == 0;
    }

    /**
     * Realiza a Exponenciação Modular Rápida de forma iterativa.
     * Computa de forma eficiente (base ^ expoente) % modulo.
     */
    public static long exponenciacaoModular(long base, long expoente, long modulo) {
        if (modulo == 1) return 0;
        long resultado = 1;
        base = base % modulo;

        while (expoente > 0) {
            // Se o expoente for ímpar, multiplica pela base
            if (expoente % 2 == 1) {
                resultado = (resultado * base) % modulo;
            }
            // O expoente deve ser dividido por 2, e a base elevada ao quadrado
            expoente = expoente >> 1;
            base = (base * base) % modulo;
        }
        return resultado;
    }
}
