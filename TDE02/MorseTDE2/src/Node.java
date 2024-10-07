public class Node {
    char valor;
    boolean folha; 
    Node esquerda, direita;

    public Node(char valor, boolean folha) {
        this.valor = valor;
        this.folha = folha;
        esquerda = direita = null;
    }
}
