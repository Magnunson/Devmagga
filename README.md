# Documentação Completa 

## Instruções de Execução

Para executar o projeto, siga as instruções abaixo:

1. **Clone o repositório**:
   ```sh
   git clone https://github.com/Magnunson/Devmagga.git
   cd Devmagga
   ```
2. **Compile o projeto**:
   ```sh
   mvn clean install
   ```
3. **Execute a aplicação**:
   ```sh
   mvn exec:java -Dexec.mainClass="com.seuprojeto.Main"
   ```

## Estrutura de Diretórios

A estrutura do diretório é a seguinte:

```
.
├── docs/
│   └── instrucoes.md
├── java/
│   ├── com/
│   │   └── seuprojeto/
│   │       ├── Main.java
│   │       └── ...
├── pom.xml
└── README.md
```

Considere verificar a documentação em `docs/instrucoes.md` para mais detalhes.