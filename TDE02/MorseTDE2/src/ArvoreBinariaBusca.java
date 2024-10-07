class ArvoreBinariaBusca {
    Node raiz;

    public ArvoreBinariaBusca() {
        raiz = null;
    }

    public void inserir(char letra, String codigoMorse) {
        raiz = inserirRecursiva(raiz, letra, codigoMorse, 0);
    }

    private Node inserirRecursiva(Node atual, char letra, String codigoMorse, int indice) {
        if (atual == null) {
            atual = new Node('\0', false); 
        }

        if (indice == codigoMorse.length()) {
            if (!atual.folha) {  
                atual.valor = letra;
                atual.folha = true;
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

    public char decodificar(String codigoMorse) {
        Node atual = raiz;
        for (char caractereMorse : codigoMorse.toCharArray()) {
            if (caractereMorse == '.') {
                atual = atual.esquerda;
            } else if (caractereMorse == '-') {
                atual = atual.direita;
            }

            if (atual == null) {
                return '?'; 
            }
        }

        if (atual != null && atual.folha) {
            return atual.valor; 
        } else {
            return '?';
        }
    }

    public void imprimirArvore(Node no, String prefixo, boolean isEsquerda) {
        if (no != null) {
            imprimirArvore(no.direita, prefixo + (isEsquerda ? "│   " : "    "), false);
            
            if (no.folha) {
                System.out.println(prefixo + (isEsquerda ? "└── " : "┌── ") + no.valor);
            } else {
                System.out.println(prefixo + (isEsquerda ? "└── " : "┌── ") + "•");
            }

            imprimirArvore(no.esquerda, prefixo + (isEsquerda ? "    " : "│   "), true);
        }
    }

    public void imprimirArvore() {
        if (raiz != null) {
            imprimirArvore(raiz, "", true);
        } else {
            System.out.println("Árvore está vazia.");
        }
    }
}
