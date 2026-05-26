import java.util.Scanner;
import java.util.List;
import mdc.MaximoDivisorComum;
import euclides.AlgoritmoEuclides;
import primos.TestePrimalidade;
import primos.FactorizacaoInteiros;
import modular.Congruencia;
import modular.Fermat;
import modular.TeoremaChinesResto;
import euler.TotienteEuler;
import rsa.RSA;

/**
 * Interface de Consola Executável Unificada do Projeto.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=======================================================");
            System.out.println("  ALGORITMOS DOS NÚMEROS E APLICAÇÕES CRIPTOGRÁFICAS  ");
            System.out.println("=======================================================");
            System.out.println("1. Máximo Divisor Comum (MDC Linear)");
            System.out.println("2. Algoritmo de Euclides (MDC Otimizado e Inverso)");
            System.out.println("3. Teste de Primalidade e Fatorização");
            System.out.println("4. Congruência e Exponenciação Modular");
            System.out.println("5. Pequeno Teorema de Fermat");
            System.out.println("6. Teorema Chinês do Resto");
            System.out.println("7. Função Totiente de Euler");
            System.out.println("8. Demonstração Criptográfica do Sistema RSA");
            System.out.println("0. Sair do Programa");
            System.out.print("Escolha uma opção: ");



            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida! Digite um número correspondente às opções: ");
                scanner.next();
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o primeiro número: ");
                    int a1 = scanner.nextInt();
                    System.out.print("Digite o segundo número: ");
                    int b1 = scanner.nextInt();
                    System.out.println("MDC Linear: " + MaximoDivisorComum.calcularMDC(a1, b1));
                    break;
                case 2:
                    System.out.print("Digite o primeiro número (a): ");
                    int ae = scanner.nextInt();
                    System.out.print("Digite o segundo número (b): ");
                    int be = scanner.nextInt();
                    System.out.println("MDC por Euclides: " + AlgoritmoEuclides.calcularMDC(ae, be));
                    System.out.print("Deseja calcular o inverso modular de a mod b? (1-Sim / 2-Não): ");
                    if(scanner.nextInt() == 1) {
                        int inv = AlgoritmoEuclides.calcularInversoModular(ae, be);
                        System.out.println(inv == -1 ? "Inverso inexistente (não são coprimos)." : "Inverso Modular: " + inv);
                    }
                    break;
                case 3:
                    System.out.print("Digite o número para testar e fatorar: ");
                    int n3 = scanner.nextInt();
                    System.out.println("É Primo (Primitivo)? " + TestePrimalidade.ehPrimoPrimitivo(n3));
                    System.out.println("É Primo (Otimizado)? " + TestePrimalidade.ehPrimoOtimizado(n3));
                    List<Integer> f = FactorizacaoInteiros.decompor(n3);
                    System.out.println("Fatores Primos: " + f.toString());
                    break;
                case 4:
                    System.out.print("Digite o valor 'a': ");
                    int am = scanner.nextInt();
                    System.out.print("Digite o valor 'b': ");
                    int bm = scanner.nextInt();
                    System.out.print("Digite o módulo 'm': ");
                    int mm = scanner.nextInt();
                    System.out.println("São congruentes? " + Congruencia.saoCongruentes(am, bm, mm));
                    System.out.println("Exponenciação Rápida (a^b mod m): " + Congruencia.exponenciacaoModular(am, bm, mm));
                    break;
                case 5:
                    System.out.print("Digite a base 'a': ");
                    int af = scanner.nextInt();
                    System.out.print("Digite um primo 'p': ");
                    int pf = scanner.nextInt();
                    System.out.println("Valida Pequeno Teorema de Fermat? " + Fermat.testarTeorema(af, pf));
                    break;
                case 6:
                    System.out.println("Resolvendo sistema de 2 congruências (x ≡ a1 mod m1 e x ≡ a2 mod m2)");
                    int[] num = new int[2];
                    int[] rem = new int[2];
                    System.out.print("Digite a1: "); num[0] = scanner.nextInt();
                    System.out.print("Digite m1: "); rem[0] = scanner.nextInt();
                    System.out.print("Digite a2: "); num[1] = scanner.nextInt();
                    System.out.print("Digite m2: "); rem[1] = scanner.nextInt();
                    int solucao = TeoremaChinesResto.resolver(num, rem);
                    System.out.println(solucao == -1 ? "Sem solução única (módulos não coprimos)." : "Solução única x = " + solucao);
                    break;
                case 7:
                    System.out.print("Digite n para calcular Phi(n): ");
                    int ne = scanner.nextInt();
                    System.out.println("Phi Linear: " + TotienteEuler.calcularPhi(ne));
                    System.out.println("Phi Otimizado (Fórmula de Euler): " + TotienteEuler.calcularPhiOtimizado(ne));
                    break;
                case 8:
                    RSA rsa = new RSA();
                    System.out.println("--- Geração de Chaves Didáticas ---");
                    System.out.print("Escolha Primo p (ex: 61): ");
                    int pRsa = scanner.nextInt();
                    System.out.print("Escolha Primo q (ex: 53): ");
                    int qRsa = scanner.nextInt();
                    System.out.print("Escolha Expoente e (coprimo com Phi, ex: 17): ");
                    int eRsa = scanner.nextInt();

                    if (rsa.gerarChaves(pRsa, qRsa, eRsa)) {
                        System.out.println("Chaves Geradas com Sucesso!");
                        System.out.println("Chave Pública (e, n): (" + rsa.getPublicKeyE() + ", " + rsa.getPublicKeyN() + ")");
                        System.out.println("Chave Privada (d): " + rsa.getPrivateKeyD());

                        System.out.print("\nDigite uma mensagem (inteiro menor que " + rsa.getPublicKeyN() + "): ");
                        int msg = scanner.nextInt();
                        int cifrado = rsa.cifrar(msg);
                        System.out.println("Mensagem Cifrada (Criptograma enviado): " + cifrado);
                        System.out.println("Mensagem Decifrada na receção: " + rsa.decifrar(cifrado));
                    } else {
                        System.out.println("Falha na geração de chaves. Verifique se os números inseridos obedecem às condições matemáticas.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        } while (opcao != 0);
        scanner.close();
    }
}

