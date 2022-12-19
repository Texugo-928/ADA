package Programacao_Orientada_a_Objetos_I.Objetos;

import static Programacao_Orientada_a_Objetos_I.Prova_1.random;

public class Comprador {
    private final String nome;
    private final String sobrenome;
    private double valorCompras;



    public Comprador(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public void comprar(Vendedor vendedor) {
        double valor = random.nextDouble(100, 1000);
        vendedor.vender(valor);
        this.valorCompras += valor;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public double getValorCompras() {
        return valorCompras;
    }

    @Override
    public String toString() {
        return this.nome + "" + this.sobrenome;
    }
}
