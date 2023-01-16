package View;

import Controller.CidadeController;
import Model.Cidade;

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

    public void create() {

        Cidade cidade = new Cidade();

        System.out.println("Informe o nome:");
        String nome = scanner.nextLine();
        scanner.next();
        cidade.setNome(nome);

        System.out.println("Informe o estado:");
        String estado = scanner.nextLine();
        scanner.next();
        cidade.setEstado(estado);

        controller.create(cidade);

    }

    public void list() {

        List<Cidade> cidades = controller.list();

        for (int i = 0; i < cidades.size(); i++) {
            System.out.print((i+1) + " - ");
            exibirCidade(cidades.get(i));

        }
    }

    public void update() {

        list();
        System.out.println("Informe o número do cliente que deseja atualizar:");
        Integer numeroCliente = scanner.nextInt();

        Cidade cidade = controller.list().get(numeroCliente - 1);

        update(cidade);

    }

    public void update(Cidade cidade) {

        exibirCidade(cidade);

        System.out.println("Informe o nome atualizado:");
        String nome = scanner.nextLine();
        scanner.next();
        cidade.setNome(nome);

        System.out.println("Informe o estado atualizado:");
        String estado = scanner.nextLine();
        scanner.next();
        cidade.setEstado(estado);

        controller.update(cidade.getId(), cidade);

    }

    public void delete() {

        list();
        System.out.println("Informe o número do cliente que deseja deletar:");
        Integer numeroCliente = scanner.nextInt();

        Cidade cidade = controller.list().get(numeroCliente - 1);

        delete(cidade.getId());

    }

    public void delete(UUID id) {

        Cidade cidade = controller.delete(id);
        System.out.println("Cidade apagada foi:");

        exibirCidade(cidade);

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
                create();
                break;
            case 2:
                list();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
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
