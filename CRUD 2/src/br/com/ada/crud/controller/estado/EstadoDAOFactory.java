package br.com.ada.crud.controller.estado;

import br.com.ada.crud.Configuracoes;
import br.com.ada.crud.controller.arquivo.EscritorArquivo;
import br.com.ada.crud.controller.arquivo.LeitorArquivo;
import br.com.ada.crud.controller.arquivo.impl.binario.EstadoArquivoBinario;
import br.com.ada.crud.controller.arquivo.impl.xml.EstadoArquivoXml;
import br.com.ada.crud.model.estado.Estado;
import br.com.ada.crud.model.estado.dao.EstadoDAO;
import br.com.ada.crud.model.estado.dao.PersistenciaEstadoTipo;
import br.com.ada.crud.model.estado.dao.impl.EstadoArquivoDAO;

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

        EscritorArquivo<Estado> escritor = null;
        LeitorArquivo<Estado> leitor = null;

        if (tipo == PersistenciaEstadoTipo.BINARIA) {
            escritor = new EstadoArquivoBinario();
            leitor = new EstadoArquivoBinario();
        }
        else if (tipo == PersistenciaEstadoTipo.XML) {
            escritor = new EstadoArquivoXml();
            leitor = new EstadoArquivoXml();
        }
        return new EstadoArquivoDAO(escritor, leitor);
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