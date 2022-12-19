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

        criarVendedores(vendedores);

        Mercado mercado1 = new Mercado(vendedoresMercado1, "Mercado 1", "Rua 1", 300);
        Mercado mercado2 = new Mercado(vendedoresMercado2, "Mercado 2", "Rua 2", 500);
        Mercado mercado3 = new Mercado(vendedoresMercado3, "Mercado 3", "Rua 3", 700);
        Mercado[] mercados = new Mercado[]{mercado1, mercado2, mercado3};

        atrelarMercados(mercados);

        Comprador[] compradores = new Comprador[QUANTIDADE_COMPRADORES];
        // Comprador[][] compradores = new Comprador[][] {compradoresMercado1, compradoresMercado2, compradoresMercado3};

        criarCompradores(compradores);

        dinamicaMercado(mercados, compradores);

        Regulador regulador = new Regulador();
        regulador.aplicar(QUANTIDADE_COMPRADORES, mercados);

        estatisticasMercados(mercados);

        top3Vendedores(mercados);

        top3Compradores(compradores);

        mercadoMaisLucrativo(mercados);


        //Incluir vendedores dos outros mercados para vender com compradores

        //Imprimir top 3 maiores compradores e dizer de qual mercado mais comprou

    }

    private static void mercadoMaisLucrativo(Mercado[] mercados) {
        System.out.println("\n##################################################\n");
        System.out.println("##########    Mercado Mais Lucrativo    ##########");
        System.out.println("\n##################################################\n");

        double[] totalVendasMercado = criarArrayMercadoVendas(mercados);

        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            boolean melhor = compararElementosArrayb(totalVendasMercado[i], totalVendasMercado);

            if (melhor) {
                System.out.printf("O mercado %s é o mais lucrativo, acumulando um total de R$%.2f \n", mercado.getNome(), mercado.getTotalVendas());
            }
        }
        System.out.println("\n##################################################\n");
    }

    private static void top3Compradores(Comprador[] compradores) {
        System.out.println("\n#############################################\n");
        System.out.println("##########    Top 3 Compradores    ##########");
        System.out.println("\n#############################################\n");

        double[] totalComprasCompradores = criarArrayCompradoresCompras(compradores);

        int count = 0;
        int length = totalComprasCompradores.length;

        for (int j = length; j >= 0; j--) {
            for (int i = 0; i < length; i++) {
                int somatorio = compararElementosArrayi(totalComprasCompradores[i], totalComprasCompradores);

                if (somatorio == j && count < 3) {
                    String texto = "O comprador " + compradores[i].getNome() + " " + compradores[i].getSobrenome();

                    System.out.printf("%d - %s gastou um total de R$%.2f em compras. \n", (count + 1), texto, totalComprasCompradores[i]);
                    count++;
                }
            }
        }
        System.out.println("\n#############################################\n");
    }

    private static void top3Vendedores(Mercado[] mercados) {
        System.out.println("\n############################################\n");
        System.out.println("##########    Top 3 Vendedores    ##########");
        System.out.println("\n############################################\n");

        Vendedor[] vendedores = criarArrayVendedores(mercados);
        double[] totalVendasVendedores = criarArrayVendedoresVendas(mercados);

        int count = 0;
        int length = totalVendasVendedores.length;

        for (int j = length; j >= 0; j--) {
            for (int i = 0; i < length; i++) {
                int somatorio = compararElementosArrayi(totalVendasVendedores[i], totalVendasVendedores);

                if (somatorio == j && count < 3) {
                    String texto = "O vendedor " + vendedores[i].getNome() + " " + vendedores[i].getSobrenome() + " do mercado " + vendedores[i].getMercado().getNome();

                    System.out.printf("%d - %s vendeu um total de R$%.2f \n", (count + 1), texto, totalVendasVendedores[i]);
                    count++;
                }
            }
        }
        System.out.println("\n############################################\n");
    }

    private static boolean compararElementosArrayb(double elemento, double[] array) {
        boolean comparador = false;
        int empate = verificarEmpatesArray(elemento,array);
        int maior = verificarMaiorArray(elemento,array);

        if ((maior + empate == array.length)) {
            comparador = true;
        }

        return comparador;
    }

    private static int compararElementosArrayi(double elemento, double[] array) {
        int empate = verificarEmpatesArray(elemento,array);
        int maior = verificarMaiorArray(elemento,array);

        return (empate + maior);
    }

    private static int verificarMaiorArray(double elemento, double[] array) {
        int maior = 0;

        for (int i = 0; i < array.length; i++) {
            if (elemento > array[i]) {
                maior += 1;
            }
        }

        return maior;
    }

    private static int verificarEmpatesArray(double elemento, double[] array) {
        int empate = 0;

        for (int i = 0; i < array.length; i++) {
            if (elemento == array[i]) {
                empate += 1;
            }
        }

        return empate;
    }

    private static double[] criarArrayMercadoVendas(Mercado[] mercados) {
        double[] array = new double[mercados.length];

        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            array[i] = mercado.getTotalVendas();
        }

        return array;
    }

    private static double[] criarArrayCompradoresCompras(Comprador[] compradores) {
        double[] array = new double[compradores.length];

        for (int i = 0; i < compradores.length; i++) {
            Comprador comprador = compradores[i];

            array[i] = comprador.getValorCompras();
        }

        return array;
    }

    private static double[] criarArrayVendedoresVendas(Mercado[] mercados) {
        int length = 0;
        int count = 0;

        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();

            length += vendedores.length;
        }

        double[] array = new double[length];

        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();

            for (int j = 0; j < vendedores.length; j++) {
                Vendedor vendedor = vendedores[j];

                array[count] = vendedor.getValorTotalVendas();
                count += 1;
            }
        }

        return array;
    }

    private static Vendedor[] criarArrayVendedores(Mercado[] mercados) {
        int length = 0;
        int count = 0;

        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();

            length += vendedores.length;
        }

        Vendedor[] vendedores = new Vendedor[length];

        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedoresAux = mercado.getVendedores();

            for (int j = 0; j < vendedoresAux.length; j++) {
                vendedores[count] = vendedoresAux[j];
                count += 1;
            }
        }

        return vendedores;
    }

    private static void estatisticasMercados(Mercado[] mercados) {
        System.out.println("\n#####################################################\n");
        System.out.println("##########    Estatísticas dos Mercados    ##########");
        System.out.println("\n#####################################################\n");
        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            mercado.anunciar();
            System.out.println("\n#################################################\n");
        }
    }

    private static void dinamicaMercado(Mercado[] mercados, Comprador[] compradores) {
        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();

            for (int j = 0; j < vendedores.length; j++) {
                Vendedor vendedor = vendedores[j];

                for (int k = 0; k < compradores.length; k++) {
                    Comprador comprador = compradores[k];
                    comprador.comprar(vendedor);
                }

                mercado.apurarVendas(vendedor);
            }
        }
    }

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

    private static void atrelarMercados(Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();

            for (int j = 0; j < vendedores.length; j++) {
                Vendedor vendedor = vendedores[j];

                vendedor.setMercado(mercado);
            }
        }
    }

    private static void criarVendedores (Vendedor[] vendedores){
        for (int i = 0; i < vendedores.length; i++) {
            int indiceNome = random.nextInt(nomesVendedores.length);
            String nome = nomesVendedores[indiceNome];

            int indiceSobrenome = random.nextInt(sobrenomes.length);
            String sobrenome = sobrenomes[indiceSobrenome];

            vendedores[i] = new Vendedor(nome, sobrenome);
        }
    }

    private static void criarVendedores (Vendedor[][] vendedores){
        for (int i = 0; i < vendedores.length; i++) {
            Vendedor[] vendedoresAux = vendedores[i];

            criarVendedores(vendedoresAux);
        }
    }

    private static void criarCompradores (Comprador[] compradores){
        for (int i = 0; i < compradores.length; i++) {
            int indiceNome = random.nextInt(nomesCompradores.length);
            String nome = nomesCompradores[indiceNome];

            int indiceSobrenome = random.nextInt(sobrenomes.length);
            String sobrenome = sobrenomes[indiceSobrenome];

            compradores[i] = new Comprador(nome, sobrenome);
        }
    }

    private static void criarCompradores (Comprador[][] compradores){
        for (int i = 0; i < compradores.length; i++) {
            Comprador[] compradoresAux = compradores[i];

            criarCompradores(compradoresAux);
        }
    }
}