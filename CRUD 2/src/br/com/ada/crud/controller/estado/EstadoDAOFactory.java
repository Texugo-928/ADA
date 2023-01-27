package br.com.ada.crud.controller.estado;

import br.com.ada.crud.model.estado.dao.PersistenciaEstadoTipo;
import br.com.ada.crud.model.estado.dao.EstadoDAO;
import br.com.ada.crud.model.estado.dao.impl.EstadoBinaryDAO;
import br.com.ada.crud.model.estado.dao.impl.EstadoXMLDao;

public class EstadoDAOFactory {

    public EstadoDAO criar(PersistenciaEstadoTipo tipo) {
        EstadoDAO estadoDAO = null;
        if (tipo == PersistenciaEstadoTipo.BINARIA) {
            estadoDAO = new EstadoBinaryDAO();
        } else if (tipo == PersistenciaEstadoTipo.XML) {
            estadoDAO = new EstadoXMLDao();
        }
        return estadoDAO;
    }

}