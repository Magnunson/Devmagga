package primos;

/**
 * Implementação de métodos de verificação de números primos.
 */
public class TestePrimalidade {

    /**
     * Teste por Divisão Primitiva Tentada (Força Bruta).
     */
    public static boolean ehPrimoPrimitivo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Teste por Divisão Otimizada baseado na raiz quadrada (O(sqrt(N))).
     */
    public static boolean ehPrimoOtimizado(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Loop pula múltiplos de 2 e 3 (forma 6k +/- 1)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}

