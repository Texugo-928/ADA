package br.com.ada.crud.view;

import br.com.ada.crud.controller.cidade.CidadeController;
import br.com.ada.crud.controller.cidade.CidadeControllerFactory;
import br.com.ada.crud.controller.estado.EstadoController;
import br.com.ada.crud.controller.estado.EstadoControllerFactory;
import br.com.ada.crud.controller.pais.PaisController;
import br.com.ada.crud.controller.pais.PaisControllerFactory;
import br.com.ada.crud.view.cidade.CidadeView;
import br.com.ada.crud.view.estado.EstadoView;
import br.com.ada.crud.view.pais.PaisView;

import java.io.IOException;
import java.util.Scanner;

public class ViewGeral {
    private static final Scanner scanner = new Scanner(System.in);

    public void exibirOpcoesGerais() throws IOException {

        System.out.println("Informe a opcao desejada para cadastro:");
        System.out.println("1 - Cidade");
        System.out.println("2 - Estado");
        System.out.println("3 - Pais");
        System.out.println("0 - Sair");

        Integer opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                menuCidade();
                break;
            case 2:
                menuEstado();
                break;
            case 3:
                menuPais();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida!");
        }

        exibirOpcoesGerais();

    }

    public void menuPais() throws IOException {
        PaisController paisController = PaisControllerFactory.getInstance().criar();;
        PaisView paisView = new PaisView(paisController, scanner);
        paisView.exibirOpcoesPais();
    }

    public void menuEstado() throws IOException {
        EstadoController estadoController = EstadoControllerFactory.getInstance().criar();;
        EstadoView estadoView = new EstadoView(estadoController, scanner);
        estadoView.exibirOpcoesEstado();
    }

    public void menuCidade() throws IOException {
        CidadeController cidadeController = CidadeControllerFactory.getInstance().criar();;
        CidadeView cidadeView = new CidadeView(cidadeController, scanner);
        cidadeView.exibirOpcoesCidade();
    }
}
