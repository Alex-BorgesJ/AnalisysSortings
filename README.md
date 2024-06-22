### Projeto AnalysisSortings

O projeto **AnalysisSortings** tem como objetivo realizar uma análise comparativa de diferentes algoritmos de ordenação sobre um mesmo conjunto de dados, representado por arrays de tamanhos variados e organizados em três formas: crescente, decrescente e aleatória. A comparação foca nos algoritmos **selectionSort**, **insertionSort**, **mergeSort**, **bubbleSort**, **quickSort** e **Arrays.sort()**, agrupando-os em duas categorias principais: algoritmos com complexidade O(n²) e algoritmos com complexidade O(n log n).

### Metodologia

O programa executa um teste para cada um dos algoritmos mencionados, onde cada teste consiste na ordenação do array cinco vezes para cada tipo de organização (crescente, decrescente, aleatória). Utiliza-se a unidade de medida em nanossegundos para mensurar o tempo de execução de cada algoritmo.

### Algoritmos Analisados

**Complexidade O(n²):**
- **selectionSort**: Ordena o array selecionando repetidamente o menor elemento restante.
- **insertionSort**: Constrói uma matriz ordenada um elemento por vez, comparando cada elemento com os elementos já ordenados.
- **bubbleSort**: Passa repetidamente pelo array, compara elementos adjacentes e troca-os se estiverem na ordem errada.

**Complexidade O(n log n):**
- **mergeSort**: Divide o array em metades, ordena cada metade recursivamente e depois combina as metades ordenadas.
- **quickSort**: Seleciona um elemento como pivô e particiona o array ao redor do pivô.
- **Arrays.sort()**: Utiliza uma versão otimizada de quickSort ou mergeSort dependendo do tipo de dado.

### Resultados

Ao final da execução, o programa apresenta os resultados de forma organizada, exibindo os tempos médios de execução de cada algoritmo para cada tipo de organização do array (crescente, decrescente, aleatório).

### Observações

- O projeto utiliza uma abordagem de clonagem de arrays para garantir que cada algoritmo de ordenação opere sobre o mesmo conjunto inicial de dados, proporcionando uma comparação justa e precisa.
- Os resultados são representados em uma estrutura de dados tabular para facilitar a interpretação e comparação dos tempos de execução.

### Conclusão

Este projeto não só demonstra a eficiência relativa dos diferentes algoritmos de ordenação em diferentes cenários de dados, mas também serve como um recurso educacional valioso para entender a importância da escolha do algoritmo correto dependendo do tipo e tamanho dos dados a serem processados.

Para mais detalhes sobre os resultados específicos e implementações dos algoritmos, consulte o código fonte disponibilizado neste repositório.