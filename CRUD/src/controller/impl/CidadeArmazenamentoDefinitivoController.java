package controller.impl;

import controller.CidadeController;
import model.cidade.Cidade;
import model.cidade.dao.CidadeDAO;

import java.util.List;
import java.util.UUID;

public class CidadeArmazenamentoDefinitivoController implements CidadeController {

    private CidadeDAO cidadeDao;

    public CidadeArmazenamentoDefinitivoController(CidadeDAO cidadeDao) {
        this.cidadeDao = cidadeDao;
    }

    @Override
    public void cadastrar(Cidade cidade) {

    }

    @Override
    public Cidade ler(UUID id) {
        return null;
    }

    @Override
    public void atualizar(UUID id, Cidade cidade) {

    }

    @Override
    public Cidade deletar(UUID id) {
        return null;
    }

    @Override
    public List<Cidade> listar() {
        return null;
    }
}
