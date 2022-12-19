package Programacao_Orientada_a_Objetos_I.Objetos;

public class Regulador {

    public void bonificar(int QUANTIDADE_COMPRADORES, Vendedor vendedor) {
        if (vendedor.getValorTotalVendas() > (vendedor.getMercado().getMeta() * QUANTIDADE_COMPRADORES)) {
            vendedor.receberBonificacao();
        }
    }

    public void aplicar(int QUANTIDADE_COMPRADORES, Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();

            for (int j = 0; j < vendedores.length; j++) {
                Vendedor vendedor = vendedores[j];

                bonificar(QUANTIDADE_COMPRADORES, vendedor);
            }
        }

    }
}
