package euclides;

/**
 * Implementação do Algoritmo de Euclides (Versão Eficiente)
 * e do Algoritmo de Euclides Estendido para o cálculo de inversos modulares.
 */
public class AlgoritmoEuclides {

    /**
     * Algoritmo de Euclides Tradicional utilizando o resto da divisão (Modular).
     */
    public static int calcularMDC(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }

    /**
     * Algoritmo de Euclides Estendido.
     * Encontra os coeficientes x e y tais que: a*x + b*y = mdc(a, b).
     * Retorna um array onde: [0] = mdc, [1] = x, [2] = y
     */
    public static int[] euclidesEstendido(int a, int b) {
        if (b == 0) {
            return new int[] { a, 1, 0 };
        }
        int[] valores = euclidesEstendido(b, a % b);
        int mdc = valores[0];
        int x1 = valores[1];
        int y1 = valores[2];

        int x = y1;
        int y = x1 - (a / b) * y1;

        return new int[] { mdc, x, y };
    }

    /**
     * Calcula o inverso modular de 'a' em relação ao módulo 'm'.
     * Retorna -1 caso o inverso não exista.
     */
    public static int calcularInversoModular(int a, int m) {
        int[] resultado = euclidesEstendido(a, m);
        int mdc = resultado[0];
        int x = resultado[1];

        if (mdc != 1) {
            return -1; // O inverso modular não existe se mdc(a, m) != 1
        }

        // Garantir que o resultado seja positivo no espaço modular
        return (x % m + m) % m;
    }
}
