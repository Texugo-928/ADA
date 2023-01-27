package br.com.ada.crud.controller.cidade;

import br.com.ada.crud.model.cidade.dao.PersistenciaCidadeTipo;
import br.com.ada.crud.model.cidade.dao.CidadeDAO;
import br.com.ada.crud.model.cidade.dao.impl.CidadeBinaryDAO;
import br.com.ada.crud.model.cidade.dao.impl.CidadeXMLDao;

public class CidadeDAOFactory {

    public CidadeDAO criar(PersistenciaCidadeTipo tipo) {
        CidadeDAO cidadeDAO = null;
        if (tipo == PersistenciaCidadeTipo.BINARIA) {
            cidadeDAO = new CidadeBinaryDAO();
        } else if (tipo == PersistenciaCidadeTipo.XML) {
            cidadeDAO = new CidadeXMLDao();
        }
        return cidadeDAO;
    }

}
