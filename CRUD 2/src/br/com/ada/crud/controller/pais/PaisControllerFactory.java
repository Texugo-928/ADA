package br.com.ada.crud.controller.pais;

import br.com.ada.crud.controller.pais.impl.PaisArmazenamentoDefinitivoController;
import br.com.ada.crud.controller.pais.impl.PaisArmazenamentoVolatilController;
import br.com.ada.crud.model.pais.dao.PersistenciaPaisTipo;


public class PaisControllerFactory {

    private final PaisDAOFactory daoFactory;

    public PaisControllerFactory(PaisDAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public PaisController criar(PaisArmazenamentoTipo tipo, PersistenciaPaisTipo tipoPersistencia) {
        PaisController controller = null;
        if (tipo == PaisArmazenamentoTipo.VOLATIL) {
            controller = new PaisArmazenamentoVolatilController();
        }
        else if (tipo == PaisArmazenamentoTipo.DEFINITIVO) {
            controller = new PaisArmazenamentoDefinitivoController(
                    daoFactory.criar(tipoPersistencia));
        }
        else {
            throw new RuntimeException("Nenhuma implementação disponível");
        }
        return controller;
    }
}


