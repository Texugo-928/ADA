package br.com.ada.crud.view.pais;

import br.com.ada.crud.controller.pais.PaisController;
import br.com.ada.crud.model.pais.Pais;
import br.com.ada.crud.view.ViewGeral;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class PaisView {

    private PaisController controller;
    private Scanner scanner;

    public PaisView(PaisController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void cadastrar() {

        Pais pais = new Pais();

        System.out.println("Informe o nome do pais a ser cadastrado:");
        String nome = scanner.next();
        scanner.nextLine();
        pais.setNome(nome);

        System.out.println("Informe a sigla do pais:");
        String sigla = scanner.next();
        pais.setSigla(sigla);

        controller.cadastrar(pais);

    }

    public void listar() {

        List<Pais> paises = controller.listar();

        for (int i = 0; i < paises.size(); i++) {
            System.out.print((i+1) + " - ");
            exibirPais(paises.get(i));

        }
    }

    public void atualizar() {

        listar();
        System.out.println("Informe o número do pais que deseja atualizar:");
        Integer numeroPais = scanner.nextInt();

        Pais pais = controller.listar().get(numeroPais - 1);

        atualizar(pais);
    }

    public void atualizar(Pais pais) {

        exibirPais(pais);

        System.out.println("Informe a versão atualizada do nome do pais:");
        String nome = scanner.next();
        scanner.nextLine();
        pais.setNome(nome);

        System.out.println("Informe a versão atualizada da sigla do pais:");
        String sigla = scanner.next();
        pais.setSigla(sigla);

        controller.atualizar(pais.getId(), pais);

    }

    public void deletar() {

        listar();
        System.out.println("Informe o número do pais que deseja deletar:");
        Integer numeroPais = scanner.nextInt();

        Pais pais = controller.listar().get(numeroPais - 1);

        deletar(pais.getId());

    }

    public void deletar(UUID id) {

        Pais pais = controller.deletar(id);
        System.out.println("Pais apagado foi:");

        exibirPais(pais);

    }

    private void exibirPais(Pais pais) {

        String nome = pais.getNome();
        String sigla = pais.getSigla();

        System.out.println("Pais: " + nome + " - Sigla: " + sigla);

    }

    public void exibirOpcoesPais() throws IOException {

        System.out.println("Informe a opcao desejada:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        System.out.println("5 - Voltar ao Menu Inicial");
        System.out.println("0 - Sair");

        Integer opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                cadastrar();
                break;
            case 2:
                listar();
                break;
            case 3:
                atualizar();
                break;
            case 4:
                deletar();
                break;
            case 5:
                ViewGeral viewGeral = new ViewGeral();
                viewGeral.exibirOpcoesGerais();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida!");
        }

        exibirOpcoesPais();

    }

}
