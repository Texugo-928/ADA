package Programacao_Orientada_a_Objetos_I;

import Programacao_Orientada_a_Objetos_I.Objetos.Comprador;
import Programacao_Orientada_a_Objetos_I.Objetos.Mercado;
import Programacao_Orientada_a_Objetos_I.Objetos.Regulador;
import Programacao_Orientada_a_Objetos_I.Objetos.Vendedor;

import java.util.Random;

public class Prova_1 {
    private static final String[] nomesVendedores = new String[]{"V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10"};
    private static final String[] nomesCompradores = new String[]{"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10"};
    private static final String[] sobrenomes = new String[]{"S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10"};
    public static final Random random = new Random();



    public static void main(String[] args) {
        final int QUANTIDADE_VENDEDORES = 10;
        final int QUANTIDADE_COMPRADORES = 10;

        Vendedor[] vendedoresMercado1 = new Vendedor[QUANTIDADE_VENDEDORES];
        Vendedor[] vendedoresMercado2 = new Vendedor[QUANTIDADE_VENDEDORES];
        Vendedor[] vendedoresMercado3 = new Vendedor[QUANTIDADE_VENDEDORES];
        Vendedor[][] vendedores = new Vendedor[][]{vendedoresMercado1, vendedoresMercado2, vendedoresMercado3};

        preencherMatrizVendedores(vendedores);

        Mercado mercado1 = new Mercado(vendedoresMercado1, "Mercado 1", "Rua 1", 300);
        Mercado mercado2 = new Mercado(vendedoresMercado2, "Mercado 2", "Rua 2", 500);
        Mercado mercado3 = new Mercado(vendedoresMercado3, "Mercado 3", "Rua 3", 700);
        Mercado[] mercados = new Mercado[]{mercado1, mercado2, mercado3};

        relacionarMercadoVendedor(mercados);

        Comprador[] compradores = new Comprador[QUANTIDADE_COMPRADORES];
        // Comprador[][] compradores = new Comprador[][] {compradoresMercado1, compradoresMercado2, compradoresMercado3};

        preencherArrayCompradores(compradores);

        String[][] compradorMercado = dinamicaMercado(mercados, compradores);

        Regulador regulador = new Regulador();
        regulador.aplicar(QUANTIDADE_COMPRADORES, mercados);

        estatisticaMercados(mercados);

        top3Vendedores(mercados);

        top3Compradores(compradores, compradorMercado);

        mercadoMaisLucrativo(mercados);

    }

