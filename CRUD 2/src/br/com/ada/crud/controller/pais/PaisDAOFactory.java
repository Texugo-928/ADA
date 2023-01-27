package br.com.ada.crud.controller.pais;

import br.com.ada.crud.Configuracoes;
import br.com.ada.crud.model.pais.dao.PaisDAO;
import br.com.ada.crud.model.pais.dao.PersistenciaPaisTipo;
import br.com.ada.crud.model.pais.dao.impl.PaisBinaryDAO;
import br.com.ada.crud.model.pais.dao.impl.PaisXMLDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PaisDAOFactory {

    private static final PaisDAOFactory INSTANCE = new PaisDAOFactory();
    private static final String PERSISTENCIA_TIPO = "pais.persistencia.tipo";
    private PersistenciaPaisTipo tipo;
    private PaisDAOFactory() {
    }
    public static PaisDAOFactory getInstance() {
        return INSTANCE;
    }
    public PaisDAO criar() {
        if (tipo == null) {
            carregarTipoPersistencia();
        }
        PaisDAO paisDAO = null;
        if (tipo == PersistenciaPaisTipo.BINARIA) {
            paisDAO = new PaisBinaryDAO();
        } else if (tipo == PersistenciaPaisTipo.XML) {
            paisDAO = new PaisXMLDao();
        }
        return paisDAO;
    }
    private void carregarTipoPersistencia() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(Configuracoes.ARQUIVO_PROPRIEDADES));

            String valorNoArquivo = properties.getProperty(PERSISTENCIA_TIPO);
            tipo = PersistenciaPaisTipo.valueOf(valorNoArquivo);
        } catch (IOException ex) {
            throw new RuntimeException("Não foi possível ler o arquivo de configurações", ex);
        }
    }
}
