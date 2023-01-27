package br.com.ada.crud.controller.pais;

import br.com.ada.crud.Configuracoes;
import br.com.ada.crud.controller.arquivo.EscritorArquivo;
import br.com.ada.crud.controller.arquivo.LeitorArquivo;
import br.com.ada.crud.controller.arquivo.impl.binario.PaisArquivoBinario;
import br.com.ada.crud.controller.arquivo.impl.xml.PaisArquivoXml;
import br.com.ada.crud.model.pais.Pais;
import br.com.ada.crud.model.pais.dao.PaisDAO;
import br.com.ada.crud.model.pais.dao.PersistenciaPaisTipo;
import br.com.ada.crud.model.pais.dao.impl.PaisArquivoDAO;

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

        EscritorArquivo<Pais> escritor = null;
        LeitorArquivo<Pais> leitor = null;

        if (tipo == PersistenciaPaisTipo.BINARIA) {
            escritor = new PaisArquivoBinario();
            leitor = new PaisArquivoBinario();
        }
        else if (tipo == PersistenciaPaisTipo.XML) {
            escritor = new PaisArquivoXml();
            leitor = new PaisArquivoXml();
        }
        return new PaisArquivoDAO(escritor, leitor);
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
