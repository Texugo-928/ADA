package br.com.ada.crud.controller.estado;

import br.com.ada.crud.controller.estado.impl.EstadoArmazenamentoDefinitivoController;
import br.com.ada.crud.controller.estado.impl.EstadoArmazenamentoVolatilController;
import br.com.ada.crud.model.estado.dao.PersistenciaEstadoTipo;


public class EstadoControllerFactory {

    private final EstadoDAOFactory daoFactory;

    public EstadoControllerFactory(EstadoDAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public EstadoController criar(EstadoArmazenamentoTipo tipo, PersistenciaEstadoTipo tipoPersistencia) {
        EstadoController controller = null;
        if (tipo == EstadoArmazenamentoTipo.VOLATIL) {
            controller = new EstadoArmazenamentoVolatilController();
        }
        else if (tipo == EstadoArmazenamentoTipo.DEFINITIVO) {
            controller = new EstadoArmazenamentoDefinitivoController(
                    daoFactory.criar(tipoPersistencia));
        }
        else {
            throw new RuntimeException("Nenhuma implementação disponível");
        }
        return controller;
    }
}


