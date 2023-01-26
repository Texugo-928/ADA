import br.com.ada.crud.controller.cidade.CidadeArmazenamentoTipo;
import br.com.ada.crud.controller.cidade.CidadeController;
import br.com.ada.crud.controller.cidade.CidadeControllerFactory;
import br.com.ada.crud.controller.cidade.CidadeDAOFactory;
import br.com.ada.crud.model.cidade.dao.PersistenciaTipo;
import br.com.ada.crud.view.cidade.CidadeView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final String ARQUIVO_PROPRIEDADES = "crud.properties";
    private static final String CONTROLLER_TIPO = "cidade.controller.tipo";
    private static final String PERSISTENCIA_TIPO = "cidade.persistencia.tipo";

    public static void main(String[] args) throws IOException {
        Properties propriedades = new Properties();
        propriedades.load(new FileInputStream(ARQUIVO_PROPRIEDADES));

        String tipoArmazenamento = propriedades.getProperty(CONTROLLER_TIPO);
        CidadeArmazenamentoTipo tipo = CidadeArmazenamentoTipo.valueOf(tipoArmazenamento);

        String persistencia = propriedades.getProperty(PERSISTENCIA_TIPO);
        PersistenciaTipo persistenciaTipo = PersistenciaTipo.valueOf(persistencia);

        CidadeControllerFactory factory = new CidadeControllerFactory(
                new CidadeDAOFactory());
        CidadeController cidadeController = factory.criar(tipo, persistenciaTipo);

        CidadeView view = new CidadeView(cidadeController, new Scanner(System.in));
        view.exibirOpcoes();
    }
}