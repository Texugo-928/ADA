package model.cidade.dao;

import model.cidade.Cidade;

import java.util.List;
import java.util.UUID;

public interface CidadeDAO {

    void cadastrar(Cidade cidade);

    List<Cidade> listar();

    Cidade ler(UUID id);

    void atualizar(UUID id, Cidade cidade);

    Cidade deletar(UUID id);
}
