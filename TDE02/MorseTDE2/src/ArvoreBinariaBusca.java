class ArvoreBinariaBusca {
    Node raiz;

    public ArvoreBinariaBusca() {
        raiz = null;
    }

    // Método para inserir um caractere baseado em seu código Morse
    public void inserir(char letra, String codigoMorse) {
        raiz = inserirRecursiva(raiz, letra, codigoMorse, 0);
    }

    // Função recursiva para inserir o caractere baseado no código Morse
    private Node inserirRecursiva(Node atual, char letra, String codigoMorse, int indice) {
        if (atual == null) {
            atual = new Node('\0', false); // Cria um nó intermediário (não é folha)
        }

        if (indice == codigoMorse.length()) {
            if (!atual.folha) {  // Evita duplicação de letras
                atual.valor = letra;
                atual.folha = true; // Marca o nó como folha (com letra)
            }
            return atual;
        }

        char caractereMorse = codigoMorse.charAt(indice);
        if (caractereMorse == '.') {
            atual.esquerda = inserirRecursiva(atual.esquerda, letra, codigoMorse, indice + 1);
        } else if (caractereMorse == '-') {
            atual.direita = inserirRecursiva(atual.direita, letra, codigoMorse, indice + 1);
        }

        return atual;
    }

    // Método para decodificar um código Morse e retornar o caractere correspondente
    public char decodificar(String codigoMorse) {
        Node atual = raiz;
        for (char caractereMorse : codigoMorse.toCharArray()) {
            if (caractereMorse == '.') {
                atual = atual.esquerda;
            } else if (caractereMorse == '-') {
                atual = atual.direita;
            }

            // Se chegar em um nó nulo, o código morse está incorreto ou não foi inserido
            if (atual == null) {
                return '?'; // Caractere inválido
            }
        }

        // Verifica se o nó final é uma folha
        if (atual != null && atual.folha) {
            return atual.valor; // Retorna o valor do nó decodificado
        } else {
            return '?'; // Se não for uma folha, o código Morse não corresponde a uma letra válida
        }
    }

    // Método para imprimir a árvore de forma formatada
    public void imprimirArvore(Node no, String prefixo, boolean isEsquerda) {
        if (no != null) {
            // Primeiro imprime o nó direito (ramificação para direita)
            imprimirArvore(no.direita, prefixo + (isEsquerda ? "│   " : "    "), false);

            // Verifica se o nó é uma folha e imprime o valor
            if (no.folha) {
                System.out.println(prefixo + (isEsquerda ? "└── " : "┌── ") + no.valor);
            } else {
                System.out.println(prefixo + (isEsquerda ? "└── " : "┌── ") + "•");
            }

            // Imprime o nó esquerdo (ramificação para esquerda)
            imprimirArvore(no.esquerda, prefixo + (isEsquerda ? "    " : "│   "), true);
        }
    }

    // Método auxiliar para iniciar a impressão formatada a partir da raiz
    public void imprimirArvore() {
        if (raiz != null) {
            imprimirArvore(raiz, "", true);
        } else {
            System.out.println("Árvore está vazia.");
        }
    }
}
