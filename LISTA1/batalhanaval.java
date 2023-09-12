import java.util.Scanner;

public class BatalhaNaval {
    static final int NUM_JOGADORES = 2;
    static final int NUM_NAVIOS = 5;
    static final int TAMANHO_TABULEIRO = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao jogo de Batalha Naval!!!");

        // Chamando tabuleiro
        char[][][] tabuleirosModelo = new char[NUM_JOGADORES][TAMANHO_TABULEIRO + 1][TAMANHO_TABULEIRO + 1];
        char[][][] tabuleirosJogo = new char[NUM_JOGADORES][TAMANHO_TABULEIRO + 1][TAMANHO_TABULEIRO + 1];
        for (int i = 0; i < NUM_JOGADORES; i++) {
            tabuleirosModelo[i] = gerarTabuleiro(TAMANHO_TABULEIRO);
            tabuleirosJogo[i] = gerarTabuleiro(TAMANHO_TABULEIRO);
        }

        // Coordenadas
        for (int jogador = 0; jogador < NUM_JOGADORES; jogador++) {
            System.out.println("\nJOGADOR " + (jogador + 1) + ", INSIRA AS COORDENADAS DO SEU NAVIO");

            for (int navio = 0; navio < NUM_NAVIOS; navio++) {
                boolean verificarNavio = false;
                while (!verificarNavio) {
                    System.out.print("Insira a localização do navio " + (navio + 1) + ": ");
                    verificarNavio = gerarNavio(tabuleirosModelo[jogador], scanner.nextInt(), scanner.nextInt());
                }
            }
            imprimirTabuleiro(tabuleirosModelo[jogador]);
        }

        // Inicializando jogo
        int[] contadorAcertos = new int[NUM_JOGADORES];
        int vencedor = -1, alvo = 0;
        while (vencedor == -1) {
            for (int jogador = 0; jogador < NUM_JOGADORES; jogador++) {

                if (jogador == 0)
                    alvo = 1;
                else if (jogador == 1)
                    alvo = 0;

                boolean verificarCoordenada = false;
                while (!verificarCoordenada) {
                    System.out.print("\nJogador " + (jogador + 1) + ", insira a linha/coluna do tiro: ");
                    verificarCoordenada = atirar(jogador, alvo, contadorAcertos, tabuleirosModelo, tabuleirosJogo, scanner.nextInt(), scanner.nextInt());
                }

                imprimirTabuleiro(tabuleirosJogo[alvo]);
                System.out.println("Navios restantes: " + (NUM_NAVIOS - contadorAcertos[jogador]));

                if (NUM_NAVIOS - contadorAcertos[jogador] == 0) {
                    vencedor = jogador;
                    break;
                }
            }
        }

        // Resultado
        System.out.println("\nJOGADOR " + (vencedor + 1) + " VENCEU! VOCÊ AFUNDOU TODOS OS NAVIOS DO OPONENTE!");
        System.out.println("Tabuleiros finais:\nJOGADOR 1:");
        imprimirTabuleiro(tabuleirosJogo[0]);
        System.out.println("\nJOGADOR 2:");
        imprimirTabuleiro(tabuleirosJogo[1]);

        scanner.close();
    	}

   //Geracao de tabuleiro
    public static char[][] gerarTabuleiro(int tamanho) {
        if (tamanho < 1 || tamanho > 9) {
            System.out.println("Erro: O tamanho deve estar entre 1 e 9. Retornando matriz vazia.");
            return null;
        }
        char[][] tabuleiro = new char[tamanho + 1][tamanho + 1];
        tabuleiro[0][0] = '*';

        for (int i = 1; i <= tamanho; i++) {
            tabuleiro[0][i] = (char) (i + '0');
            tabuleiro[i][0] = (char) (i + '0');
            for (int j = 1; j <= tamanho; j++)
                tabuleiro[i][j] = '-';
        }
        return tabuleiro;
    }

    //Imprimindo tabuleiro
    public static void imprimirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++)
                System.out.print(tabuleiro[i][j] + " ");
            System.out.println();
        }
    }

    
    public static boolean gerarNavio(char[][] tabuleiro, int linha, int coluna) {
        if (linha < 1 || linha >= tabuleiro.length || coluna < 1 || coluna >= tabuleiro[0].length)
            System.out.println("Coordenadas inválidas. Escolha coordenadas diferentes.");

        else if (tabuleiro[linha][coluna] == '@')
            System.out.println("Você já posicionou um navio aqui. Escolha coordenadas diferentes.");

        else {
            tabuleiro[linha][coluna] = '@';
            return true;
        }
        return false;
    }

    //Atualizando tabuleiro de acordo com as entradas
    public static boolean atirar(int jogador, int alvo, int[] contadorAcertos, char[][][] tabuleirosModelo, char[][][] tabuleirosJogo, int linha, int coluna) {
        if (linha < 1 || linha >= tabuleirosModelo[0].length || coluna < 1 || coluna >= tabuleirosModelo[0][0].length)
            System.out.println("Coordenadas inválidas. Escolha coordenadas diferentes.");

        else {
            switch (tabuleirosModelo[alvo][linha][coluna]) {
                case 'X':
                case 'O':
                    System.out.println("Você já atirou neste local. Escolha coordenadas diferentes.");
                    break;

                case '-':
                    tabuleirosModelo[alvo][linha][coluna] = 'O';
                    tabuleirosJogo[alvo][linha][coluna] = 'O';
                    System.out.println("JOGADOR " + (++jogador) + " ERROU!");
                    return true;

                case '@':
                    tabuleirosModelo[alvo][linha][coluna] = 'X';
                    tabuleirosJogo[alvo][linha][coluna] = 'X';
                    contadorAcertos[jogador]++;
                    System.out.println("JOGADOR " + (++jogador) + " ACERTOU O NAVIO DO JOGADOR " + (++alvo) + "!!!");
                    return true;
            }
        }
        return false;
    }
}
