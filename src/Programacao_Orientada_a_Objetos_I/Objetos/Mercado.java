package Programacao_Orientada_a_Objetos_I.Objetos;

public class Mercado {
    private final Vendedor[] vendedores;
    private final String nome;
    private final String local;
    private final double meta;
    private double totalVendas;



    public Mercado(Vendedor[] vendedores, String nome, String local, double meta) {
        this.vendedores = vendedores;
        this.nome = nome;
        this.local = local;
        this.meta = meta;
    }

    public void anunciar() {
        int length = this.getVendedores().length;

        String texto = "O mercado " + this.nome + " localizado em " + this.local;
        System.out.printf("%s, possui uma meta de R$%.2f por venda e possui a seguinte lista de vendedores: \n\n", texto, this.meta);

        for (int i = 0; i < length; i++) {
            Vendedor vendedor = this.getVendedores()[i];
            System.out.printf("%d - ", (i+1));
            vendedor.anunciar();
            }

        System.out.printf("\nEsse mercado obteve um lucro de R$%.2f. \n", this.getTotalVendas());
    }

    public void apurarVendas(Vendedor vendedor) {
        this.totalVendas += vendedor.getValorTotalVendas();
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

    public double getMeta() {
        return meta;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    @Override
    public String toString() {
        return this.nome + "" + this.local;
    }
}
