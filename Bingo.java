import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //###################################################################################################

        int quantidadeBolas = getQuantidadeBolas(scanner);

        //###################################################################################################

        String[] jogadores = getJogadores(scanner);

        //###################################################################################################

        int opcao = getModos(scanner);

        //###################################################################################################

        final int NICKNAME = 0;
        final int CARTELA_INICIO = 1;
        final int NUMENROS_ACERTADOS_INICIO = 7;
        final int SCORE_PLAYER = 13;

        //###################################################################################################

        if (opcao == 1) {
            String[][] tabela = getTabela(scanner, quantidadeBolas, jogadores);

            listarCartelas(NICKNAME, jogadores, tabela);

            sortearManual(scanner, NICKNAME, CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, quantidadeBolas, jogadores, tabela);
        }
        else if (opcao == 2) {
            String[][] tabela = getTabela(scanner, quantidadeBolas, jogadores);

            listarCartelas(NICKNAME, jogadores, tabela);

            sortearRandom(scanner, NICKNAME, CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, quantidadeBolas, jogadores, tabela);
        }
        else if (opcao == 3) {
            String[][] tabela = getTabela(quantidadeBolas, jogadores);

            listarCartelas(NICKNAME, jogadores, tabela);

            sortearManual(scanner, NICKNAME, CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, quantidadeBolas, jogadores, tabela);
        }
        else {
            String[][] tabela = getTabela(quantidadeBolas, jogadores);

            listarCartelas(NICKNAME, jogadores, tabela);

            sortearRandom(scanner, NICKNAME, CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, quantidadeBolas, jogadores, tabela);
        }
    }

    private static void rankingGeral(int NICKNAME, int CARTELA_INICIO, int NUMENROS_ACERTADOS_INICIO, int SCORE_PLAYER, int round, String[] jogadores, int[] bolasEscolhidas, String[][] tabela) {

        System.out.println("##### RANKING GERAL #####");
        System.out.println("\n###################################################################################################\n");

        Arrays.sort(bolasEscolhidas);

        System.out.printf("TOTAL DE ROUNDS: %d\n\n", (round - 1));

        System.out.println("@@@  VENCEDORES  @@@");
        for (int i = 0; i < jogadores.length; i++) {
            if (Integer.parseInt(tabela[i][SCORE_PLAYER]) == 5) {
                int[] cartela = new int[5];

                for (int k = 0; k < 5; k++) {
                    cartela[k] = Integer.parseInt(tabela[i][(k+ CARTELA_INICIO)]);
                }

                Arrays.sort(cartela);

                System.out.println();
                System.out.printf("%s com a cartela: \n", tabela[i][NICKNAME]);
                System.out.println(Arrays.toString(cartela));
            }
        }
        System.out.println("\n@@@   ========   @@@\n");

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < jogadores.length; j++) {
                if (Integer.parseInt(tabela[j][SCORE_PLAYER]) == i) {
                    String[] numerosAcertados = new String[5];

                    System.arraycopy(tabela[j], NUMENROS_ACERTADOS_INICIO, numerosAcertados, 0, 5);

                    System.out.printf("Pontuação do %s: %s \n", tabela[j][NICKNAME],  tabela[j][SCORE_PLAYER]);
                    System.out.printf("%s\n\n", Arrays.toString(numerosAcertados));
                }
            }
        }

        System.out.printf("Foram sorteadas um total de %d bolas.\n    Lista dos números sorteados (crescente):\n\n", (round - 1));
        System.out.println(Arrays.toString(bolasEscolhidas));
        System.out.println("\n###################################################################################################");
    }

    private static void sortearRandom(Scanner scanner, int NICKNAME, int CARTELA_INICIO, int NUMENROS_ACERTADOS_INICIO, int SCORE_PLAYER, int quantidadeBolas, String[] jogadores, String[][] tabela) {

        System.out.println("\nSorteio (RANDOM):\n");

        int[] bolasEscolhidas = new int[quantidadeBolas];
        int bingo = validarBingo(SCORE_PLAYER, jogadores, tabela);

        int round = 1;
        int freioDeMao = 0;
        final String CONTINUAR = "C";
        final String PARAR = "X";
        boolean verificador = true;
        String pergunta;

        //###################################################################################################

        while (condicoesEncerramento(quantidadeBolas, bingo, round, freioDeMao)) {
            int i = round - 1;
            mensagemRoundValido(round);
            pergunta = scanner.next();

            if (pergunta.equalsIgnoreCase(CONTINUAR)) {
                round(CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, i, quantidadeBolas, jogadores, bolasEscolhidas, tabela);
                listarRanking(NICKNAME, SCORE_PLAYER, jogadores, tabela);

                System.out.println("\n###################################################################################################\n");
                bingo = validarBingo(SCORE_PLAYER, jogadores, tabela);
                round++;
            }
            else if (pergunta.equalsIgnoreCase(PARAR)) {
                freioDeMao = mensagemJogoEnterrompido();
            }
            else {
                while (verificador) {
                    mensagemRoundInvalido(round);
                    pergunta = scanner.next();

                    if (pergunta.equalsIgnoreCase(CONTINUAR)) {
                        round(CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, i, quantidadeBolas, jogadores, bolasEscolhidas, tabela);
                        listarRanking(NICKNAME, SCORE_PLAYER, jogadores, tabela);

                        System.out.println("\n###################################################################################################\n");
                        bingo = validarBingo(SCORE_PLAYER, jogadores, tabela);
                        round++;
                        verificador = false;
                    }
                    else if (pergunta.equalsIgnoreCase(PARAR)) {
                        freioDeMao = mensagemJogoEnterrompido();
                        verificador = false;
                    }
                }
            }
        }

        //###################################################################################################

        rankingGeral(NICKNAME, CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, round, jogadores, bolasEscolhidas, tabela);
    }

    private static void sortearManual(Scanner scanner, int NICKNAME, int CARTELA_INICIO, int NUMENROS_ACERTADOS_INICIO, int SCORE_PLAYER, int quantidadeBolas, String[] jogadores, String[][] tabela) {

        System.out.println("\nSorteio (MANUAL):\n");

        int[] bolasEscolhidas = new int[quantidadeBolas];
        int bingo = validarBingo(SCORE_PLAYER, jogadores, tabela);

        int round = 1;
        int freioDeMao = 0;
        final String CONTINUAR = "C";
        final String PARAR = "X";
        boolean verificador = true;
        String pergunta;

        //###################################################################################################

        while (condicoesEncerramento(quantidadeBolas, bingo, round, freioDeMao)) {
            int i = round - 1;

            mensagemRoundValido(round);
            pergunta = scanner.next();

            if (pergunta.equalsIgnoreCase(CONTINUAR)) {
                round(scanner, CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, i, quantidadeBolas, jogadores, bolasEscolhidas, tabela);
                listarRanking(NICKNAME, SCORE_PLAYER, jogadores, tabela);

                System.out.println("\n###################################################################################################\n");
                bingo = validarBingo(SCORE_PLAYER, jogadores, tabela);
                round++;
            }
            else if (pergunta.equalsIgnoreCase(PARAR)) {
                freioDeMao = mensagemJogoEnterrompido();
            }
            else {
                while (verificador) {
                    mensagemRoundInvalido(round);
                    pergunta = scanner.next();

                    if (pergunta.equalsIgnoreCase(CONTINUAR)) {
                        round(scanner, CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, i, quantidadeBolas, jogadores, bolasEscolhidas, tabela);
                        listarRanking(NICKNAME, SCORE_PLAYER, jogadores, tabela);

                        System.out.println("\n###################################################################################################\n");
                        bingo = validarBingo(SCORE_PLAYER, jogadores, tabela);
                        round++;
                        verificador = false;
                    }
                    else if (pergunta.equalsIgnoreCase(PARAR)) {
                        freioDeMao = mensagemJogoEnterrompido();
                        verificador = false;
                    }
                }
            }
        }

        //###################################################################################################

        rankingGeral(NICKNAME, CARTELA_INICIO, NUMENROS_ACERTADOS_INICIO, SCORE_PLAYER, round, jogadores, bolasEscolhidas, tabela);
    }

    private static boolean condicoesEncerramento(int quantidadeBolas, int bingo, int round, int freioDeMao) {
        return (bingo == 0) && (freioDeMao == 0) && (round <= quantidadeBolas);
    }

    private static void listarRanking(int NICKNAME, int SCORE_PLAYER, String[] jogadores, String[][] tabela) {
        int contador = 0;

        System.out.println("###################################################################################################\n");
        System.out.println("##### TOP 3 #####");
        System.out.println("\n###################################################################################################\n");

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < jogadores.length; j++) {
                if ((Integer.parseInt(tabela[j][SCORE_PLAYER]) == i) && (contador < 3)) {
                    System.out.printf("Pontuação do %s: %d \n", tabela[j][NICKNAME], Integer.parseInt(tabela[j][SCORE_PLAYER]));
                    contador++;
                }
            }
        }
    }

    private static void round(Scanner scanner, int CARTELA_INICIO, int NUMENROS_ACERTADOS_INICIO, int SCORE_PLAYER, int i, int quantidadeBolas, String[] jogadores, int[] bolasEscolhidas, String[][] tabela) {
        int bolaSorteada;
        System.out.println("Informe o valor da bola escolhida que respeite o intervalo de 1 à " + quantidadeBolas);
        bolaSorteada = scanner.nextInt();

        //###################################################################################################

        while (validarRound(bolaSorteada, quantidadeBolas)) {
            System.out.println("O valor desrespeita o intervalo de 1 à " + quantidadeBolas);
            System.out.println("Informe o valor da bola escolhida que respeite o intervalo de 1 à " + quantidadeBolas + " novamente");
            bolaSorteada = scanner.nextInt();
        }

        //###################################################################################################

        while (validarPertencimentoArray(bolaSorteada, bolasEscolhidas)) {
            System.out.println(Arrays.toString(bolasEscolhidas));
            System.out.println("Esse valor já foi informado previamenete, por favor informe outro número");
            bolaSorteada = scanner.nextInt();
        }

        //###################################################################################################

        System.out.printf("\n$$$ A bola sorteada foi %d $$$\n\n", bolaSorteada);
        bolasEscolhidas[i] = bolaSorteada;

        //###################################################################################################

        for (int j = 0; j < jogadores.length; j++) {
            int[] cartela = new int[5];
            int[] numerosAcertados = new int[5];
            int scorePlayer = 0;

            for (int k = 0; k < 5; k++) {
                cartela[k] = Integer.parseInt(tabela[j][(k+ CARTELA_INICIO)]);
                numerosAcertados[k] = Integer.parseInt(tabela[j][(k+ NUMENROS_ACERTADOS_INICIO)]);
                scorePlayer = Integer.parseInt(tabela[j][SCORE_PLAYER]);
            }

            if (validarPertencimentoArray(bolaSorteada, cartela)) {
                numerosAcertados[scorePlayer] = bolaSorteada;
                tabela[j][(scorePlayer+ NUMENROS_ACERTADOS_INICIO)] = String.valueOf(numerosAcertados[scorePlayer]);
                scorePlayer += 1;
            }

            tabela[j][SCORE_PLAYER] = String.valueOf(scorePlayer);
        }
    }

    private static void round(int CARTELA_INICIO, int NUMENROS_ACERTADOS_INICIO, int SCORE_PLAYER, int i, int quantidadeBolas, String[] jogadores, int[] bolasEscolhidas, String[][] tabela) {
        int bolaSorteada;
        bolaSorteada = sortearBolaAutomatico(quantidadeBolas, bolasEscolhidas);
        System.out.printf("\n$$$ A bola sorteada foi %d $$$\n\n", bolaSorteada);
        bolasEscolhidas[i] = bolaSorteada;

        //###################################################################################################

        for (int j = 0; j < jogadores.length; j++) {
            int[] cartela = new int[5];
            int[] numerosAcertados = new int[5];
            int scorePlayer = 0;

            for (int k = 0; k < 5; k++) {
                cartela[k] = Integer.parseInt(tabela[j][(k+CARTELA_INICIO)]);
                numerosAcertados[k] = Integer.parseInt(tabela[j][(k+NUMENROS_ACERTADOS_INICIO)]);
                scorePlayer = Integer.parseInt(tabela[j][SCORE_PLAYER]);
            }

            if (validarPertencimentoArray(bolaSorteada, cartela)) {
                numerosAcertados[scorePlayer] = bolaSorteada;
                tabela[j][(scorePlayer+NUMENROS_ACERTADOS_INICIO)] = String.valueOf(numerosAcertados[scorePlayer]);
                scorePlayer += 1;
            }

            tabela[j][SCORE_PLAYER] = String.valueOf(scorePlayer);
        }
    }

    private static boolean validarRound(int bolaSorteada, int quantidadeBolas) {
        boolean validacaoNumeros = (bolaSorteada <= 0);
        boolean validacaoLimite = (bolaSorteada > quantidadeBolas);
        return (validacaoNumeros || validacaoLimite);
    }

    private static boolean validarPertencimentoArray(int elemento, int[] array) {
        boolean verificador = false;

        for (int j : array) {
            if (elemento == j) {
                verificador = true;
                break;
            }
        }
        return verificador;
    }

    private static int sortearBolaAutomatico(int quantidadeBolas, int[] bolasEscolhidas) {
        Random random = new Random();

        int a = random.nextInt(1, (quantidadeBolas+1));

        while (validarPertencimentoArray(a, bolasEscolhidas)) {
            a = random.nextInt(1, (quantidadeBolas+1));
        }

        return a;
    }

    private static int mensagemJogoEnterrompido() {
        System.out.println("Você abortou a brincadeira");
        return 47;
    }

    private static void mensagemRoundInvalido(int round) {
        System.out.println("\nOpção Inválida, digite a tecla:");
        System.out.println("    C - Para continuar o Round " + round);
        System.out.println("    X - Para parar o jogo");
    }

    private static void mensagemRoundValido(int round) {
        System.out.println("Round " + round);
        System.out.println("\nDigite a tecla:");
        System.out.println("    C - Para continuar o Round " + round);
        System.out.println("    X - Para parar o jogo");
    }

    private static int validarBingo(int scoreJogador, String[] jogadores, String[][] tabela) {
        int bingo = 0;
        for (int i = 0; i < jogadores.length; i++) {
            if (Integer.parseInt(tabela[i][scoreJogador]) == 5) {
                bingo += 1;
            }
        }
        return bingo;
    }

    private static void listarCartelas(int NICKNAME, String[] jogadores, String[][] tabela) {
        System.out.println("Lista de cartelas geradas:\n");
        for (int i = 0; i < jogadores.length; i++) {
            int j = i + 1;
            String[] cartela = new String[6];

            System.arraycopy(tabela[i], NICKNAME, cartela, 0, 6);

            System.out.printf("Player %d: %s\n", j, Arrays.toString(cartela));
        }
        System.out.println("\n###################################################################################################\n");
    }

    private static String[][] getTabela(Scanner scanner, int quantidadeBolas, String[] jogadores) {
        String[][] tabela = new String[jogadores.length][];

        for (int i = 0; i < jogadores.length; i++) {
            String apelidos = jogadores[i];
            System.out.printf("Preenchendo a cartela do jogador %s (MANUAL):\n", apelidos);

            int[] cartela = getCartela(scanner, quantidadeBolas);

            tabela[i] = new String[] {apelidos, String.valueOf(cartela[0]),
                    String.valueOf(cartela[1]), String.valueOf(cartela[2]),
                    String.valueOf(cartela[3]), String.valueOf(cartela[4]), "-", "0", "0", "0", "0", "0", "-", "0", "-"};
            System.out.println("\n###################################################################################################\n");
        }
        return tabela;
    }

    private static String[][] getTabela(int quantidadeBolas, String[] jogadores) {
        String[][] tabela = new String[jogadores.length][];

        for (int i = 0; i < jogadores.length; i++) {
            String nickname = jogadores[i];

            int[] cartela = getCartela(quantidadeBolas);

            tabela[i] = new String[] {nickname, String.valueOf(cartela[0]),
                    String.valueOf(cartela[1]), String.valueOf(cartela[2]),
                    String.valueOf(cartela[3]), String.valueOf(cartela[4]), "-", "0", "0", "0", "0", "0", "-", "0", "-"};
        }
        return tabela;
    }

    private static int[] getCartela(Scanner scanner, int quantidadeBolas) {
        System.out.println("\nInforme os cinco valores distintos respeitando o intervalo de 1 à " + quantidadeBolas);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        boolean validacaoCartela = validarCartela(a, b, c, d, e, quantidadeBolas);


        while (validacaoCartela) {
            System.out.println("\nHá valores repetidos na cartela ou valores que desrespeitam o intervalo de 1 à " + quantidadeBolas);
            System.out.println("\nInforme os cinco valores distintos respeitando o intervalo de 1 à " + quantidadeBolas + " novamente");

            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            d = scanner.nextInt();
            e = scanner.nextInt();

            validacaoCartela = validarCartela(a, b, c, d, e, quantidadeBolas);
        }
        return new int[]{a, b, c, d, e};
    }

    private static int[] getCartela(int quantidadeBolas) {
        Random random = new Random();

        int a = random.nextInt(1, (quantidadeBolas+1));
        int b = random.nextInt(1, (quantidadeBolas+1));
        int c = random.nextInt(1, (quantidadeBolas+1));
        int d = random.nextInt(1, (quantidadeBolas+1));
        int e = random.nextInt(1, (quantidadeBolas+1));

        boolean validacaoCartela = validarCartela(a, b, c, d, e, quantidadeBolas);

        while (validacaoCartela) {
            a = random.nextInt(1, (quantidadeBolas+1));
            b = random.nextInt(1, (quantidadeBolas+1));
            c = random.nextInt(1, (quantidadeBolas+1));
            d = random.nextInt(1, (quantidadeBolas+1));
            e = random.nextInt(1, (quantidadeBolas+1));

            validacaoCartela = validarCartela(a, b, c, d, e, quantidadeBolas);
        }

        return new int[]{a, b , c, d, e};
    }

    private static boolean validarCartela(int a, int b, int c, int d, int e, int quantidadeBolas) {
        boolean validacaoNumeros = ((a <= 0) || (b <= 0) || (c <= 0) || (d <= 0) || (e <= 0));
        boolean validacaoLimite = ((a > quantidadeBolas) || (b > quantidadeBolas) || (c > quantidadeBolas) || (d > quantidadeBolas) || (e > quantidadeBolas));
        boolean validacaoEmA = ((a == b) || (a == c) || (a == d) || (a == e));
        boolean validacaoEmB = ((b == c) || (b == d) || (b == e));
        boolean validacaoEmC = ((c == d) || (c == e));
        boolean validacaoEmD = (d == e);
        return (validacaoNumeros || validacaoLimite || validacaoEmA || validacaoEmB || validacaoEmC || validacaoEmD);
    }

    private static int getModos(Scanner scanner) {
        System.out.println("BEM VINDO AO JOGO (...)");
        System.out.println("\n###################################################################################################\n");

        System.out.println("Modos de Jogo:\n");

        System.out.println("1 - Modo CARTELA (MANUAL) - SORTEIO (MANUAL)\n");
        System.out.println("2 - Modo CARTELA (MANUAL) - SORTEIO (RANDOM)\n");
        System.out.println("3 - Modo CARTELA (RANDOM) - SORTEIO (MANUAL)\n");
        System.out.println("4 - Modo CARTELA (RANDOM) - SORTEIO (RANDOM)");
        System.out.println("\n###################################################################################################\n");

        System.out.println("Escolha o modo de jogo:");
        boolean controlador = true;
        int comando = 0;
        String opcao;

        while (controlador) {
            comando = scanner.nextInt();
            switch (comando) {
                case 1 -> {
                    opcao = "1 - Modo CARTELA (MANUAL) - SORTEIO (MANUAL)";
                    System.out.printf("\n***Você escolheu %s***\n", opcao);
                    controlador = false;
                }
                case 2 -> {
                    opcao = "2 - Modo CARTELA (MANUAL) - SORTEIO (RANDOM)";
                    System.out.printf("\n***Você escolheu %s***\n", opcao);
                    controlador = false;
                }
                case 3 -> {
                    opcao = "3 - Modo CARTELA (RANDOM) - SORTEIO (MANUAL)";
                    System.out.printf("\n***Você escolheu %s***\n", opcao);
                    controlador = false;
                }
                case 4 -> {
                    opcao = "4 - Modo CARTELA (RANDOM) - SORTEIO (RANDOM)";
                    System.out.printf("\n***Você escolheu %s***\n", opcao);
                    controlador = false;
                }
                default -> {
                    opcao = "um Comando Inválido, TENTE NOVAMENTE";
                    System.out.printf("\n***Você escolheu %s***\n", opcao);
                    System.out.println("\nEscolha o modo de jogo:");
                }
            }
        }
        System.out.println("\n###################################################################################################\n");

        return comando;
    }

    private static String[] getJogadores(Scanner scanner) {
        System.out.println("  Informe o nickname de todos os players separados por hífen (-) e sem espaço ( )...");
        String entradaPlayers = scanner.next();
        String[] players = entradaPlayers.split("-");

        Arrays.sort(players);

        System.out.printf("\n***Os jogadores são: %s***\n", Arrays.toString(players));
        System.out.println("\n###################################################################################################\n");

        return players;
    }

    private static int getQuantidadeBolas(Scanner scanner) {
        System.out.println("Antes de começarmos,\n  Informe a quantidade de bolas que o bingo possui...");
        int quantidadeBolas = scanner.nextInt();
        System.out.printf("\n***O jogo iniciará com %d bolas***\n", quantidadeBolas);
        System.out.println("\n###################################################################################################\n");

        return quantidadeBolas;
    }
}