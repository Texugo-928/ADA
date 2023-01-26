package br.com.ada.crud.controller.cidade.impl;

import br.com.ada.crud.controller.cidade.CidadeController;
import br.com.ada.crud.model.cidade.Cidade;
import br.com.ada.crud.model.cidade.dao.CidadeDAO;

import java.util.List;
import java.util.UUID;

public class CidadeArmazenamentoDefinitivoController implements CidadeController {

    private CidadeDAO cidadeDao;

    public CidadeArmazenamentoDefinitivoController(CidadeDAO cidadeDao) {
        this.cidadeDao = cidadeDao;
    }

    @Override
    public void cadastrar(Cidade cidade) {
        cidade.setId(UUID.randomUUID());
        cidadeDao.cadastrar(cidade);
    }

    @Override
    public Cidade ler(UUID id) {
        return cidadeDao.ler(id);
    }

    @Override
    public void atualizar(UUID id, Cidade cidade) {
        cidadeDao.atualizar(id, cidade);
    }

    @Override
    public Cidade deletar(UUID id) {
        return cidadeDao.deletar(id);
    }

    @Override
    public List<Cidade> listar() {
        return cidadeDao.listar();
    }
}
