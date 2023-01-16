import Controller.Impl.CidadeArmazenamentoVolatilArmazenamentoVolatilController;
import View.CidadeView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CidadeView view = new CidadeView(
                new CidadeArmazenamentoVolatilArmazenamentoVolatilController(),
                new Scanner(System.in)
        );
        view.exibirOpcoes();
    }
}