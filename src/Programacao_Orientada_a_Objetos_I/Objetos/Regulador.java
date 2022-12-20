package Programacao_Orientada_a_Objetos_I.Objetos;

public class Regulador {

    public void aplicar(int QUANTIDADE_COMPRADORES, Mercado[] mercados) {
        for (Mercado mercado : mercados) {
            Vendedor[] vendedores = mercado.getVendedores();
            for (Vendedor vendedor : vendedores) {
                bonificar(QUANTIDADE_COMPRADORES, vendedor);
            }
        }
    }

    public void bonificar(int QUANTIDADE_COMPRADORES, Vendedor vendedor) {
        double totalVendas = vendedor.getValorTotalVendas();
        double meta = vendedor.getMercado().getMeta();
        if (totalVendas > (meta * QUANTIDADE_COMPRADORES)) {
            vendedor.receberBonificacao();
        }
    }

}