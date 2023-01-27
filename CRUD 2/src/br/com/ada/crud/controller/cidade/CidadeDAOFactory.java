package br.com.ada.crud.controller.cidade;

import br.com.ada.crud.Configuracoes;
import br.com.ada.crud.model.cidade.dao.PersistenciaCidadeTipo;
import br.com.ada.crud.model.cidade.dao.CidadeDAO;
import br.com.ada.crud.model.cidade.dao.impl.CidadeBinaryDAO;
import br.com.ada.crud.model.cidade.dao.impl.CidadeXMLDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CidadeDAOFactory {

    private static final CidadeDAOFactory INSTANCE = new CidadeDAOFactory();
    private static final String PERSISTENCIA_TIPO = "cidade.persistencia.tipo";
    private PersistenciaCidadeTipo tipo;
    private CidadeDAOFactory() {
    }
    public static CidadeDAOFactory getInstance() {
        return INSTANCE;
    }
    public CidadeDAO criar() {
        if (tipo == null) {
            carregarTipoPersistencia();
        }
        CidadeDAO cidadeDAO = null;
        if (tipo == PersistenciaCidadeTipo.BINARIA) {
            cidadeDAO = new CidadeBinaryDAO();
        } else if (tipo == PersistenciaCidadeTipo.XML) {
            cidadeDAO = new CidadeXMLDao();
        }
        return cidadeDAO;
    }
    private void carregarTipoPersistencia() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(Configuracoes.ARQUIVO_PROPRIEDADES));

            String valorNoArquivo = properties.getProperty(PERSISTENCIA_TIPO);
            tipo = PersistenciaCidadeTipo.valueOf(valorNoArquivo);
        } catch (IOException ex) {
            throw new RuntimeException("Não foi possível ler o arquivo de configurações", ex);
        }
    }
}
