import java.util.Scanner;

public class SistemaRobo {

    /**
     * Método para exibir a sala 20x40 com a posição atual do robô.
     * @param robo O objeto Robo a ser exibido na sala.
     */
    public static void mostrarSala(Robo robo) {
        int maxLinha = Robo.MAX_LINHA;
        int maxColuna = Robo.MAX_COLUNA;
        int linhaRobo = robo.getLinha();
        int colunaRobo = robo.getColuna();

        String linhaDivisora = "=".repeat(maxColuna + 2);

        System.out.println("\n" + linhaDivisora);
        System.out.printf("SALA %dx%d | Robô R1 em (%d, %d)\n", maxLinha, maxColuna, linhaRobo, colunaRobo);
        System.out.println(linhaDivisora);

        for (int r = 0; r < maxLinha; r++) {
            System.out.print("|");
            for (int c = 0; c < maxColuna; c++) {
                if (r == linhaRobo && c == colunaRobo) {
                    System.out.print("1"); // Posição do Robô R1
                } else {
                    System.out.print(" "); // Espaço Vazio
                }
            }
            System.out.println("|");
        }

        System.out.println(linhaDivisora);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Item B: Instanciar 1 objeto Robô: R1 na posição (0,0) com passo 1
        System.out.println("--- Item B: Instanciação e Exibição Inicial ---");
        Robo R1 = new Robo(0, 0, 1); 
        
        R1.mostrarPosicaoAtual();
        mostrarSala(R1);

        // Item C: Loop de Deslocamento Interativo
        System.out.println("\n--- Item C: Deslocamento do Robô ---");
        int escolha = -1;

        while (escolha != 0) {
            System.out.println("\nEscolha o movimento do Robô R1 (Passo: " + R1.getPasso() + "):");
            System.out.println("1 - Andar para Frente");
            System.out.println("2 - Andar para Trás");
            System.out.println("3 - Andar para Direita");
            System.out.println("4 - Andar para Esquerda");
            System.out.println("0 - Sair");
            System.out.print("Digite sua escolha: ");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha

                switch (escolha) {
                    case 1:
                        R1.andarFrente();
                        break;
                    case 2:
                        R1.andarTras();
                        break;
                    case 3:
                        R1.andarDireita();
                        break;
                    case 4:
                        R1.andarEsquerda();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
                
                // A cada escolha, o sistema deve mostrar a sala novamente
                if (escolha >= 1 && escolha <= 4) {
                    R1.mostrarPosicaoAtual();
                    mostrarSala(R1);
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa a entrada inválida
            }
        }
        
        System.out.println("Programa finalizado. Posição final do Robô:");
        R1.mostrarPosicaoAtual();
        scanner.close();
    }
}