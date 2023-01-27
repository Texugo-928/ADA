package br.com.ada.crud.controller.estado;

import br.com.ada.crud.Configuracoes;
import br.com.ada.crud.model.estado.dao.EstadoDAO;
import br.com.ada.crud.model.estado.dao.PersistenciaEstadoTipo;
import br.com.ada.crud.model.estado.dao.impl.EstadoBinaryDAO;
import br.com.ada.crud.model.estado.dao.impl.EstadoXMLDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EstadoDAOFactory {

    private static final EstadoDAOFactory INSTANCE = new EstadoDAOFactory();
    private static final String PERSISTENCIA_TIPO = "estado.persistencia.tipo";
    private PersistenciaEstadoTipo tipo;
    private EstadoDAOFactory() {
    }
    public static EstadoDAOFactory getInstance() {
        return INSTANCE;
    }
    public EstadoDAO criar() {
        if (tipo == null) {
            carregarTipoPersistencia();
        }
        EstadoDAO estadoDAO = null;
        if (tipo == PersistenciaEstadoTipo.BINARIA) {
            estadoDAO = new EstadoBinaryDAO();
        } else if (tipo == PersistenciaEstadoTipo.XML) {
            estadoDAO = new EstadoXMLDao();
        }
        return estadoDAO;
    }
    private void carregarTipoPersistencia() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(Configuracoes.ARQUIVO_PROPRIEDADES));

            String valorNoArquivo = properties.getProperty(PERSISTENCIA_TIPO);
            tipo = PersistenciaEstadoTipo.valueOf(valorNoArquivo);
        } catch (IOException ex) {
            throw new RuntimeException("Não foi possível ler o arquivo de configurações", ex);
        }
    }
}