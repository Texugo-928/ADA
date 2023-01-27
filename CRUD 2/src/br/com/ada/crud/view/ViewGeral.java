package br.com.ada.crud.view;

import br.com.ada.crud.controller.cidade.CidadeArmazenamentoTipo;
import br.com.ada.crud.controller.cidade.CidadeController;
import br.com.ada.crud.controller.cidade.CidadeControllerFactory;
import br.com.ada.crud.controller.cidade.CidadeDAOFactory;
import br.com.ada.crud.controller.estado.EstadoArmazenamentoTipo;
import br.com.ada.crud.controller.estado.EstadoController;
import br.com.ada.crud.controller.estado.EstadoControllerFactory;
import br.com.ada.crud.controller.estado.EstadoDAOFactory;
import br.com.ada.crud.controller.pais.PaisArmazenamentoTipo;
import br.com.ada.crud.controller.pais.PaisController;
import br.com.ada.crud.controller.pais.PaisControllerFactory;
import br.com.ada.crud.controller.pais.PaisDAOFactory;
import br.com.ada.crud.model.cidade.dao.PersistenciaCidadeTipo;
import br.com.ada.crud.model.estado.dao.PersistenciaEstadoTipo;
import br.com.ada.crud.model.pais.dao.PersistenciaPaisTipo;
import br.com.ada.crud.view.cidade.CidadeView;
import br.com.ada.crud.view.estado.EstadoView;
import br.com.ada.crud.view.pais.PaisView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ViewGeral {
    private static final String ARQUIVO_PROPRIEDADES = "crud.properties";
    private static final String CONTROLLER_CIDADE_TIPO = "cidade.controller.tipo";
    private static final String CONTROLLER_ESTADO_TIPO = "estado.controller.tipo";
    private static final String CONTROLLER_PAIS_TIPO = "pais.controller.tipo";

    private static final String PERSISTENCIA_CIDADE_TIPO = "cidade.persistencia.tipo";
    private static final String PERSISTENCIA_ESTADO_TIPO = "estado.persistencia.tipo";
    private static final String PERSISTENCIA_PAIS_TIPO = "pais.persistencia.tipo";

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
        Properties propriedades = new Properties();
        propriedades.load(new FileInputStream(ARQUIVO_PROPRIEDADES));

        String tipoArmazenamento = propriedades.getProperty(CONTROLLER_PAIS_TIPO);
        PaisArmazenamentoTipo tipo = PaisArmazenamentoTipo.valueOf(tipoArmazenamento);

        String persistencia = propriedades.getProperty(PERSISTENCIA_PAIS_TIPO);
        PersistenciaPaisTipo persistenciaPaisTipo = PersistenciaPaisTipo.valueOf(persistencia);

        PaisControllerFactory factory = new PaisControllerFactory(
                new PaisDAOFactory());
        PaisController paisController = factory.criar(tipo, persistenciaPaisTipo);

        PaisView view = new PaisView(paisController, new Scanner(System.in));
        view.exibirOpcoesPais();
    }

    public void menuEstado() throws IOException {
        Properties propriedades = new Properties();
        propriedades.load(new FileInputStream(ARQUIVO_PROPRIEDADES));

        String tipoArmazenamento = propriedades.getProperty(CONTROLLER_ESTADO_TIPO);
        EstadoArmazenamentoTipo tipo = EstadoArmazenamentoTipo.valueOf(tipoArmazenamento);

        String persistencia = propriedades.getProperty(PERSISTENCIA_ESTADO_TIPO);
        PersistenciaEstadoTipo persistenciaEstadoTipo = PersistenciaEstadoTipo.valueOf(persistencia);

        EstadoControllerFactory factory = new EstadoControllerFactory(
                new EstadoDAOFactory());
        EstadoController estadoController = factory.criar(tipo, persistenciaEstadoTipo);

        EstadoView estadoView = new EstadoView(estadoController, new Scanner(System.in));
        estadoView.exibirOpcoesEstado();
    }

    public void menuCidade() throws IOException {
        Properties propriedades = new Properties();
        propriedades.load(new FileInputStream(ARQUIVO_PROPRIEDADES));

        String tipoArmazenamento = propriedades.getProperty(CONTROLLER_CIDADE_TIPO);
        CidadeArmazenamentoTipo tipo = CidadeArmazenamentoTipo.valueOf(tipoArmazenamento);

        String persistencia = propriedades.getProperty(PERSISTENCIA_CIDADE_TIPO);
        PersistenciaCidadeTipo persistenciaCidadeTipo = PersistenciaCidadeTipo.valueOf(persistencia);

        CidadeControllerFactory factory = new CidadeControllerFactory(
                new CidadeDAOFactory());
        CidadeController cidadeController = factory.criar(tipo, persistenciaCidadeTipo);

        CidadeView cidadeView = new CidadeView(cidadeController, new Scanner(System.in));
        cidadeView.exibirOpcoesCidade();
    }
}
