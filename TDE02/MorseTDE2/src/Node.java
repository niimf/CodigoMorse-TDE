public class Node {
    char valor;
    boolean folha; // Indica se o nó contém um valor final
    Node esquerda, direita;

    public Node(char valor, boolean folha) {
        this.valor = valor;
        this.folha = folha;
        esquerda = direita = null;
    }
}
