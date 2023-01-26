package br.com.ada.crud.controller.cidade;

import br.com.ada.crud.model.cidade.dao.PersistenciaTipo;
import br.com.ada.crud.model.cidade.dao.CidadeDAO;
import br.com.ada.crud.model.cidade.dao.impl.CidadeBinaryDAO;
import br.com.ada.crud.model.cidade.dao.impl.CidadeXMLDao;

public class CidadeDAOFactory {

    public CidadeDAO criar(PersistenciaTipo tipo) {
        CidadeDAO cidadeDAO = null;
        if (tipo == PersistenciaTipo.BINARIA) {
            cidadeDAO = new CidadeBinaryDAO();
        } else if (tipo == PersistenciaTipo.XML) {
            cidadeDAO = new CidadeXMLDao();
        }
        return cidadeDAO;
    }

}
