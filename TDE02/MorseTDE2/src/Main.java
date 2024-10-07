import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConversorCodigoMorse conversorMorse = new ConversorCodigoMorse();
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        Scanner scanner = new Scanner(System.in);

        // Menu para o usuário escolher a ação
        System.out.println("Escolha uma opção:");
        System.out.println("1. Decodificar uma palavra");
        System.out.println("2. Decodificar um código Morse");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (opcao == 1) {
            // Decodificar uma palavra
            System.out.print("Digite uma palavra: ");
            String palavra = scanner.nextLine().toUpperCase();

            System.out.println("Inserindo na árvore:");
            for (char c : palavra.toCharArray()) {
                String codigoMorse = conversorMorse.obterCodigoMorse(c);
                if (!codigoMorse.equals("Caractere inválido")) {
                    System.out.println(c + ": " + codigoMorse);
                    arvore.inserir(c, codigoMorse);
                }
            }

            System.out.println("\nÁrvore Binária de Busca:");
            arvore.imprimirArvore();
        } else if (opcao == 2) {
            // Decodificar um código Morse
            System.out.print("Digite UM código Morse: ");
            String codigoMorse = scanner.nextLine();
            char resultado = arvore.decodificar(codigoMorse);
            System.out.println("Caractere decodificado: " + resultado);
        } else {
            // Opção inválida
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
