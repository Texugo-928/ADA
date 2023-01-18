package view;

import controller.CidadeController;
import controller.exception.CidadeNaoEncontrada;
import model.cidade.Cidade;

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

        System.out.println("Informe o nome:");
        String nome = scanner.nextLine();
        scanner.next();
        cidade.setNome(nome);

        System.out.println("Informe o estado:");
        String estado = scanner.nextLine();
        scanner.next();
        cidade.setEstado(estado);

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
        System.out.println("Informe o número do cliente que deseja atualizar:");
        Integer numeroCliente = scanner.nextInt();

        Cidade cidade = controller.listar().get(numeroCliente - 1);

        atualizar(cidade);

    }

    public void atualizar(Cidade cidade) {

        exibirCidade(cidade);

        System.out.println("Informe o nome atualizado:");
        String nome = scanner.nextLine();
        scanner.next();
        cidade.setNome(nome);

        System.out.println("Informe o estado atualizado:");
        String estado = scanner.nextLine();
        scanner.next();
        cidade.setEstado(estado);

        try {
            controller.atualizar(cidade.getId(), cidade);
        }
        catch (CidadeNaoEncontrada ex) {
            System.out.println("Pessoa informada não existe na base. Tente novamente.");
        }
    }

    public void deletar() {

        listar();
        System.out.println("Informe o número do cliente que deseja deletar:");
        Integer numeroCliente = scanner.nextInt();

        Cidade cidade = controller.listar().get(numeroCliente - 1);

        deletar(cidade.getId());

    }

    public void deletar(UUID id) {

        try {
            Cidade cidade = controller.deletar(id);
            System.out.println("Cidade apagada foi:");

            exibirCidade(cidade);
        }
        catch (CidadeNaoEncontrada ex) {
            System.out.println("Cidade não foi agapada pois não foi localizada. Tente novamente!");
        }

    }

    private void exibirCidade(Cidade cidade) {

        System.out.println("Cidade: " + cidade.getNome() + " - Estado: " + cidade.getEstado());

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
