package Programacao_Orientada_a_Objetos_I;

import java.util.Random;

public class Prova_1 {

    private static final String[] nomes = new String[]{"V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10"};
    private static final String[] sobrenomes = new String[]{"S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10"};
    private static final Random random = new Random();

    public static void main(String[] args) {
        final int QUANTIDADE_VENDEDORES = 10;
        final int QUANTIDADE_COMPRADORES = 10;

        Vendedor[] vendedoresMercado1 = new Vendedor[QUANTIDADE_VENDEDORES];
        Vendedor[] vendedoresMercado2 = new Vendedor[QUANTIDADE_VENDEDORES];
        Vendedor[] vendedoresMercado3 = new Vendedor[QUANTIDADE_VENDEDORES];
        Vendedor[][] vendedores = new Vendedor[][] {vendedoresMercado1, vendedoresMercado2, vendedoresMercado3};

        criarVendedores(vendedores);

        Mercado mercado1 = new Mercado(vendedoresMercado1, "Mercado 1", "Rua 1", 300);
        Mercado mercado2 = new Mercado(vendedoresMercado2, "Mercado 2", "Rua 2", 500);
        Mercado mercado3 = new Mercado(vendedoresMercado3, "Mercado 3", "Rua 3", 700);
        Mercado[] mercados = new Mercado[] {mercado1, mercado2, mercado3};

        atrelarMercados(mercados);
        dinamicaMercado(QUANTIDADE_COMPRADORES, mercados);

        Regulador regulador = new Regulador();

        regulador.aplicar(mercados);



        /*
        Representar vendedores em um pool de vários mercados que são bonificados com aumento de 10%
        em suas vendas ao alcançar a meta estabelecida por cada mercado atuante, segundo um órgão regulador.
         */

        //Exiba como foram as vendas de cada mercado e seus vendedores com ou sem bonificação

        //Exiba um sumário sobre como foi cada mercado

    }

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
            }
        }
    }

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

    private static void criarVendedores (Vendedor[][] vendedores){
        for (int i = 0; i < vendedores.length; i++) {
            Vendedor[] vendedoresAux = vendedores[i];

            for (int j = 0; j < vendedoresAux.length; j++) {
                int indiceNome = random.nextInt(nomes.length);
                String nome = nomes[indiceNome];

                int indiceSobrenome = random.nextInt(sobrenomes.length);
                String sobrenome = sobrenomes[indiceSobrenome];

                vendedores[i][j] = new Vendedor(nome, sobrenome);
            }
        }
    }
}

class Mercado {

    private final Vendedor[] vendedores;
    private final String nome;
    private final String local;
    public final int meta;
    private int totalVendas;



    public Mercado(Vendedor[] vendedores, String nome, String local, int meta) {
        this.vendedores = vendedores;
        this.nome = nome;
        this.local = local;
        this.meta = meta;
    }

    public void vender(int valor) {
        this.totalVendas += valor;
    }

    public Vendedor[] getVendedores() {
        return vendedores;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public int getMeta() {
        return meta;
    }

    public int getTotalVendas() {
        return totalVendas;
    }

}

class Vendedor {
    private final String nome;
    private final String sobrenome;
    private int valorTotalVendas;
    private double valorComBonificacao;
    private Mercado mercado;


    public Vendedor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        }

    public void vender(int valor) {
        this.valorTotalVendas += valor;
    }

    public void bonificar() {
        this.valorComBonificacao = valorTotalVendas * 1.1;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getValorTotalVendas() {
        return valorTotalVendas;
    }

    public double getValorComBonificacao() {
        return valorComBonificacao;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }  //
}

class Regulador {
    public void aplicar(Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();

            for (int j = 0; j < vendedores.length; j++) {
                Vendedor vendedor = vendedores[j];
                if (vendedor.getValorTotalVendas() > mercado.getMeta()) {
                    vendedor.bonificar();
                }
            }
        }

    }
}

class Comprador {
    private static final Random random = new Random();
    public void comprar(Vendedor vendedor) {
        int valor = random.nextInt(100, 1001);
        vendedor.vender(valor);
        vendedor.getMercado().vender(valor);
    }
}
