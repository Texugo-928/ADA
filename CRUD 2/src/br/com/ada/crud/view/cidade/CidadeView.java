package br.com.ada.crud.view.cidade;

import br.com.ada.crud.controller.cidade.CidadeController;
import br.com.ada.crud.model.cidade.Cidade;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CidadeView {

    private CidadeController controller;
    private Scanner scanner;

    public CidadeView(CidadeController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void cadastrar() {

        Cidade cidade = new Cidade();

        System.out.println("Informe o nome da cidade a ser cadastrada:");
        String nome = scanner.next();
        scanner.nextLine();
        cidade.setNome(nome);

        System.out.println("Informe a sigla do estado:");
        String estado = scanner.next();
        cidade.setEstadoSigla(estado);

        controller.cadastrar(cidade);

    }

    public void listar() {

        List<Cidade> cidades = controller.listar();

        for (int i = 0; i < cidades.size(); i++) {
            System.out.print((i+1) + " - ");
            exibirCidade(cidades.get(i));

        }
    }

    public void atualizar() {

        listar();
        System.out.println("Informe o número da cidade que deseja atualizar:");
        Integer numeroCidade = scanner.nextInt();

        Cidade cidade = controller.listar().get(numeroCidade - 1);

        atualizar(cidade);

        //TODO: capturar erro ao passar um numero inválido
    }

    public void atualizar(Cidade cidade) {

        exibirCidade(cidade);

        System.out.println("Informe a versão atualizada do nome da cidade:");
        String nome = scanner.next();
        scanner.nextLine();
        cidade.setNome(nome);

        System.out.println("Informe a versão atualizada da sigla do estado:");
        String estado = scanner.next();
        cidade.setEstadoSigla(estado);

        controller.atualizar(cidade.getId(), cidade);

    }

    public void deletar() {

        listar();
        System.out.println("Informe o número da cidade que deseja deletar:");
        Integer numeroCidade = scanner.nextInt();

        Cidade cidade = controller.listar().get(numeroCidade - 1);

        deletar(cidade.getId());

    }

    public void deletar(UUID id) {

        Cidade cidade = controller.deletar(id);
        System.out.println("Cidade apagada foi:");

        exibirCidade(cidade);

    }

    private void exibirCidade(Cidade cidade) {

        String nome = cidade.getNome();
        String estadoSigla = cidade.getEstadoSigla();

        System.out.println("Cidade: " + nome + " - Estado: " + estadoSigla);

    }

    public void exibirOpcoes() {

        System.out.println("Informe a opcao desejada:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
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
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida!");
        }

        exibirOpcoes();

    }

}
