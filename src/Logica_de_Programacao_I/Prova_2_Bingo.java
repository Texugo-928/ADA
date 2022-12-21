package Logica_de_Programacao_I;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Prova_2_Bingo {
    private static final int NICKNAME = 0;
    private static final int CARTELA_INICIO = 1;
    private static final int NUMENROS_ACERTADOS_INICIO = 7;
    private static final int SCORE_PLAYER = 13;
    private static int opcao;
    private static final String CONTINUAR = "C";
    private static final String PARAR = "X";
    private static int bingo = 0;
    private static int round = 1;
    private static int freioDeMao = 0;
    private static int bolaSorteada;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    // TODO implementar um sorteio onde cada round saem 5 bolas

    public static void main(String[] args) {
        int quantidadeBolas = getQuantidadeBolas();
        String[] jogadores = getJogadores();
        opcao = getModos();

        String[][] tabela = new String[jogadores.length][];
        if (opcao == 1 || opcao == 2) {
            tabela = getCartelaTabelaManual(quantidadeBolas, jogadores);
        }
        else if (opcao == 3 || opcao == 4) {
            tabela = getCartelaTabelaRandom(quantidadeBolas, jogadores);
        }
        String[][] tabelaAux = organizarTabela(jogadores, tabela);
        listarCartelas(tabelaAux);
        sortear(quantidadeBolas, tabelaAux);
    }

    private static void sortear(int quantidadeBolas, String[][] tabelaAux) {
        if (opcao == 1 || opcao == 3) {
            System.out.println("Sorteio (MANUAL):\n");
        }
        else if (opcao == 2 || opcao == 4) {
            System.out.println("Sorteio (RANDOM):\n");
        }

        boolean verificador = true;
        boolean encerramento = condicoesEncerramento(quantidadeBolas);
        String pergunta;
        int[] bolasEscolhidas = new int[quantidadeBolas];

        while (encerramento) {
            mensagemRoundValido();
            pergunta = scanner.next();
            if (pergunta.equalsIgnoreCase(CONTINUAR)) {
                if (opcao == 1 || opcao == 3) {
                    bolaSorteada = sortearBolaManual(quantidadeBolas, bolasEscolhidas);
                }
                else if (opcao == 2 || opcao == 4) {
                    bolaSorteada = sortearBolaRandom(quantidadeBolas, bolasEscolhidas);
                }
                roundDinamica(bolasEscolhidas, tabelaAux);
                listarRanking(tabelaAux);
                System.out.println("\n###################################################################################################\n");
                bingo = validarBingo(tabelaAux);
                round++;
                encerramento = condicoesEncerramento(quantidadeBolas);
            }
            else if (pergunta.equalsIgnoreCase(PARAR)) {
                freioDeMao = mensagemJogoEnterrompido();
                encerramento = condicoesEncerramento(quantidadeBolas);
            }
            else {
                while (verificador) {
                    mensagemRoundInvalido();
                    pergunta = scanner.next();
                    if (pergunta.equalsIgnoreCase(CONTINUAR)) {
                        if (opcao == 1 || opcao == 3) {
                            bolaSorteada = sortearBolaManual(quantidadeBolas, bolasEscolhidas);
                        }
                        else if (opcao == 2 || opcao == 4) {
                            bolaSorteada = sortearBolaRandom(quantidadeBolas, bolasEscolhidas);
                        }
                        roundDinamica(bolasEscolhidas, tabelaAux);
                        listarRanking(tabelaAux);
                        System.out.println("\n###################################################################################################\n");
                        bingo = validarBingo(tabelaAux);
                        round++;
                        encerramento = condicoesEncerramento(quantidadeBolas);
                        verificador = false;
                    }
                    else if (pergunta.equalsIgnoreCase(PARAR)) {
                        freioDeMao = mensagemJogoEnterrompido();
                        encerramento = condicoesEncerramento(quantidadeBolas);
                        verificador = false;
                    }
                }
            }
        }
        rankingGeral(bolasEscolhidas, tabelaAux);
    }

    private static void rankingGeral(int[] bolasEscolhidas, String[][] tabelaAux) {
        System.out.println("##### RANKING GERAL #####");
        System.out.println("\n###################################################################################################\n");
        Arrays.sort(bolasEscolhidas);
        System.out.printf("TOTAL DE ROUNDS: %d\n\n", (round - 1));

        System.out.println("@@@  VENCEDORES  @@@");
        for (String[] linha : tabelaAux) {
            if (Integer.parseInt(linha[SCORE_PLAYER]) == 5) {
                int[] cartela = new int[5];
                for (int k = 0; k < 5; k++) {
                    cartela[k] = Integer.parseInt(linha[(k + CARTELA_INICIO)]);
                }
                Arrays.sort(cartela);
                System.out.printf("\n%s com a cartela: \n", linha[NICKNAME]);
                System.out.println(Arrays.toString(cartela));
            }
        }
        System.out.println("\n@@@   ========   @@@\n");

        for (int i = 5; i >= 0; i--) {
            for (String[] linha : tabelaAux) {
                if (Integer.parseInt(linha[SCORE_PLAYER]) == i) {
                    String[] numerosAcertados = new String[5];
                    System.arraycopy(linha, NUMENROS_ACERTADOS_INICIO, numerosAcertados, 0, 5);
                    System.out.printf("Pontuação do %s: %s \n", linha[NICKNAME], linha[SCORE_PLAYER]);
                    System.out.printf("%s\n\n", Arrays.toString(numerosAcertados));
                }
            }
        }
        System.out.printf("Foram sorteadas um total de %d bolas.\n    Lista dos números sorteados (crescente):\n\n", (round - 1));
        System.out.println(Arrays.toString(bolasEscolhidas));
        System.out.println("\n###################################################################################################");
    }

    private static boolean condicoesEncerramento(int quantidadeBolas) {
        return (bingo == 0) && (freioDeMao == 0) && (round <= quantidadeBolas);
    }

    private static void listarRanking(String[][] tabelaAux) {
        System.out.println("###################################################################################################\n");
        System.out.println("##### TOP 3 #####");
        System.out.println("\n###################################################################################################\n");
        int contador = 0;
        for (int i = 5; i >= 0; i--) {
            for (String[] linha : tabelaAux) {
                if ((Integer.parseInt(linha[SCORE_PLAYER]) == i) && (contador < 3)) {
                    System.out.printf("Pontuação do %s: %d \n", linha[NICKNAME], Integer.parseInt(linha[SCORE_PLAYER]));
                    contador++;
                }
            }
        }
    }

    private static void roundDinamica(int[] bolasEscolhidas, String[][] tabelaAux) {
        System.out.printf("\n$$$ A bola sorteada foi %d $$$\n\n", bolaSorteada);
        bolasEscolhidas[(round - 1)] = bolaSorteada;

        for (int j = 0; j < tabelaAux.length; j++) {
            int[] cartela = new int[5];
            int[] numerosAcertados = new int[5];
            int scorePlayer = 0;

            for (int k = 0; k < 5; k++) {
                cartela[k] = Integer.parseInt(tabelaAux[j][(k + CARTELA_INICIO)]);
                numerosAcertados[k] = Integer.parseInt(tabelaAux[j][(k + NUMENROS_ACERTADOS_INICIO)]);
                scorePlayer = Integer.parseInt(tabelaAux[j][SCORE_PLAYER]);
            }

            if (validarPertencimentoArrayInteiro(bolaSorteada, cartela)) {
                numerosAcertados[scorePlayer] = bolaSorteada;
                tabelaAux[j][(scorePlayer + NUMENROS_ACERTADOS_INICIO)] = String.valueOf(numerosAcertados[scorePlayer]);
                scorePlayer += 1;
            }

            tabelaAux[j][SCORE_PLAYER] = String.valueOf(scorePlayer);
        }
    }

    private static int sortearBolaManual(int quantidadeBolas, int[] bolasEscolhidas) {

        // TODO Controlar o erro ao digitar algo diferente de um número.
        // TODO Controlar o bug caso digite 100 -> 15 -> 100

        System.out.println("Informe o valor da bola escolhida que respeite o intervalo de 1 à " + quantidadeBolas);
        int a = scanner.nextInt();
        boolean validacaoRound = validarSorteio(a, quantidadeBolas);
        boolean validacaoPertencimento = validarPertencimentoArrayInteiro(a, bolasEscolhidas);

        while (validacaoRound) {
            System.out.println("O valor desrespeita o intervalo de 1 à " + quantidadeBolas);
            System.out.println("Informe o valor da bola escolhida que respeite o intervalo de 1 à " + quantidadeBolas + " novamente");
            a = scanner.nextInt();
            validacaoRound = validarSorteio(a, quantidadeBolas);
        }
        while (validacaoPertencimento) {
            System.out.println(Arrays.toString(bolasEscolhidas));
            System.out.println("Esse valor já foi informado previamenete, por favor informe outro número");
            a = scanner.nextInt();
            validacaoPertencimento = validarPertencimentoArrayInteiro(a, bolasEscolhidas);
        }
        return a;
    }

    private static boolean validarSorteio(int bolaSorteada, int quantidadeBolas) {
        boolean validacaoNumeros = (bolaSorteada <= 0);
        boolean validacaoLimite = (bolaSorteada > quantidadeBolas);

        return (validacaoNumeros || validacaoLimite);
    }

    private static int sortearBolaRandom(int quantidadeBolas, int[] bolasEscolhidas) {
        int a = random.nextInt(1, (quantidadeBolas+1));
        boolean validacaoPertencimento = validarPertencimentoArrayInteiro(a, bolasEscolhidas);

        while (validacaoPertencimento) {
            a = random.nextInt(1, (quantidadeBolas+1));
            validacaoPertencimento = validarPertencimentoArrayInteiro(a, bolasEscolhidas);
        }
        return a;
    }

    private static boolean validarPertencimentoArrayInteiro(int elemento, int[] array) {
        boolean verificador = false;

        for (int j : array) {
            if (elemento == j) {
                verificador = true;
                break;
            }
        }
        return verificador;
    }

    private static int mensagemJogoEnterrompido() {
        System.out.println("Você abortou a brincadeira");
        return 47;
    }

    private static void mensagemRoundInvalido() {
        System.out.println("\nOpção Inválida, digite a tecla:");
        System.out.println("    C - Para continuar o Round " + round);
        System.out.println("    X - Para parar o jogo");
    }

    private static void mensagemRoundValido() {
        System.out.println("Round " + round);
        System.out.println("\nDigite a tecla:");
        System.out.println("    C - Para continuar o Round " + round);
        System.out.println("    X - Para parar o jogo");
    }

    private static int validarBingo(String[][] tabelaAux) {
        for (String[] linha : tabelaAux) {
            if (Integer.parseInt(linha[SCORE_PLAYER]) == 5) {
                bingo += 1;
            }
        }
        return bingo;
    }

    private static void listarCartelas(String[][] tabelaAux) {
        System.out.println("\n###################################################################################################\n");
        System.out.println("Lista de cartelas geradas:\n");
        for (int i = 0; i < tabelaAux.length; i++) {
            String[] cartela = new String[6];
            System.arraycopy(tabelaAux[i], NICKNAME, cartela, 0, 6);
            System.out.printf("Player %d: %s\n", (i + 1), Arrays.toString(cartela));
        }
        System.out.println("\n###################################################################################################\n");
    }

    private static String[][] organizarTabela(String[] jogadores, String[][] tabela) {

        // TODO Corrigir o bug que aparece caso 2 nomes são exatamente iguais

        Arrays.sort(jogadores);
        String[][] tabelaAux = new String[tabela.length][tabela[0].length];

        for (int i = 0; i < jogadores.length; i++) {
            for (String[] linhas : tabela) {
                if (jogadores[i].equals(linhas[NICKNAME])) {
                    tabelaAux[i] = linhas;
                }
            }
        }
        return tabelaAux;
    }

    private static String[][] getCartelaTabelaManual(int quantidadeBolas, String[] jogadores) {

        // TODO Controlar o erro ao digitar algo diferente de um número.
        // TODO Controlar o erro quando passo menos que 5 números separados por vírgula.

        System.out.printf("Informe os cinco valores distintos respeitando o intervalo de 1 à %d de cada cartela separando-os por vírgula (,)\n", quantidadeBolas);
        System.out.println("Entendendo que cada as cartelas serão separadas por hífen (-).\n");
        System.out.println("    Exemplo: \nEntrada: 1,2,3,4,5-6,7,8,9,10 => \n    Catela 1 = [1, 2, 3, 4, 5]\n    Cartela 2 = [6, 7, 8, 9, 10]");
        String entradaCartelas = scanner.next();
        String[] cartelas = entradaCartelas.split("-");
        String[][] tabelaAux = new String[jogadores.length][5];
        String[][] tabela = new String[jogadores.length][];

        for (int i = 0; i < jogadores.length; i++) {
            if (i < cartelas.length) {
                String[] cartelaAux = cartelas[i].split(",");
                System.arraycopy(cartelaAux, 0, tabelaAux[i], 0, 5);
            }
            else {
                tabelaAux[i] = new String[]{"0", "0", "0", "0", "0"};
            }
        }

        for (int j = 0; j < jogadores.length; j++) {
            tabela[j] = new String[]{jogadores[j], tabelaAux[j][0], tabelaAux[j][1], tabelaAux[j][2],
                    tabelaAux[j][3], tabelaAux[j][4], "-", "0", "0", "0", "0", "0", "-", "0", "-"};
        }

        for (int k = 0; k < jogadores.length; k++) {
            int[] cartela = new int[5];
            for (int l = 0; l < 5; l++) {
                cartela[l] = Integer.parseInt(tabela[k][(l + CARTELA_INICIO)]);
            }
            boolean validacaoCartela = validarCartela(cartela[0], cartela[1], cartela[2], cartela[3], cartela[4], quantidadeBolas);

            while (validacaoCartela) {
                System.out.println("\n###################################################################################################\n");
                System.out.printf("A cartela do jogador %s é [%s,%s,%s,%s,%s]\n\n",
                        tabela[k][0], tabela[k][1], tabela[k][2], tabela[k][3], tabela[k][4], tabela[k][5]);
                System.out.println("Algum valor informado desrespeita as condições:");
                System.out.println("(1) Cinco valores distintos; ou");
                System.out.printf("(2) Valores respeitando o intervalo de 1 à %d \n", quantidadeBolas);
                System.out.println("\nInforme, novamente, os cinco valores dessa cartela em específico separando-os por vírgula (,)");
                entradaCartelas = scanner.next();
                cartelas = entradaCartelas.split(",");
                for (int m = 0; m < 5; m++) {
                    cartela[m] = Integer.parseInt(cartelas[m]);
                    tabela[k][(m + CARTELA_INICIO)] = cartelas[m];
                }
                validacaoCartela = validarCartela(cartela[0], cartela[1], cartela[2], cartela[3], cartela[4], quantidadeBolas);
            }
        }
        return tabela;
    }

     /*
    private static String[][] getTabela(int quantidadeBolas, String[] jogadores) {
        String[][] tabela = new String[jogadores.length][];

        for (int i = 0; i < jogadores.length; i++) {
            System.out.printf("Preenchendo a cartela do jogador %s (MANUAL):\n", jogadores[i]);
            int[] cartela = getCartela(scanner, quantidadeBolas);

            tabela[i] = new String[] {jogadores[i], String.valueOf(cartela[0]),
                    String.valueOf(cartela[1]), String.valueOf(cartela[2]),
                    String.valueOf(cartela[3]), String.valueOf(cartela[4]),
                    "-", "0", "0", "0", "0", "0", "-", "0", "-"};
            System.out.println("\n###################################################################################################\n");
        }

        return tabela;
    }

    private static int[] getCartela(Scanner scanner, int quantidadeBolas) {

        // TODO Controlar o erro ao digitar algo diferente de um número.

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
     */

    private static String[][] getCartelaTabelaRandom(int quantidadeBolas, String[] jogadores) {
        String[][] tabela = new String[jogadores.length][];

        for (int i = 0; i < jogadores.length; i++) {
            int[] cartela = new int[5];
            for (int j = 0; j < 5; j++) {
                cartela[j] = random.nextInt(1, (quantidadeBolas+1));
            }
            boolean validacaoCartela = validarCartela(cartela[0], cartela[1], cartela[2], cartela[3], cartela[4], quantidadeBolas);

            while (validacaoCartela) {
                for (int j = 0; j < 5; j++) {
                    cartela[j] = random.nextInt(1, (quantidadeBolas+1));
                }
                validacaoCartela = validarCartela(cartela[0], cartela[1], cartela[2], cartela[3], cartela[4], quantidadeBolas);
            }

            tabela[i] = new String[] {jogadores[i], String.valueOf(cartela[0]),
                    String.valueOf(cartela[1]), String.valueOf(cartela[2]),
                    String.valueOf(cartela[3]), String.valueOf(cartela[4]),
                    "-", "0", "0", "0", "0", "0", "-", "0", "-"};
        }
        return tabela;
    }

    private static boolean validarCartela(int a, int b, int c, int d, int e, int quantidadeBolas) {
        boolean validacaoNumeros = ((a <= 0) || (b <= 0) || (c <= 0) || (d <= 0) || (e <= 0));
        boolean validacaoLimite = ((a > quantidadeBolas) || (b > quantidadeBolas) ||
                (c > quantidadeBolas) || (d > quantidadeBolas) || (e > quantidadeBolas));
        boolean validacaoEmA = ((a == b) || (a == c) || (a == d) || (a == e));
        boolean validacaoEmB = ((b == c) || (b == d) || (b == e));
        boolean validacaoEmC = ((c == d) || (c == e));
        boolean validacaoEmD = (d == e);

        return (validacaoNumeros || validacaoLimite || validacaoEmA || validacaoEmB || validacaoEmC || validacaoEmD);
    }

    private static int getModos() {

        // TODO Controlar o erro ao digitar algo diferente de um número.

        boasVindas();

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

    private static void boasVindas() {
        System.out.println("BEM VINDO AO JOGO (...)");
        System.out.println("\n###################################################################################################\n");
        System.out.println("Modos de Jogo:\n");
        System.out.println("1 - Modo CARTELA (MANUAL) - SORTEIO (MANUAL)\n");
        System.out.println("2 - Modo CARTELA (MANUAL) - SORTEIO (RANDOM)\n");
        System.out.println("3 - Modo CARTELA (RANDOM) - SORTEIO (MANUAL)\n");
        System.out.println("4 - Modo CARTELA (RANDOM) - SORTEIO (RANDOM)");
        System.out.println("\n###################################################################################################\n");
        System.out.println("Escolha o modo de jogo:");
    }

    private static String[] getJogadores() {
        System.out.println("  Informe o nickname de todos os players separados por hífen (-) e sem espaço ( )...");
        String entradaJogadores = scanner.next();
        String[] jogadores = entradaJogadores.split("-");
        System.out.printf("\n***Os jogadores são: %s***\n", Arrays.toString(jogadores));
        System.out.println("\n###################################################################################################\n");

        return jogadores;
    }

    private static int getQuantidadeBolas() {

        // TODO Controlar o erro ao digitar algo diferente de um número.

        System.out.println("Antes de começarmos,\n  Informe a quantidade de bolas que o bingo possui...");
        int quantidadeBolas = scanner.nextInt();
        System.out.printf("\n***O jogo iniciará com %d bolas***\n", quantidadeBolas);
        System.out.println("\n###################################################################################################\n");

        return quantidadeBolas;
    }

}