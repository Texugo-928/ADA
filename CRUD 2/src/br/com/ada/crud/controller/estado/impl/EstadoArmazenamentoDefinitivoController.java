package br.com.ada.crud.controller.estado.impl;

import br.com.ada.crud.controller.estado.EstadoController;
import br.com.ada.crud.model.estado.Estado;
import br.com.ada.crud.model.estado.dao.EstadoDAO;

import java.util.List;
import java.util.UUID;

public class EstadoArmazenamentoDefinitivoController implements EstadoController {

    private EstadoDAO estadoDao;

    public EstadoArmazenamentoDefinitivoController(EstadoDAO estadoDao) {
        this.estadoDao = estadoDao;
    }

    @Override
    public void cadastrar(Estado estado) {
        estado.setId(UUID.randomUUID());
        estadoDao.cadastrar(estado);
    }

    @Override
    public Estado ler(UUID id) {
        return estadoDao.ler(id);
    }

    @Override
    public void atualizar(UUID id, Estado estado) {
        estadoDao.atualizar(id, estado);
    }

    @Override
    public Estado deletar(UUID id) {
        return estadoDao.deletar(id);
    }

    @Override
    public List<Estado> listar() {
        return estadoDao.listar();
    }
}
