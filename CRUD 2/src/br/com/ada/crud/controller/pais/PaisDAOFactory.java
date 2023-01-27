package br.com.ada.crud.controller.pais;

import br.com.ada.crud.model.pais.dao.PersistenciaPaisTipo;
import br.com.ada.crud.model.pais.dao.PaisDAO;
import br.com.ada.crud.model.pais.dao.impl.PaisBinaryDAO;
import br.com.ada.crud.model.pais.dao.impl.PaisXMLDao;

public class PaisDAOFactory {

    public PaisDAO criar(PersistenciaPaisTipo tipo) {
        PaisDAO paisDAO = null;
        if (tipo == PersistenciaPaisTipo.BINARIA) {
            paisDAO = new PaisBinaryDAO();
        } else if (tipo == PersistenciaPaisTipo.XML) {
            paisDAO = new PaisXMLDao();
        }
        return paisDAO;
    }

}