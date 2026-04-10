# ESTRUTURA DE DADOS 

Repositório contendo os projetos desenvolvidos na disciplina de Estrutura de Dados.

--------------------------------
### ESTRUTURA DO REPOSITÓRIO
- EstruturaDeDadosII/
    - projeto1-arvores/
        - BST.java
        - AVL.java
        - RubroNegra.java
        - CaixeiroViajante.java
        - Main.java

    - projeto2-buscas/
        - BuscaSequencial.java
        - BuscaBinaria.java
        - ArvoreBST.java
        - Main.java
    
    - projeto3-ordenacao/
        - BubbleSort.java
        - MergeSort.java
        - Main.java
----------------------------------
### PROJETO 1 - ÁRVORES E CAIXEIRO - VIAJANTE
### Implementações:
- Árvore Binária de Busca (BST)
- Árvore AVL
- Árvore Rubro-Negra
- Problema do Caixeiro-Viajante (vizinho mais próximo)

### RESULTADOS
Estrutura -> Altura:
BST -> 4
AVL -> 3
Rubro-Negra -> 3

### CAIXEIRO-VIAJANTE COM 30 EXECUÇÕES
Cidades -> Média -> Desvio Padrão
   5    -> ~966  -> ~ 421
   10   -> ~3603 -> ~1715
   20   -> ~9990 -> ~507

### CONCLUSÃO
As estruturas que são auto-balanceadas mostraram um desempenho estrutural melhor.

-----------------------------------

### PROJETO 2 - BUSCA
### Implementações:
- Busca Sequencial
- Busca Binária
- Busca em Árvore (BST)

### RESULTADOS (MÉDIA)
- Busca sequencial -> Crescimento linear O(n)
- Busca binária -> desempenho logarítmico O(log n)
- BST -> desempenho médio próximo de O(log n)

### CONCLUSÃO
Algoritmos que apresentaram um desempenho significativamente superior em grandes quantidades de dados contém uma melhor complexidade assintótica.

-----------------------------------

### PROJETO 3 - ORDENAÇÃO
### Implementações:
- Bubble Sort
- Merge Sort

### CENÁRIOS ANALISADOS
- Melhor Caso
- Caso Médio
- Pior Caso

### CONCLUSÃO
- Bubble Sort -> O(n²), ineficiente para grandes entradas.
- Merge Sort -> O(n log n), eficiente e estável.

-------------------------------------

### TECNOLOGIAS UTILIZADAS
- Java
- VSCode
- Git e Github

------------------------------------

### COMO EXECUTAR
1- Acesse a pasta do projeto desejado:
EX: cd projetox

2- Compile com o comando javac *.java

3- Execute com o comando java Main

------------------------------------

### AUTOR
Trabalho desenvolvido por **Fernando Fernandes Silva** para a disciplina de Estrutura de Dados.

