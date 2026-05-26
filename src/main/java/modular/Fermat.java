package modular;

/**
 * Aplicações e demonstrações do Pequeno Teorema de Fermat.
 */
public class Fermat {

    /**
     * Demonstra a validade do teorema verificando se (a^p) ≡ a (mod p)
     */
    public static boolean testarTeorema(int a, int p) {
        // O teorema assume que p é primo
        long resultadoEsquerdo = Congruencia.exponenciacaoModular(a, p, p);
        long resultadoDireito = a % p;
        return resultadoEsquerdo == resultadoDireito;
    }
}

