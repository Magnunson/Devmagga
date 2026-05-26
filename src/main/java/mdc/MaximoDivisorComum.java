package mdc;

/**
 * Implementação do cálculo do Máximo Divisor Comum (MDC)
 * baseada na definição matemática elementar e iteração direta.
 */
public class MaximoDivisorComum {

    /**
     * Calcula o MDC entre dois números de forma iterativa linear.
     */
    public static int calcularMDC(int a, int b) {
        // Garantir valores positivos para o cálculo
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0) return b;
        if (b == 0) return a;

        int mdc = 1;
        int menor = Math.min(a, b);

        for (int i = 1; i <= menor; i++) {
            if (a % i == 0 && b % i == 0) {
                mdc = i;
            }
        }
        return mdc;
    }
}
