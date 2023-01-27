package br.com.ada.crud.view.estado;

import br.com.ada.crud.controller.estado.EstadoController;
import br.com.ada.crud.model.estado.Estado;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class EstadoView {

    private EstadoController controller;
    private Scanner scanner;

    public EstadoView(EstadoController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void cadastrar() {

        Estado estado = new Estado();

        System.out.println("Informe o nome da estado a ser cadastrado:");
        String nome = scanner.next();
        scanner.nextLine();
        estado.setNome(nome);

        System.out.println("Informe a sigla do estado:");
        String sigla = scanner.next();
        scanner.nextLine();
        estado.setSigla(sigla);

        System.out.println("Informe o pais:");
        String pais = scanner.next();
        estado.setPais(pais);

        controller.cadastrar(estado);

    }

    public void listar() {

        List<Estado> estados = controller.listar();

        for (int i = 0; i < estados.size(); i++) {
            System.out.print((i+1) + " - ");
            exibirEstado(estados.get(i));

        }
    }

    public void atualizar() {

        listar();
        System.out.println("Informe o número do estado que deseja atualizar:");
        Integer numeroEstado = scanner.nextInt();

        Estado estado = controller.listar().get(numeroEstado - 1);

        atualizar(estado);

        //TODO: capturar erro ao passar um numero inválido
    }

    public void atualizar(Estado estado) {

        exibirEstado(estado);

        System.out.println("Informe a versão atualizada do nome do estado:");
        String nome = scanner.next();
        scanner.nextLine();
        estado.setNome(nome);

        System.out.println("Informe a versão atualizada da sigla do estado:");
        String sigla = scanner.next();
        scanner.nextLine();
        estado.setSigla(sigla);

        System.out.println("Informe a versão atualizada do pais:");
        String pais = scanner.next();
        estado.setPais(pais);

        controller.atualizar(estado.getId(), estado);

    }

    public void deletar() {

        listar();
        System.out.println("Informe o número do estado que deseja deletar:");
        Integer numeroEstado = scanner.nextInt();

        Estado estado = controller.listar().get(numeroEstado - 1);

        deletar(estado.getId());

    }

    public void deletar(UUID id) {

        Estado estado = controller.deletar(id);
        System.out.println("Estado apagado foi:");

        exibirEstado(estado);

    }

    private void exibirEstado(Estado estado) {

        String nome = estado.getNome();
        String sigla = estado.getSigla();
        String pais = estado.getPais();

        System.out.println("Estado: " + nome + " - Sigla: " + sigla + " - Pais: " + pais);

    }

    public void exibirOpcoesEstado() {

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

        exibirOpcoesEstado();

    }

}
