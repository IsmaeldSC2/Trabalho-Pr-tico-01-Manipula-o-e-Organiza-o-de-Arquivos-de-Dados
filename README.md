# AEDS II - TPI-01: Simulação de Organização de Arquivos

Trabalho prático da disciplina de Algoritmos e Estruturas de Dados II sobre simulação de armazenamento em disco.

**Autor:** Ismael dos Santos Costa 
**Matrícula:** 19.2.8190

---

## 1. Descrição

Este programa é um simulador em Java que implementa e compara três estratégias de organização de registros de alunos em blocos de disco de tamanho fixo:

1.  Registros de Tamanho Fixo
2.  Registros de Tamanho Variável (Sem Espalhamento)
3.  Registros de Tamanho Variável (Com Espalhamento)

O usuário pode definir o número de registros, o tamanho do bloco e a estratégia desejada. Ao final, o programa exibe estatísticas detalhadas de eficiência e um mapa de ocupação de todos os blocos utilizados.

---

## 2. Como Executar

O projeto foi escrito em Java puro e não requer dependências externas.

1.  Clone este repositório:
    ```bash
    git clone (link-do-seu-repo)
    ```

2.  Navegue até a pasta `src` (onde estão os arquivos `.java`):
    ```bash
    cd NOME-DO-REPOSITORIO/src
    ```

3.  Compile todos os arquivos `.java`:
    ```bash
    javac *.java
    ```

4.  Execute a classe `Main`:
    ```bash
    java Main
    ```

---

## 3. Exemplo de Execução (Screenshot)

Aqui está um exemplo do programa em funcionamento, simulando 10.000 registros em blocos de 512 bytes com a estratégia de tamanho variável com espalhamento.

<img width="1795" height="814" alt="Captura de tela 2025-11-15 235001" src="https://github.com/user-attachments/assets/5d4be573-458b-4351-8a1b-ce4260a66218" />
<img width="1779" height="808" alt="Captura de tela 2025-11-15 235013" src="https://github.com/user-attachments/assets/05c77a17-5a81-49ab-95e1-14d3404f5d4c" />
<img width="1789" height="815" alt="Captura de tela 2025-11-15 235027" src="https://github.com/user-attachments/assets/54ff77b1-88b3-47f0-9ed2-b96869c0b188" />

---

## 4. Relatório Descritivo da Solução

### 4.1. Introdução

Este trabalho prático tem como objetivo simular o armazenamento físico de registros de dados em disco, respeitando a organização em blocos de tamanho fixo. O contexto do problema é o de um sistema de gerenciamento de dados de alunos, onde a forma como os registros são persistidos influencia diretamente a eficiência e o desempenho do sistema.

O simulador desenvolvido permite ao usuário definir parâmetros-chave (tamanho do bloco, número de registros) e analisar visualmente o impacto de três estratégias distintas de armazenamento, comparando a eficiência de cada uma em termos de ocupação de espaço.

### 4.2. Objetivos

O projeto foi desenvolvido para cumprir os seguintes objetivos principais:

* **Simular** o armazenamento de registros em blocos de tamanho fixo, definido pelo usuário.
* **Implementar** e comparar três estratégias de organização de registros:
    1.  Registros de Tamanho Fixo;
    2.  Registros de Tamanho Variável (Contíguos, sem espalhamento);
    3.  Registros de Tamanho Variável (Espalhados, com fragmentação).
* **Calcular** e exibir estatísticas detalhadas, incluindo o número total de blocos, a taxa de ocupação individual de cada bloco e a eficiência total do armazenamento.
* **Exibir** um mapa textual da ocupação dos blocos, facilitando a visualização dos resultados.

### 4.3. Decisões de Projeto e Arquitetura

A primeira decisão de projeto foi a escolha da linguagem de programação. O **Java** foi selecionado por duas razões principais: uma técnica e outra relacionada à proficiência.

Tecnicamente, a natureza do Java ser fortemente baseada na **Programação Orientada a Objetos (POO)** alinha-se perfeitamente aos requisitos do trabalho. O problema exigia a simulação de diferentes "entidades" (como `Aluno` e `Bloco`) que interagem de formas complexas. Os pilares da POO, como **Encapsulamento** (usado para proteger os dados do `Bloco`) e **Abstração** (usado para modelar o `Aluno`), permitiram criar um código mais limpo, organizado e fácil de manter.

Além da adequação técnica, a escolha foi reforçada pela familiaridade e especialização contínua com a linguagem. O primeiro contato com Java ocorreu na universidade, na disciplina de Programação II. Desde então, venho aprofundando meus estudos na linguagem, estando atualmente em um curso de especialização em back-end (na Alura). Essa proficiência permitiu focar mais na complexidade lógica do simulador e menos nos desafios de sintaxe de uma nova linguagem.

