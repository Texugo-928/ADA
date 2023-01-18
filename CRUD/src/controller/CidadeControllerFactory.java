package controller;

import controller.impl.CidadeArmazenamentoDefinitivoController;
import controller.impl.CidadeArmazenamentoVolatilArmazenamentoVolatilController;
import model.cidade.dao.impl.CidadeBinaryDAO;

public class CidadeControllerFactory {

    public CidadeController criar(CidadeArmazenamentoTipo tipo) {

        CidadeController controller = null;

        if (tipo == CidadeArmazenamentoTipo.VOLATIL) {
            controller = new CidadeArmazenamentoVolatilArmazenamentoVolatilController();
        }

        else if (tipo == CidadeArmazenamentoTipo.DEFINITIVO) {
            controller = new CidadeArmazenamentoDefinitivoController(new CidadeBinaryDAO());
        }

        else {
            throw new RuntimeException("Nenhuma implementação disponível");
        }

        return controller;

    }
}
