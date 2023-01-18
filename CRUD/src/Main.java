import controller.CidadeArmazenamentoTipo;
import controller.CidadeControllerFactory;
import view.CidadeView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final String ARQUIVO_PROPRIEDADES = "crud.properties";
    private static final String CONTROLLER_TIPO = "cidade.controller.tipo";

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(ARQUIVO_PROPRIEDADES));

        String tipoArmazenamento = properties.getProperty(CONTROLLER_TIPO);
        CidadeArmazenamentoTipo tipo = CidadeArmazenamentoTipo.valueOf(tipoArmazenamento);

        CidadeControllerFactory factory = new CidadeControllerFactory();

        CidadeView view = new CidadeView(factory.criar(tipo), new Scanner(System.in));
        view.exibirOpcoes();
    }
}