Algoritmos dos Números e Aplicações em Criptografia Assimétrica

Este repositório armazena o projeto prático obrigatório focado na análise matemática, computacional e criptográfica da teoria elementar dos números.

Integrantes do Grupo (5 Elementos)
1. Integrante 1 (Responsável pelas Secções 6.1 e 6.2)
2. Integrante 2 (Responsável pelas Secções 6.3 e 6.4)
3. Integrante 3 (Responsável pelas Secções 6.5 e 6.6)
4. Integrante 4 (Responsável pelas Secções 6.7 e 6.8)
5. Integrante 5 (Responsável pelas Secções 6.9 e 6.10)

Estrutura do Repositório
/src: Arquivos de código-fonte Java organizados por pacotes conceituais.
/exemplos: Arquivo de texto mapeando casos de teste reais executados na consola.
/docs: Documentação complementar sobre os algoritmos desenvolvidos.

 Instruções de Compilação e Execução

Para compilar e executar a aplicação sem o auxílio de IDEs, utilize o terminal de comandos a partir da pasta raiz do projeto:

1.Compilação Completa dos Módulos:
bash
   javac -d bin src/mdc/.java src/euclides/.java src/primos/.java src/modular/.java src/euler/.java src/rsa/.java src/Main.java


 2. Execução do Sistema de Consola:
bash
   java -cp bin Main


 Especificações Técnicas Relevantes
 Ambiente Alvo: Java Runtime Environment (JDK 17 ou superior).
 Parâmetros Operacionais: Entradas inteiras validadas interativamente contra distorções de tipo primitivo (Scanner.hasNextInt()).


Casos de Teste Sugeridos para os Anexos (`entradas-saidas.txt`)
Para preencher as tabelas de evidência exigidas no relatório[span_37](start_span)[span_37](end_span), pode recorrer aos seguintes valores de teste controlados de forma a evitar o estouro de inteiros nos tipos primitivos:
MDC Linear vs Euclides: $a = 252, b = 105 \implies \text{Resultado} = 21$.
Totiente de Euler:$n = 9 \implies \text{Phi} = 6$ (Elementos: 1, 2, 4, 5, 7, 8).
Simulação RSA Didática:Escolha $p = 61$, $q = 53$, $e = 17$. O sistema computará de forma automática o módulo $n = 3233$, a função totiente $\phi(n) = 3120$, e o expoente inverso privado $d = 2753$. Teste cifrar a mensagem numérico-didática $M = 65$ para obter o criptograma correspondente.
