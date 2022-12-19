package Programacao_Orientada_a_Objetos_I.Objetos;

public class Vendedor {
    private final String nome;
    private final String sobrenome;
    private double valorTotalVendas;
    private double valorBonificacao;
    private Mercado mercado;



    public Vendedor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public void anunciar() {
        String texto = "O vendedor " + this.nome + " " + this.sobrenome + " vendeu R$";
        String textoBonificacao = "e foi bonificado com R$";


        if (this.valorBonificacao > 0) {
            System.out.printf("%s%.2f %s%.2f. TOTAL: R$%.2f\n", texto, this.valorTotalVendas, textoBonificacao, this.valorBonificacao, (this.valorTotalVendas + this.valorBonificacao));
        }
        else {
            System.out.printf("%s%.2f %s%.2f. TOTAL: R$%.2f\n", texto, this.valorTotalVendas, textoBonificacao, this.valorBonificacao, (this.valorTotalVendas + this.valorBonificacao));
        }
    }

    public void vender(double valor) {
        this.valorTotalVendas += valor;
    }

    public void receberBonificacao() {
        this.valorBonificacao = valorTotalVendas * 0.1;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public double getValorTotalVendas() {
        return valorTotalVendas;
    }

    public double getValorBonificacao() {
        return valorBonificacao;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    @Override
    public String toString() {
        return this.nome + "" + this.sobrenome;
    }
}
