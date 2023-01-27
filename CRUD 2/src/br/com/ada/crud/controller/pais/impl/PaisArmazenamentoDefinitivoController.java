package br.com.ada.crud.controller.pais.impl;

import br.com.ada.crud.controller.pais.PaisController;
import br.com.ada.crud.model.pais.Pais;
import br.com.ada.crud.model.pais.dao.PaisDAO;

import java.util.List;
import java.util.UUID;

public class PaisArmazenamentoDefinitivoController implements PaisController {

    private PaisDAO paisDao;

    public PaisArmazenamentoDefinitivoController(PaisDAO paisDao) {
        this.paisDao = paisDao;
    }

    @Override
    public void cadastrar(Pais pais) {
        pais.setId(UUID.randomUUID());
        paisDao.cadastrar(pais);
    }

    @Override
    public Pais ler(UUID id) {
        return paisDao.ler(id);
    }

    @Override
    public void atualizar(UUID id, Pais pais) {
        paisDao.atualizar(id, pais);
    }

    @Override
    public Pais deletar(UUID id) {
        return paisDao.deletar(id);
    }

    @Override
    public List<Pais> listar() {
        return paisDao.listar();
    }
}
