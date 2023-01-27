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

public class Main {

    //TODO: arrumar melhor essa parte
    //TODO: criar um menu para escolher entre os 3 modelos

    private static final String ARQUIVO_PROPRIEDADES = "crud.properties";
    private static final String CONTROLLER_CIDADE_TIPO = "cidade.controller.tipo";
    private static final String CONTROLLER_ESTADO_TIPO = "estado.controller.tipo";
    private static final String CONTROLLER_PAIS_TIPO = "pais.controller.tipo";

    private static final String PERSISTENCIA_CIDADE_TIPO = "cidade.persistencia.tipo";
    private static final String PERSISTENCIA_ESTADO_TIPO = "estado.persistencia.tipo";
    private static final String PERSISTENCIA_PAIS_TIPO = "pais.persistencia.tipo";

    public static void main(String[] args) throws IOException {
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
}