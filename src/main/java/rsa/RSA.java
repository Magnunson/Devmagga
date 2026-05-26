package rsa;

import euclides.AlgoritmoEuclides;
import modular.Congruencia;

/**
 * Versão didática e funcional controlada do criptossistema assimétrico RSA.
 */
public class RSA {
    private int n;
    private int e;
    private int d;

    /**
     * Gera as chaves pública e privada com base em dois primos escolhidos.
     */
    public boolean gerarChaves(int p, int q, int eEscolhido) {
        this.n = p * q;
        int phi = (p - 1) * (q - 1);

        if (AlgoritmoEuclides.calcularMDC(eEscolhido, phi) != 1) {
            return false; // 'e' inválido, deve ser coprimo com Phi
        }

        this.e = eEscolhido;
        this.d = AlgoritmoEuclides.calcularInversoModular(this.e, phi);
        return this.d != -1;
    }

    public int cifrar(int mensagem) {
        return (int) Congruencia.exponenciacaoModular(mensagem, this.e, this.n);
    }

    public int decifrar(int criptograma) {
        return (int) Congruencia.exponenciacaoModular(criptograma, this.d, this.n);
    }

    public int getPublicKeyE() { return e; }
    public int getPublicKeyN() { return n; }
    public int getPrivateKeyD() { return d; }
}
