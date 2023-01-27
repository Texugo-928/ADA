package br.com.ada.crud.controller.cidade;

import br.com.ada.crud.Configuracoes;
import br.com.ada.crud.controller.cidade.impl.CidadeArmazenamentoDefinitivoController;
import br.com.ada.crud.controller.cidade.impl.CidadeArmazenamentoVolatilController;
import br.com.ada.crud.model.cidade.dao.CidadeDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class CidadeControllerFactory {
    private static final CidadeControllerFactory INSTANCE = new CidadeControllerFactory();
    private static final String CONTROLLER_TIPO = "cidade.controller.tipo";
    private CidadeArmazenamentoTipo tipo;

    private CidadeControllerFactory() {
    }
    public static CidadeControllerFactory getInstance() {
        return INSTANCE;
    }

    public CidadeController criar() {
        if (tipo == null) {
            carregarTipoArmazenamento();
        }

        CidadeDAOFactory daoFactory = CidadeDAOFactory.getInstance();
        CidadeController controller = null;

        if (tipo == CidadeArmazenamentoTipo.VOLATIL) {
            controller = new CidadeArmazenamentoVolatilController();
        } else if (tipo == CidadeArmazenamentoTipo.DEFINITIVO) {
            CidadeDAO cidadeDAO = daoFactory.criar();
            controller = new CidadeArmazenamentoDefinitivoController(cidadeDAO);
        } else {
            throw new RuntimeException("Nenhuma implementação disponível");
        }
        return controller;
    }

    private void carregarTipoArmazenamento() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(Configuracoes.ARQUIVO_PROPRIEDADES));

            String valorDoArquivo = properties.getProperty(CONTROLLER_TIPO);
            tipo = CidadeArmazenamentoTipo.valueOf(valorDoArquivo);
        }catch(IOException ex) {
            throw new RuntimeException("Falha no carregamento do arquivo de propriedaes.",ex);
        }
    }

}