    private static void mercadoMaisLucrativo(Mercado[] mercados) {
        System.out.println("\n############################################################\n");
        System.out.println("###############    Mercado Mais Lucrativo    ###############");
        System.out.println("\n############################################################\n");
        double[] totalVendasMercado = criarArrayMercadoVendas(mercados);

        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            boolean melhor = comparadorElementosArrayBoolean(totalVendasMercado[i], totalVendasMercado);
            if (melhor) {
                System.out.printf("O mercado %s é o mais lucrativo, acumulando um total de R$%.2f \n",
                        mercado.getNome(), mercado.getTotalVendas());
            }
        }
        System.out.println("\n############################################################\n");
    }

    private static void top3Compradores(Comprador[] compradores, String[][] compradorMercado) {
        System.out.println("\n#######################################################\n");
        System.out.println("###############    Top 3 Compradores    ###############");
        System.out.println("\n#######################################################\n");
        double[] totalComprasCompradores = criarArrayCompradoresCompras(compradores);
        int length1 = totalComprasCompradores.length;
        double[][] valorCompradorMercado = criarTabelaCompradorMercado(compradorMercado);
        int length2 = valorCompradorMercado[0].length;
        int count = 0;

        for (int j = length1; j >= 0; j--) {
            for (int i = 0; i < length1; i++) {
                int somatorio = comparadorElementosArrayInteiro(totalComprasCompradores[i], totalComprasCompradores);
                if (somatorio == j && count < 3) {
                    String texto = "O comprador " + compradores[i].getNome() + " " + compradores[i].getSobrenome();
                    String melhorMercado = "";
                    double valorMelhorMercado = 0;

                    for (int k = 0; k < length2; k++) {
                        boolean melhor = comparadorElementosArrayBoolean(valorCompradorMercado[i][k], valorCompradorMercado[i]);
                        if (melhor) {
                            melhorMercado = "O mercado onde ele mais gastou foi o " + compradorMercado[0][(k + 1)] + " num total de";
                            valorMelhorMercado = valorCompradorMercado[i][k];
                        }
                    }
                    System.out.printf("%d - %s gastou um total de R$%.2f em compras. %s R$%.2f\n",
                            (count + 1), texto, totalComprasCompradores[i],
                            melhorMercado, valorMelhorMercado);
                    count++;
                }
            }
        }
        System.out.println("\n#######################################################\n");
    }

    private static void top3Vendedores(Mercado[] mercados) {
        System.out.println("\n######################################################\n");
        System.out.println("###############    Top 3 Vendedores    ###############");
        System.out.println("\n######################################################\n");
        Vendedor[] vendedores = criarArrayVendedoresGlobal(mercados);
        double[] totalVendasVendedores = criarArrayVendedoresVendas(mercados);
        int length = totalVendasVendedores.length;
        int count = 0;

        for (int j = length; j >= 0; j--) {
            for (int i = 0; i < length; i++) {
                int somatorio = comparadorElementosArrayInteiro(totalVendasVendedores[i], totalVendasVendedores);
                if (somatorio == j && count < 3) {
                    String texto = "O vendedor " + vendedores[i].getNome() + " " +
                            vendedores[i].getSobrenome() + " do mercado " +
                            vendedores[i].getMercado().getNome();

                    System.out.printf("%d - %s vendeu um total de R$%.2f \n",
                            (count + 1), texto, totalVendasVendedores[i]);
                    count++;
                }
            }
        }
        System.out.println("\n######################################################\n");
    }

    private static boolean comparadorElementosArrayBoolean(double elemento, double[] array) {
        boolean comparador = false;
        int empate = contadorEmpatesArray(elemento,array);
        int maior = contadorMaiorArray(elemento,array);

        if ((maior + empate == array.length)) {
            comparador = true;
        }
        return comparador;
    }

    private static int comparadorElementosArrayInteiro(double elemento, double[] array) {
        int empate = contadorEmpatesArray(elemento,array);
        int maior = contadorMaiorArray(elemento,array);
        return (empate + maior);
    }

    private static int contadorMaiorArray(double elemento, double[] array) {
        int maior = 0;

        for (double v : array) {
            if (elemento > v) {
                maior += 1;
            }
        }
        return maior;
    }

    private static int contadorEmpatesArray(double elemento, double[] array) {
        int empate = 0;

        for (double v : array) {
            if (elemento == v) {
                empate += 1;
            }
        }
        return empate;
    }

    private static double[] criarArrayMercadoVendas(Mercado[] mercados) {
        int length = mercados.length;
        double[] array = new double[length];

        for (int i = 0; i < length; i++) {
            Mercado mercado = mercados[i];
            array[i] = mercado.getTotalVendas();
        }
        return array;
    }

    private static double[][] criarTabelaCompradorMercado(String[][] compradorMercado) {
        int linhasCompradores = (compradorMercado.length - 1);
        int colunasNumericas = (compradorMercado[0].length - 1);
        double[][] tabela = new double[linhasCompradores][(colunasNumericas + 1)];

        for (int i = 0; i < linhasCompradores; i++) {
            for (int j = 0; j < colunasNumericas; j++) {
                tabela[i][j] = Double.parseDouble(compradorMercado[(i + 1)][(j + 1)]);
            }
        }
        return tabela;
    }

    private static double[] criarArrayCompradoresCompras(Comprador[] compradores) {
        int length = compradores.length;
        double[] array = new double[length];

        for (int i = 0; i < length; i++) {
            Comprador comprador = compradores[i];
            array[i] = comprador.getValorCompras();
        }
        return array;
    }

    private static double[] criarArrayVendedoresVendas(Mercado[] mercados) {
        int length = 0;
        int count = 0;
        for (Mercado mercado : mercados) {
            Vendedor[] vendedores = mercado.getVendedores();
            length += vendedores.length;
        }

        double[] array = new double[length];
        for (Mercado mercado : mercados) {
            Vendedor[] vendedores = mercado.getVendedores();
            for (Vendedor vendedor : vendedores) {
                array[count] = vendedor.getValorTotalVendas();
                count += 1;
            }
        }
        return array;
    }

    private static Vendedor[] criarArrayVendedoresGlobal(Mercado[] mercados) {
        int length = 0;
        int count = 0;
        for (Mercado mercado : mercados) {
            Vendedor[] vendedores = mercado.getVendedores();
            length += vendedores.length;
        }

        Vendedor[] vendedores = new Vendedor[length];
        for (Mercado mercado : mercados) {
            Vendedor[] vendedoresAux = mercado.getVendedores();
            for (Vendedor vendedor : vendedoresAux) {
                vendedores[count] = vendedor;
                count += 1;
            }
        }
        return vendedores;
    }

    private static void estatisticaMercados(Mercado[] mercados) {
        System.out.println("\n###############################################################\n");
        System.out.println("###############    Estatísticas dos Mercados    ###############");
        System.out.println("\n###############################################################\n");
        for (Mercado mercado : mercados) {
            mercado.anunciar();
            System.out.println("\n###########################################################\n");
        }
    }

    private static String[][] dinamicaMercado(Mercado[] mercados, Comprador[] compradores) {
        int linhas = compradores.length + 1;
        int colunas = mercados.length + 1;
        String[][] relacaoCompradorMercado = new String[linhas][colunas];

        preencherRelacaoCompradorMercado(mercados, relacaoCompradorMercado);

        for (int i = 0; i < (colunas - 1); i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();
            for (Vendedor vendedor : vendedores) {
                for (int k = 0; k < (linhas - 1); k++) {
                    Comprador comprador = compradores[k];
                    String nomeCompleto = comprador.getNome() + " " + comprador.getSobrenome();
                    relacaoCompradorMercado[(k + 1)][0] = nomeCompleto;
                    double valor = comprador.comprar(vendedor);
                    double atualizador = Double.parseDouble(relacaoCompradorMercado[(k + 1)][i + 1]);
                    atualizador += valor;
                    relacaoCompradorMercado[(k + 1)][i + 1] = String.valueOf(atualizador);
                }
                mercado.apurarVendas(vendedor);
            }
        }
        return relacaoCompradorMercado;
    }

    private static void preencherRelacaoCompradorMercado(Mercado[] mercados, String[][] relacaoCompradorMercado) {
        int linhas = relacaoCompradorMercado.length;
        int colunas = relacaoCompradorMercado[0].length;

        relacaoCompradorMercado[0][0] = "Comprador";
        for (int l = 1; l < colunas; l++) {
            Mercado mercado = mercados[(l - 1)];
            relacaoCompradorMercado[0][l] = mercado.getNome();
        }
        for (int m = 1; m < linhas; m++) {
            for (int n = 1; n < colunas; n++) {
                relacaoCompradorMercado[m][n] = "0";
            }
        }
    }

    /*
    private static void dinamicaMercado(Mercado[] mercados, Comprador[][] compradores) {
        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();

            for (int j = 0; j < vendedores.length; j++) {
                Vendedor vendedor = vendedores[j];
                Comprador[] compradoresAux = compradores[i];

                for (int k = 0; k < compradoresAux.length; k++) {
                    Comprador comprador = compradoresAux[k];
                    comprador.comprar(vendedor);
                }

                mercado.apurarVendas(vendedor);
            }
        }
    }
     */

    /*
    private static void dinamicaMercado(int QUANTIDADE_COMPRADORES, Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();

            for (int j = 0; j < vendedores.length; j++) {
                Vendedor vendedor = vendedores[j];
                Comprador[] compradores = new Comprador[random.nextInt(1, QUANTIDADE_COMPRADORES)];

                for (int k = 0; k < compradores.length; k++) {
                    Comprador comprador = compradores[k];
                    comprador.comprar(vendedor);
                }

                mercado.apurarVendas(vendedor);
            }
        }
    }
     */

    private static void relacionarMercadoVendedor(Mercado[] mercados) {
        for (Mercado mercado : mercados) {
            Vendedor[] vendedores = mercado.getVendedores();
            for (Vendedor vendedor : vendedores) {
                vendedor.setMercado(mercado);
            }
        }
    }

    private static void preencherMatrizVendedores (Vendedor[][] vendedores){
        for (Vendedor[] vendedoresAux : vendedores) {
            preencherArrayVendedores(vendedoresAux);
        }
    }

    private static void preencherArrayVendedores (Vendedor[] vendedores){
        for (int i = 0; i < vendedores.length; i++) {
            int indiceNome = random.nextInt(nomesVendedores.length);
            String nome = nomesVendedores[indiceNome];
            int indiceSobrenome = random.nextInt(sobrenomes.length);
            String sobrenome = sobrenomes[indiceSobrenome];
            vendedores[i] = new Vendedor(nome, sobrenome);
        }
    }

    private static void preencherArrayCompradores (Comprador[] compradores){
        for (int i = 0; i < compradores.length; i++) {
            int indiceNome = random.nextInt(nomesCompradores.length);
            String nome = nomesCompradores[indiceNome];
            int indiceSobrenome = random.nextInt(sobrenomes.length);
            String sobrenome = sobrenomes[indiceSobrenome];
            compradores[i] = new Comprador(nome, sobrenome);
        }
    }

    /*
    private static void criarCompradores (Comprador[][] compradores){
        for (int i = 0; i < compradores.length; i++) {
            Comprador[] compradoresAux = compradores[i];

            criarCompradores(compradoresAux);
        }
    }
     */

}