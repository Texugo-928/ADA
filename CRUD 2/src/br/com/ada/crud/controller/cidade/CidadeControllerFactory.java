package br.com.ada.crud.controller.cidade;

import br.com.ada.crud.controller.cidade.impl.CidadeArmazenamentoDefinitivoController;
import br.com.ada.crud.controller.cidade.impl.CidadeArmazenamentoVolatilController;
import br.com.ada.crud.model.cidade.dao.PersistenciaCidadeTipo;


public class CidadeControllerFactory {

    private final CidadeDAOFactory daoFactory;

    public CidadeControllerFactory(CidadeDAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public CidadeController criar(CidadeArmazenamentoTipo tipo, PersistenciaCidadeTipo tipoPersistencia) {
            CidadeController controller = null;
            if (tipo == CidadeArmazenamentoTipo.VOLATIL) {
                controller = new CidadeArmazenamentoVolatilController();
            }
            else if (tipo == CidadeArmazenamentoTipo.DEFINITIVO) {
                controller = new CidadeArmazenamentoDefinitivoController(
                        daoFactory.criar(tipoPersistencia));
            }
            else {
                throw new RuntimeException("Nenhuma implementação disponível");
            }
            return controller;
    }
}


