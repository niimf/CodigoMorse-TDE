import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConversorCodigoMorse conversorMorse = new ConversorCodigoMorse();
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Decodificar uma palavra");
        System.out.println("2. Fechar programa");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        if (opcao == 1) {
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

        }else if (opcao == 2) {
            scanner.close();
        }else{
            System.out.println("Opção inválida.");

        }

    }
}