Partindo dessa decisão, para gerenciar a complexidade e garantir a clareza do código, o projeto foi estruturado em seis classes distintas, onde cada classe possui uma responsabilidade única:

1.  **`Aluno.java` (Entidade de Dados / POJO):**
    * **Responsabilidade:** Representar o "molde" de um registro.
    * **Métodos-Chave:** `getTamanhoFixoMaximo()` e `getTamanhoVariavel()`.

2.  **`Bloco.java` (Contêiner):**
    * **Responsabilidade:** Simular um único bloco de disco, usando encapsulamento para seus atributos `tamanhoMaximo` e `usado`.
    * **Métodos-Chave:** `cabeInteiro()`, `escreverInteiro()` e `escreverFragmento()`.

3.  **`SimuladorArmazenamento.java` (Gerenciador / Lógica Principal):**
    * **Responsabilidade:** O "cérebro" da aplicação. Gerencia a `ArrayList` de `Bloco` e contém a lógica para as três estratégias de armazenamento.
    * **Métodos-Chave:** `armazenarRegistroFixo()`, `armazenarVariavelSemEspalhar()` e `armazenarVariavelComEspalhar()`.

4.  **`GeradorAlunos.java` (Fábrica / Helper):**
    * **Responsabilidade:** Classe utilitária dedicada a criar e retornar objetos `Aluno` com dados aleatórios.

5.  **`Estatisticas.java` (Utilitário / Repórter):**
    * **Responsabilidade:** Classe utilitária que recebe a lista final de blocos, processa os cálculos e imprime o relatório final.

6.  **`Main.java` (Orquestrador / Ponto de Entrada):**
    * **Responsabilidade:** Orquestrar o fluxo da aplicação: (1) Pedir dados ao usuário, (2) Chamar o Gerador, (3) Chamar o Simulador, e (4) Chamar as Estatísticas.

### 4.4. Implementação das Estratégias

A lógica de cada estratégia foi implementada no `SimuladorArmazenamento`:

#### 4.4.1. Registros de Tamanho Fixo
* **Cálculo:** O tamanho é calculado **uma única vez** via `Aluno.getTamanhoFixoMaximo()`, somando o tamanho máximo de todos os campos (163 bytes).
* **Lógica:** O simulador verifica se 163 bytes cabem (`bloco.cabeInteiro()`). Se não, cria um novo bloco. A escrita é feita com `bloco.escreverInteiro()`.

#### 4.4.2. Registros de Tamanho Variável (Sem Espalhamento)
* **Cálculo:** O tamanho é calculado **a cada iteração** via `aluno.getTamanhoVariavel()`, somando os bytes reais das strings (`.getBytes()`) e o tamanho fixo dos numéricos (4 bytes).
* **Lógica:** A lógica é idêntica à do Tamanho Fixo, mas usa o tamanho real do registro. Se não couber, vai integralmente para o próximo bloco.

#### 4.4.3. Registros de Tamanho Variável (Com Espalhamento)
* **Cálculo:** O cálculo do tamanho é o mesmo da estratégia 4.4.2.
* **Lógica:** Utiliza um loop `while (restante > 0)`.
    1.  O método `bloco.escreverFragmento()` é chamado, gravando o mínimo entre o espaço livre e o `restante`.
    2.  O `restante` é subtraído.
    3.  Se `restante > 0` após a escrita, o bloco encheu, e um novo bloco é criado para o `restante` no próximo loop.

### 4.5. Desafios e Pontos Críticos

Durante o desenvolvimento, dois erros lógicos principais foram identificados e corrigidos:

1.  **Cálculo Incorreto de Tamanho:** A primeira versão de `getTamanhoVariavel()` tratava `int` e `float` como strings. A correção envolveu usar o tamanho fixo de 4 bytes para esses tipos.
2.  **Lógica de Escrita Incompleta/Incorreta:**
    * No `armazenarRegistroFixo()`, a linha `bloco.escreverInteiro()` estava ausente.
    * No `armazenarVariavelSemEspalhar()`, o método `escreverFragmento()` era usado incorretamente. Foi necessário criar e usar o método `escreverInteiro()` para esta lógica.

### 4.6. Conclusão

O projeto foi concluído com sucesso, e o simulador se mostrou eficaz em demonstrar visualmente as diferenças entre as estratégias de armazenamento. A arquitetura baseada em POO foi fundamental para gerenciar a lógica do problema.

A simulação deixa claro o *trade-off* clássico: a estratégia de Tamanho Fixo é a mais simples, mas a menos eficiente. As estratégias de Tamanho Variável economizam espaço (especialmente a com espalhamento), mas aumentam drasticamente a complexidade de implementação.
